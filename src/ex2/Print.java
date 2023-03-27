package ex2;
import java.util.Set;

class Print implements Command {
    public Print(String[] args) throws IllegalArgumentException {
        if (args.length != 0) {
            throw new IllegalArgumentException("invalid command");
        }
    }
    @Override
    public void execute() {
        Set<String> blockedUrls = BlockedList.getInstance().getBlockedUrls();
        blockedUrls.stream().sorted().forEach(System.out::println);
    }
}
