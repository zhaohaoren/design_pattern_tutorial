package command;

/**
 * 队列调用者
 *
 * @author zhaohaoren
 */
public class QueueInvoker {
    CommandQueue queue = new CommandQueue();

    public QueueInvoker(CommandQueue queue) {
        this.queue = queue;
    }

    public void call() {
        queue.execute();
    }
}
