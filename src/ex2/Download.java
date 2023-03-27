package ex2;
import java.io.IOException;

public class Download implements Command {

    private String options = null;
    private String url = null;
    private String outputFile = null;

    public Download(String[] args) throws IllegalArgumentException {
        if (2 > args.length || 3 < args.length) {
            throw new IllegalArgumentException("invalid command");
        }
        //TODO: ADD VALIDATION

        if(2 == args.length)
        {
            this.options = args[0];
            this.url = args[1];
        }

        if(3 == args.length)
        {
            this.options = args[0];
            this.url = args[1];
            this.outputFile = args[2];
        }
    }

    public void execute() throws Exception, IOException {

        ContentDownloader downloader = new ContentDownloader();
        downloader.doDownload(this.url, this.options, this.outputFile);


    }


}