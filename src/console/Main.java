package console;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            String commandInput = "";

            while (!commandInput.equals("q")) {
                commandInput = scanner.nextLine();
                String[] commandArgs = commandInput.split("\\s+"); // split by whitespace

                switch (commandArgs[0]) {
                    case "b":
                        Block block = new Block();
                        block.execute();
                        break;
                    case "u":
                        Unblock unblock = new Unblock();
                        unblock.execute();
                        break;
                    case "d":
                        Download download = new Download();
                        download.execute();
                        break;
                    case "p":
                        //Print print = new Print();
                    default:
                        System.out.println("Invalid command");
                        break;
                }

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