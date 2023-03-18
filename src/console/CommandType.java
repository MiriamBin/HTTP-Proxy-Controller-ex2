package console;

public enum CommandType {
    BLOCK_URL('b'),
    UNBLOCK_URL('u'),
    PRINT('p'),
    EXIT('q'),
    DOWNLOAD('d');

    private final char value;

    private CommandType(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

public static CommandType valueOf(char value) throws Exception {
        for (CommandType commandType : CommandType.values()) {
            if (commandType.getValue() == value) {
                return commandType;
            }
        }
        throw new Exception("Command not found"); // TODO:
    }
}
