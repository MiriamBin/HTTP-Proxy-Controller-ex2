package ex2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class DenyCookies implements DenyOption {
    @Override
    public void execute(String url) throws Exception {
        System.out.println(url + "DenyCookies.execute");
                //blockCookies(url);
    }

    public static void blockCookies(String urlStr) throws Exception {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Disable cookie handling in the HTTP request
            connection.setRequestProperty("Cookie", "");

            // Make the HTTP request and retrieve the response code and headers
            connection.connect();
            int responseCode = connection.getResponseCode();
            Map<String, List<String>> headers = connection.getHeaderFields();

            // Check if the response contains cookies in the headers
            if (headers.containsKey("Set-Cookie")) {
                // If cookies are found, throw an exception to indicate that the response should be blocked
                throw new Exception("denied");
            }
        } catch (IOException e) {
            throw new Exception("invalid URL");
        }
    }
}
