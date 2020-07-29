package command;

/**
 * 命令模式实现类
 *
 * @author zhaohaoren
 */
public class ConcreteCommand implements Command {

    /**
     * 一个命令绑定一个接受者
     */
    private Receiver receiver;

    public ConcreteCommand() {
        this.receiver = new Receiver();
    }

    /**
     * 通过execute调用接受者
     */
    @Override
    public void execute() {
        receiver.action();
    }
}
