package ex2;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * singleton class that holds the blocked urls
 */
public final class BlockedList {

    private static final String BLOCKED_FILE = "blocked.txt";
    private static BlockedList instance;
    private Set<String> blockedUrls = null;

    /**
     * private constructor
     */
    private BlockedList() {
        blockedUrls = new HashSet<>();
        loadBlockedUrls();
    }
    /**
     * get the instance of the class
     * @return the instance
     */
    public static BlockedList getInstance() {
        if (instance == null) {
            instance = new BlockedList();
        }
        return instance;
    }

    /**
     * load the blocked urls from the file
     */
    private void loadBlockedUrls() {
        try {
            Path path = Paths.get(BLOCKED_FILE);
            if (Files.exists(path)) {
                List<String> lines = Files.readAllLines(path);
                blockedUrls.addAll(lines);
            }
        } catch (IOException e) {
            System.out.println(Consts.CANNOT_READ);
        }
    }

    /**
     * save the blocked urls to the file
     */
    public void saveBlockedUrls()  {
        try {
            Files.write(Paths.get(BLOCKED_FILE), blockedUrls);
        } catch (IOException e) {
            System.out.println(Consts.CANNOT_WRITE);
        }
    }

    /**
     * add a url to the blocked list
     * @param url the url to block
     */
    public void blockUrl(String url) {
        blockedUrls.add(url);
        saveBlockedUrls();
    }

    /**
     * remove an url from the blocked list
     * @param url the url to unblock
     */
    public void unblockUrl(String url) {
        blockedUrls.remove(url);
        saveBlockedUrls();
    }

    /**
     * check if an url is blocked
     * @param url the url to check
     * @return true if the url is blocked, false otherwise
     */
    public boolean isUrlBlocked(String url) {
        for (String blockedUrl : blockedUrls) {
            if (url.startsWith(blockedUrl)) {
                return true;
            }
        }
        return false;
    }

    /**
     * get the blocked urls
     * @return
     */
    public Set<String> getBlockedUrls() {
        return Collections.unmodifiableSet(blockedUrls);
    }
}