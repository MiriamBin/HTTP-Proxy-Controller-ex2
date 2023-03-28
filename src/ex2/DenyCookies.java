package ex2;

import java.util.Map;
import java.util.List;
import java.net.HttpURLConnection;

/**
 * DenyOption interface
 */
public class DenyCookies implements DenyOption {
    /**
     * execute the DenyOption
     * @param connection - the connection to execute the DenyOption on
     * @throws Exception - if the DenyOption failed
     */
    @Override
    public void execute(HttpURLConnection connection) throws Exception {
        blockCookies(connection);
    }
    /**
     * block cookies
     * @param connection - the connection to block cookies on
     * @throws Exception - if the DenyOption failed
     */
    public void blockCookies(HttpURLConnection connection) throws Exception {
        // Retrieve the response code and headers;
        Map<String, List<String>> headers = connection.getHeaderFields();

        // Check if the response contains cookies in the headers
        if (headers.containsKey("Set-Cookie")) {
            // If cookies are found, throw an exception to indicate that the response should be blocked
            throw new Exception(Consts.DENIED_ACCESS);
        }
    }
}