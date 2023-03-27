package ex2;

import java.util.*;
import java.util.function.Function;

public class CommandFactory {
    private final Map<String, Function<String[], Command>> commandCreators;
    public CommandFactory() {
        this(new HashMap<>());
    }
    public CommandFactory(Map<String, Function<String[], Command>> commandCreators) {
        this.commandCreators = commandCreators;
    }
    public void register(String commandKey, Function<String[], Command> commandCreator) throws Exception{
        commandCreators.put(commandKey, commandCreator);
    }
    public Command createCommand(String commandKey, String[] commandArgs) throws Exception {
        if (!commandCreators.containsKey(commandKey)) {
            throw new Exception("invalid command");
        }
        return commandCreators.get(commandKey).apply(commandArgs);
    }
}


