package ex2;
import java.io.IOException;

/**
 * command interface
 */
interface Command {
    /**
     * execute the command
     * @throws Exception - if the command failed
     * @throws IOException - if the url failed
     */
    void execute() throws Exception, IOException;
}
