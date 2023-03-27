package ex2;

/**
 * BaseValidator interface
 */
public interface BaseValidator {
    /**
     * Validate a url
     * @param url - the url to validate
     * @return true if the url is valid, false otherwise
     * @throws Exception - if the url is invalid
     */
    boolean isValid(String url)  throws Exception;
}
