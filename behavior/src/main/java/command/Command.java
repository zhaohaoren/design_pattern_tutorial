package command;

/**
 * 抽象命令类
 *
 * @author zhaohaoren
 */
public interface Command {
    /**
     * 所有命令都走这个方法来执行 接收者的调用
     */
    void execute();
}
