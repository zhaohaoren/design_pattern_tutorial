package interpreter;

public class LoopCommandNode extends Node {

    private int number;
    private Node commandNode;

    @Override
    public void interpret(Context context) {
        context.skipToken("LOOP");
        number = context.currentNumber();
        context.nextToken();
        //LOOP 后面需要一个表达式，这里就是取得LOOP后面的表达式
        commandNode = new ExpressionNode();
        commandNode.interpret(context);
    }

    @Override
    public void execute() {
        for (int i = 0; i < number; i++) {
            commandNode.execute();
        }
    }
}
