package ex2;

//TODO:
//import java.net.MalformedURLException;
//import java.net.URISyntaxException;
//import java.net.URL;

class Unblock implements Command {
    private final String url;
    public Unblock(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
        this.url = args[0];
    }

    @Override
    public void execute() {
        if (BlockedList.getInstance().isUrlBlocked(url)) {
            BlockedList.getInstance().unblockUrl(url);
        }
    }

//TODO:  ASK Solange
//    public Unblock(String[] args) throws Exception {
//        if (args.length != 1) {
//            throw new IllegalArgumentException("Invalid number of arguments");
//        }
//        this.url = urlValidator(args[0]);
//    }
//    public String urlValidator(String url) throws Exception {
//        try {
//            new URL(url).toURI();
//        }
//        catch (URISyntaxException | MalformedURLException e) {
//            throw new Exception("invalid URL");
//        }
//        return url;
//    }
}
