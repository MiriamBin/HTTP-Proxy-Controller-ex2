package consoleController;

import java.io.IOException;

interface Command {
    void execute() throws Exception, IOException;
}
