package consoleController;

class Download implements Command {

//    private String url;
//    private String outputFile;
////    private List<DenyOption> options;
//
//    public Download(String[] args) {
//        if (args.length != 3) {
//            throw new IllegalArgumentException("Invalid number of arguments");
//        }
//
//        this.url = args[1];
//        this.outputFile = args[2];
//        // TODO: add options
////        this.options = parseOptions(args[0]);
//    }

    public void execute() {
    }


/*
    @Override
    public void execute() {
        HTTPDownloader downloader = new HTTPDownloader();
        boolean isDenied = false;

        for (DenyOption option : options) {
            if (option.shouldDeny(url)) {
                System.out.println("denied");
                isDenied = true;
                break;
            }
        }

        if (!isDenied) {
            if (downloader.download(url, outputFile)) {
                System.out.println("Downloaded: " + url);
            } else {
                System.out.println("cannot write output file");
            }
        }
    }
*/
}
