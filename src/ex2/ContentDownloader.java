package ex2;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.net.HttpURLConnection;

/**
 * ContentDownloader class
 */
public class ContentDownloader {
    public ContentDownloader(){}
    public void doDownload(String sourceUrl, String inputOption, String outputFile) throws IOException, Exception {
        // -bi
        HttpURLConnection connection = buildConnectionObject(sourceUrl);

        if(inputOption != null) {
            List<DenyOption> optionsList = parseOptions(inputOption);
            for (DenyOption option : optionsList) {
                option.execute(connection);
            }
        }

        // Download the content and write it to a file
        try (InputStream inputStream = connection.getInputStream();
             OutputStream outputStream = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // Handle any errors that occur during the download
            throw new Exception(Consts.CANNOT_WRITE_OUTPUT_FILE);
        }
    }

    /**
     * build the connection object
     * @param sourceUrl - the url to connect to
     * @return the connection object
     * @throws Exception - if the connection failed
     */
    private HttpURLConnection buildConnectionObject(String sourceUrl) throws Exception {
        HttpURLConnection con;
        try {
            URL url = new URL(sourceUrl);
            // this does not connect to the URL but only build the connection object
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // now we connect
            con.connect();
            // get the HTTP response code
            int responseCode = con.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new Exception(String.valueOf(responseCode));
            }
        }
        catch (IOException e) {
            throw new Exception(Consts.INVALID_URL);
        }
        return con;
    }

    /**
     * parse the options - to get the list of options
     * @param optionsString - the options string
     * @return the list of options
     * @throws Exception - if the options are invalid
     */
    private List<DenyOption> parseOptions(String optionsString) throws Exception {

        if(!optionsString.startsWith("-") && optionsString.length() > 0)
            throw new Exception(Consts.INVALID_COMMAND);

        optionsString = optionsString.replace("-","");

        List<DenyOption> options = new ArrayList<>();

        /**
         * for each char in the options string
         * create the relevant DenyOption object
         * and add it to the list
         */
        for (char optionAsChar : optionsString.toCharArray()) {

            switch (optionAsChar) {
                case 'b':
                    options.add(new DenyAccess());
                    break;
                case 'i':
                    options.add(new DenyImages());
                    break;
                case 'h':
                    options.add(new DenyHtml());
                    break;
                case 'c':
                    options.add(new DenyCookies());
                    break;
                default:
                    throw new Exception(Consts.INVALID_OPTION);
            }
        }
        return options;
    }
}

