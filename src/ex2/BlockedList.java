package ex2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public final class BlockedList {
    private static final String BLOCKED_FILE = "blocked.txt";
    private static BlockedList instance;
    private Set<String> blockedUrls = null;
    private BlockedList() {
        blockedUrls = new HashSet<>();
        loadBlockedUrls();
    }
    public static BlockedList getInstance() {
        if (instance == null) {
            instance = new BlockedList();
        }
        return instance;
    }

    private void loadBlockedUrls() {
        try {
            Path path = Paths.get(BLOCKED_FILE);
            if (Files.exists(path)) {
                List<String> lines = Files.readAllLines(path);
                blockedUrls.addAll(lines);
            }
        } catch (IOException e) {
            System.out.println("cannot read blocked.txt");
        }
    }

    public void saveBlockedUrls()  {
        try {
            Files.write(Paths.get(BLOCKED_FILE), blockedUrls);
        } catch (IOException e) {
            System.out.println("cannot write blocked.txt");
        }
    }

    public void blockUrl(String url) {
        blockedUrls.add(url);
        saveBlockedUrls();
    }

    public void unblockUrl(String url) {
        blockedUrls.remove(url);
        saveBlockedUrls();
    }

    public boolean isUrlBlocked(String url) {
        for (String blockedUrl : blockedUrls) {
            if (url.startsWith(blockedUrl)) {
                return true;
            }
        }
        return false;
    }
    public Set<String> getBlockedUrls() {
        return Collections.unmodifiableSet(blockedUrls);
    }
}



