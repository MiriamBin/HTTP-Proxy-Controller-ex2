package ex2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * deny images option
 */
public class DenyImages implements DenyOption {

    /**
     * execute the DenyOption
     * @param connection - the connection to execute the DenyOption on
     * @throws Exception - if the DenyOption failed
     */
    @Override
    public void execute(HttpURLConnection connection) throws Exception {
        blockImages(connection);
    }

  /**
     * check if the content type is an image
     * @param contentType - the content type to check
     * @return true if the content type is an image, false otherwise
     */
    public static boolean isImage(String contentType) {
        return contentType != null && contentType.startsWith("image/");
    }

    /**
     * block images
     * @param connection - the connection to block images on
     * @throws Exception - if the DenyOption failed
     */
    public static void blockImages(HttpURLConnection connection) throws Exception {

        String contentType = connection.getContentType();
        if (isImage(contentType)) {
            throw new Exception("denied");
        }
    }
}
