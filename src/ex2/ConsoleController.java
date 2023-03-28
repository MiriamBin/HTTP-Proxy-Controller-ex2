package ex2;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * console controller
 */
public class ConsoleController {
    private final CommandFactory commandFactory = new CommandFactory();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * run the console controller
     * @throws Exception - if the command failed
     */
    public void run() throws Exception {
        registerAllCommands();

        while (true) {
            String input = readConsoleInput();

            if (input.equalsIgnoreCase(Consts.KEY_QUIT_COMMAND)) {
                break;
            }

            try {
                String[] parts = parseCommand(input);
                String commandKey = parts[0];
                String[] commandArgs = Arrays.copyOfRange(parts, 1, parts.length);
                Command command = commandFactory.createCommand(commandKey, commandArgs);

                if (command != null) {
                    command.execute();
                }
            }
            catch (Exception | IOException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /**
     * register all the commands
     * @throws Exception - if there is a problem with the command
     */
    private void registerAllCommands() throws Exception{
        this.commandFactory.register(Consts.KEY_BLOCK_COMMAND, Block::new);
        this.commandFactory.register(Consts.KEY_UNBLOCK_COMMAND, Unblock::new);
        this.commandFactory.register(Consts.KEY_PRINT_COMMAND, Print::new);
        this.commandFactory.register(Consts.KEY_DOWNLOAD_COMMAND, Download::new);
    }
    /**
     * read command from the user
     * @return the input
     */
    private String readConsoleInput() {
        String input = "";
        while (input.isEmpty()) {
            input = scanner.nextLine().trim(); // skip empty lines
        }
        return input;
    }

    /**
     * parse the command from the user input - for getting the parts of the command
     * @param input - the input
     * @return the command
     */
    private String[] parseCommand(String input) {
        return input.split("\\s+");
    }
}