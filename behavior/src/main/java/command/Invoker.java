package command;

/**
 * 调用者
 *
 * @author zhaohaoren
 */
public class Invoker {
    /**
     * 需要被注入给该调用者的命令
     */
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call() {
        command.execute();
    }
}
