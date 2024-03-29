package ex2;

/**
 * Block class - implements Command interface
 */
class Block implements Command {
    /**
     * The url to block
     */
    private final String url;
    /**
     * The url validator
     */
    private final UrlValidator urlValidator = new UrlValidator();

    /**
     * Constructor
     * @param args - the arguments of the command
     * @throws IllegalArgumentException - if the arguments are invalid
     */
    public Block(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException(Consts.INVALID_COMMAND);
        }
        this.url = args[0];
    }

    /**
     * Execute the command - add the url to the blocked list
     * @throws Exception - if the url is invalid
     */
    @Override
    public void execute() throws Exception {
        if(urlValidator.isValid(url))
            BlockedList.getInstance().blockUrl(url);
    }
}
