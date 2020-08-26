package interpreter;

public abstract class Node {
    //解释语句的方法
    public abstract void interpret(Context context);
    //执行命令
    public abstract void execute();
}
