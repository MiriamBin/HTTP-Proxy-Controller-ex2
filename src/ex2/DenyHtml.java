package ex2;
import java.net.*;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Deny HTML content
 */
public class DenyHtml implements DenyOption {
    /**
     * execute the DenyOption of HTML
     * @param connection - the connection to execute the DenyOption on
     * @throws Exception - if theURl is invalid or HTML is found
     */
    @Override
    public void execute(HttpURLConnection connection) throws Exception {
        System.out.println("BlockHtml.execute");
    }
    /**
     * block HTML content
     * @param urlString - the URL to block HTML content on
     * @throws Exception - if the URL is invalid or HTML is found
     */
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
        }
        catch (IOException e) {
            throw new Exception("invalid URL");
        }
    }
}