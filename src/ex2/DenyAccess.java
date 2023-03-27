package ex2;

import java.net.HttpURLConnection;

/**
 * DenyOption interface
 */
public class DenyAccess implements DenyOption {
    /**
     * execute the DenyOption
     * @param connection - the connection to execute the DenyOption on
     * @throws Exception - if the DenyOption failed
     */
    @Override
    public void execute(HttpURLConnection connection) throws Exception {
        //System.out.println(url + "DenyAccess.execute");
    }
}



