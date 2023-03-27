package consoleController;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlValidator implements BaseValidator {

  public boolean isValid(String url)  throws Exception
    {
        try {
            new URL(url).toURI();
        }
        catch (URISyntaxException | MalformedURLException e) {
            throw new Exception("invalid URL");
        }
        return true;
    }
}
