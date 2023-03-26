package consoleController;

public class Main {
    public static void main(String[] args) {
        try {
            Console console = new Console();
            console.run();
        }
         catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}