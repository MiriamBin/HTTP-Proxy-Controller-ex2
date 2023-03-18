package console;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CommandFactory commandFactory = new CommandFactory();
        try {
            Scanner scanner = new Scanner(System.in);
            String commandInput;
            commandInput = scanner.next(); // TODO: create class for checking KOSHER input

            while (!commandInput.equals("q")) {
                Command command = commandFactory.getCommand(commandInput);
                command.execute();
                commandInput = scanner.next();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Program terminated");
        }

        // load block list or create new file



        // CommandFactory.addCommand(CommandType.BLOCK_URL, BlockUrlCommand::new); // create command
        // while loop ---> q
        // save block list file
    }
}