package consoleController;
import java.net.*;

class Block implements Command {
    private final String url;

    public Block(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new RuntimeException("invalid command");
        }
        this.url = args[0];
    }
    @Override
    public void execute() throws Exception {
        BlockedList.getInstance().blockUrl(urlValidator(url));
    }
    public String urlValidator(String url) throws Exception {
        try {
            new URL(url).toURI();
        }
        catch (URISyntaxException | MalformedURLException e) {
            throw new Exception("invalid URL");
        }
        return url;
    }
}
