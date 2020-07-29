package command;

import java.util.ArrayList;

/**
 * 命令队列
 *
 * @author zhaohaoren
 */
public class CommandQueue {
    private ArrayList<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    /**
     * 循环调用每一个命令
     */
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
