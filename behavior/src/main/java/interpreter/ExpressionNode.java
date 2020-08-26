package interpreter;

import java.util.ArrayList;
import java.util.Iterator;

public class ExpressionNode extends Node {

    //存储一个子表达式的命令
    private ArrayList<Node> list = new ArrayList<>();

    //第一级别解释，循环的取出所有的token
    @Override
    public void interpret(Context context) {
        while (true) {
            if (context.currentToken() == null) {
                //空的串，那就退出。
                break;
            } else if ("END".equals(context.currentToken())) {
                context.skipToken("END");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.interpret(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public void execute() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((Node) iterator.next()).execute();
        }
    }
}
