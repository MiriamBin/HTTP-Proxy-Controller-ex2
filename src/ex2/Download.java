package ex2;
import java.io.IOException;

/**
 * download command
 */
public class Download implements Command  {
    private String options = null;
    private String url = null;
    private String outputFile = null;
    private final UrlValidator urlValidator = new UrlValidator();

    /**
     * Constructor
     * @param args - the command arguments
     * @throws IllegalArgumentException - if the arguments are invalid
     */
    public Download(String[] args) throws  IllegalArgumentException {
        if(2 == args.length) {
            this.url = args[0];
            this.outputFile = args[1];
        }
        else if(3 == args.length) {
            this.options = args[0];
            this.url = args[1];
            this.outputFile = args[2];
        }
        else {
            throw new IllegalArgumentException(Consts.INVALID_COMMAND);
        }
    }
    /**
     * execute the command
     * @throws Exception - if the command failed
     * @throws IOException - if the url failed
     */
    public void execute() throws Exception, IOException {
        try {
            if (urlValidator.isValid(this.url)) {
                ContentDownloader downloader = new ContentDownloader();
                downloader.doDownload(this.url, this.options, this.outputFile);
            }
        }
        catch (IOException | Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}