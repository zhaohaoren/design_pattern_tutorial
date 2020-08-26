package interpreter;

// 抽象语法树上代表命令的节点
public class CommandNode extends Node {
    private Node node;

    @Override
    public void interpret(Context context) {
        if (context.currentToken().equals("LOOP")) {
            node = new LoopCommandNode();
            node.interpret(context);
        } else {
            node = new PrimitiveCommandNode();
            node.interpret(context);
        }
    }

    @Override
    public void execute() {
        node.execute();
    }
}
