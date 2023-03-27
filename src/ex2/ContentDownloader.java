package ex2;

import java.io.IOException;
import java.net.*;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;


public class ContentDownloader {
    //List <Options> ;



    public ContentDownloader(){

    }
    public void doDownload(String sourceUrl, String inputOption, String outputFile) throws IOException, Exception {
        // -bi
        HttpURLConnection connection = buildConnectionObject(sourceUrl);
        List<DenyOption>  optionsList = parseOptions(inputOption);


         for (DenyOption option : optionsList) {
             option.execute("Hello from ");
         }

    }


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
        } catch (IOException e) {
            throw new Exception("invalid url");
        }

        return con;
    }

    private List<DenyOption> parseOptions(String optionsString) throws Exception {

        List<DenyOption> options = new ArrayList<>();


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
                    throw new Exception("invalid command");
            }
        }
        return options;
    }

//    public Command parse(String[] args) {
        // Parse the command and arguments from args
  //      String options = args[0];

    //    DenyOption baseOption = null;
//        // Create the base DenyOption object
//        DenyOption baseOption = new DenyBlockedSites();
//
//        // Wrap the base DenyOption with decorators based on the provided options
//        if (options.contains("i")) {
//            baseOption = new DenyImages(baseOption);
//            //baseOption = new DenyImagesDecorator(baseOption);
//        }
//        if (options.contains("h")) {
//            baseOption = new DenyHTML(baseOption);
//            //baseOption = new DenyHTMLDecorator(baseOption);
//        }
//        if (options.contains("c")) {
//            baseOption = new DenyCookies(baseOption);
//            //baseOption = new DenyCookiesDecorator(baseOption);
//        }

        // Create the Download command with the decorated DenyOption
        //return new Download(args, baseOption);
//        DenyOption
//    }
}

