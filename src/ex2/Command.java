package ex2;

import java.io.IOException;

interface Command {
    void execute() throws Exception, IOException;
}
