package ex2;
import java.util.*;
import java.util.function.Function;

/**
 * command factory
 */
public class CommandFactory {
    private final Map<String, Function<String[], Command>> commandCreators;

    /**
     * Constructor
     */
    public CommandFactory() {
        this(new HashMap<>());
    }
    /**
     * Constructor
     * @param commandCreators - the command creators
     */
    public CommandFactory(Map<String, Function<String[], Command>> commandCreators) {
        this.commandCreators = commandCreators;
    }
    /**
     * Register a command
     * @param commandKey - the command key
     * @param commandCreator - the command creator
     * @throws Exception - if the command key is already registered
     */
    public void register(String commandKey, Function<String[], Command> commandCreator) throws Exception{
        commandCreators.put(commandKey, commandCreator);
    }

    /**
     * Create a command
     * @param commandKey
     * @param commandArgs
     * @return the command
     * @throws Exception
     */
    public Command createCommand(String commandKey, String[] commandArgs) throws Exception {
        if (!commandCreators.containsKey(commandKey)) {
            throw new Exception(Consts.INVALID_COMMAND);
        }
        return commandCreators.get(commandKey).apply(commandArgs);
    }
}


