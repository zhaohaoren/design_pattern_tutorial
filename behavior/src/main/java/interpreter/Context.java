package interpreter;

import java.util.StringTokenizer;

public class Context {
    //StringTokenizer将字符串分割为单个word，每个word叫做token
    private StringTokenizer tokenizer;
    //当前字符串标记
    private String currentToken;

    public Context(String text) {
        this.tokenizer = new StringTokenizer(text);
        nextToken();
    }

    //返回下一个标记
    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    //返回当前的标记
    public String currentToken() {
        return currentToken;
    }

    //跳过标记，说明这里语法有问题
    public void skipToken(String token) {
        if (!token.equals(currentToken)) {
            System.out.println("错误提示：" + currentToken + "解释错误！");
        }
        nextToken();
    }

    //如果当前的标记是数字，返回其数组
    public int currentNumber() {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            System.err.println("错误提示：" + e);
        }
        return number;
    }
}
