package ex2;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * UrlValidator class
 */
public class UrlValidator implements BaseValidator {
    /**
     * validate the url
     * @param url - the url to validate
     * @return true if the url is valid
     * @throws Exception - if the url is invalid
     */
  public boolean isValid(String url)  throws Exception {
        try {
            new URL(url).toURI();
        }
        catch (URISyntaxException | MalformedURLException e) {
            throw new Exception(Consts.INVALID_URL);
        }
        return true;
    }
}
