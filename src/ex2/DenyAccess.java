package ex2;

import java.net.HttpURLConnection;
import java.util.Set;

/**
 * DenyOption interface
 */
public class DenyAccess implements DenyOption {
    /**
     * execute the DenyOption
     * @param connection - the connection to execute the DenyOption on
     * @throws Exception - if the DenyOption failed
     */
    @Override
    public void execute(HttpURLConnection connection) throws Exception {
        blockAccess(connection);
    }

    /**
     * block access to urls that are in the blocked list
     * @param connection - the connection to block access on
     * @throws Exception - if the DenyOption failed
     */
    public void blockAccess(HttpURLConnection connection) throws Exception {
        Set<String> blockedUrls = BlockedList.getInstance().getBlockedUrls();
        String url = connection.getURL().toString();
        for (String blockedUrl : blockedUrls) {
            if (url.equals(blockedUrl) || blockedUrl.startsWith(url)) {
                throw new Exception(Consts.DENIED_ACCESS);
            }
        }
    }
}




