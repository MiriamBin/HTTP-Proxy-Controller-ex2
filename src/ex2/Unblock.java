package ex2;

/**
 * Unblock url class
 */
class Unblock implements Command {
    private final String url;
    /**
     * Constructor
     * @param args - the command arguments
     * @throws IllegalArgumentException - if the arguments are invalid
     */
    public Unblock(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException(Consts.INVALID_COMMAND);
        }
        this.url = args[0];
    }
    /**
     * execute the command - unblock the url - delete it from the blocked list
     */
    @Override
    public void execute() {
        if (BlockedList.getInstance().isUrlBlocked(url)) {
            BlockedList.getInstance().unblockUrl(url);
        }
    }
}
