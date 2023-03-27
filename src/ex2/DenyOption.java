package ex2;
import java.net.HttpURLConnection;

/**
 * DenyOption interface
 */
public interface DenyOption {
    /**
     * execute the option for download function`
     * @param connection - the connection to execute the DenyOption on
     * @throws Exception - if the DenyOption failed
     */
    void execute(HttpURLConnection connection) throws Exception;
}
