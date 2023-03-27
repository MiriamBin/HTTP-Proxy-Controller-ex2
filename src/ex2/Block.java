package ex2;

class Block implements Command {
    private final String url;
    private final UrlValidator urlValidator = new UrlValidator();

    public Block(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("invalid command");
        }
        this.url = args[0];
    }
    @Override
    public void execute() throws Exception {
        if(urlValidator.isValid(url))
            BlockedList.getInstance().blockUrl(url);
    }

}
