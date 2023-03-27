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
        blockHtmlHttpResponse(connection);
    }
    /**
     * block HTML content
     * @param connection - the connection to url
     * @throws Exception - if the URL is invalid or HTML is found
     */
    public void blockHtmlHttpResponse(HttpURLConnection connection) throws Exception {
        String contentType = connection.getHeaderField("Content-Type");

        // Check if the response contains HTML content
        if (contentType != null && contentType.contains("text/html")) {
            throw new Exception("denied");
        }
    }
}