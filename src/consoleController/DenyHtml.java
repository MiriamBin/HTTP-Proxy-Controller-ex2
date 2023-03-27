package consoleController;

import java.net.*;
import java.io.*;
import java.util.List;
import java.util.Map;

public class DenyHtml implements DenyOption {

    @Override
    public void execute(String url) throws Exception {
        System.out.println(url + "BlockHtml.execute");
    }

    public static void blockHtmlHttpResponse(String urlString) throws Exception {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Make the HTTP request and retrieve the response code and headers
            conn.connect();
            int responseCode = conn.getResponseCode();
            Map<String, List<String>> headers = conn.getHeaderFields();

            // Check if the response contains HTML content
            if (headers.containsKey("Content-Type") && headers.get("Content-Type").contains("text/html")) {
                throw new Exception("denied");
            }
        } catch (IOException e) {
            throw new Exception("invalid URL");
        }
    }
}