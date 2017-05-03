public class TernaryExpressionParser {
    public String parseTernary(String expression) {
        while (expression.length() > 1) {
            int index = expression.indexOf('?');
            int cnt = 1;
            for (int i = index + 1; i < expression.length(); i++) {
                if (expression.charAt(i) == '?') cnt++;
                else if (expression.charAt(i) == ':') cnt--;
                if (cnt == 0) {
                    if (expression.charAt(index - 1) == 'T') {
                        expression = expression.substring(index + 1, i);
                    } else {
                        expression = expression.substring(i + 1);
                    }
                    break;
                }
            }
        }
        return expression;
    }
}
