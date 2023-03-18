package console;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CommandFactory {
    private final Map<String, Supplier<Command>> map = new HashMap<>(); //add interface Command

    CommandFactory() {
        addCommand("b", Block::new);
        addCommand("u", Unblock::new);
        addCommand("d", Download::new);
        //addCommand(CommandType.PRINT, BlockedSitesList::new);
        //addCommand(CommandType.EXIT, BlockedSitesList::new);
    }

    public void addCommand(String commandType, Supplier<Command> commandCreateFunction) {
        map.put(commandType, commandCreateFunction);
    }

    public Command getCommand(String commandInput) throws Exception {
        Supplier<Command> commandCreateFunction = map.get(commandInput);
        if (commandCreateFunction == null) {
            throw new Exception("Command not found");
        }
        return commandCreateFunction.get();
    }
}
