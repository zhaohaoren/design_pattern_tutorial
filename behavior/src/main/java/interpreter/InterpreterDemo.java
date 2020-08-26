package interpreter;

public class InterpreterDemo {
    public static void main(String[] args) {
        String text = "LOOP 2 PRINT i SPACE PRINT am SPACE PRINT justin BREAK END PRINT hello SPACE PRINT world";
        Context context = new Context(text);
        Node node = new ExpressionNode();
        node.interpret(context);
        node.execute();
    }
}
