package ex2;
import java.util.Set;

/**
 * Print class
 */
class Print implements Command {
    /**
     * constructor
     * @param args - the arguments for the command
     * @throws IllegalArgumentException - if the arguments are invalid
     */
    public Print(String[] args) throws IllegalArgumentException {
        if (args.length != 0) {
            throw new IllegalArgumentException("invalid command");
        }
    }
    /**
     * execute the command - print the blocked urls
     */
    @Override
    public void execute() {
        Set<String> blockedUrls = BlockedList.getInstance().getBlockedUrls();
        blockedUrls.stream().sorted().forEach(System.out::println);
    }
}
