package interpreter;

// 基本命令，最简单的命令，终结符表达式
public class PrimitiveCommandNode extends Node {
    private String name;
    private String text;

    @Override
    public void interpret(Context context) {
        name = context.currentToken();
        context.skipToken(name);
        if (!name.equals("PRINT") && !name.equals("BREAK") && !name.equals("SPACE")) {
            System.err.println("非法命令！");
        }
        if (name.equals("PRINT")) {
            text = context.currentToken();
            context.nextToken();
        }
    }

    @Override
    public void execute() {
        if (name.equals("PRINT")) {
            System.out.print(text);
        } else if (name.equals("SPACE")) {
            System.out.print(" ");
        } else if (name.equals("BREAK")) {
            System.out.println();
        }
    }
}
