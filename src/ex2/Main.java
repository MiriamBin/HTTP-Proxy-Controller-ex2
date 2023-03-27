package ex2;


public class Main {
    public static void main(String[] args) {
        try {
            ConsoleController consoleController = new ConsoleController();
            consoleController.run();
        }
         catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}