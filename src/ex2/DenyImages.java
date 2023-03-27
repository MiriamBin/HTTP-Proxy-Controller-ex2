package ex2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DenyImages implements DenyOption {

    @Override
    public void execute(String url) throws Exception {
        System.out.println(url + "DenyImages.execute");
                //blockImages(url);
    }

    public static boolean isImage(String contentType) {
        return contentType != null && contentType.startsWith("image/");
    }

    // not sure if this is the best way to do this *********************************
    public static void blockImages(String urlStr) throws Exception {
        HttpURLConnection connection;
        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            String contentType = connection.getContentType();
            if (isImage(contentType)) {
                throw new Exception("denied");
            }
        } catch (IOException e) {
            throw new Exception("invalid URL");
        }
    }
}
