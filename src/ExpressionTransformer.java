public class ExpressionTransformer {
    public static String deleteSpaces(String expression)
    {
        StringBuilder exp = new StringBuilder();
        for (int i = 0; i < expression.length(); i++)
        {
            if (expression.charAt(i) != ' ')
            {
                exp.append(expression.charAt(i));
            }
        }
        return exp.toString();
    }

    public static boolean isDigit(char ch)
    {
        return (ch >= '0' && ch <= '9');
    }

    public static String addMultiplicationOperators(String expression)
    {
        for (int i = 0; i < expression.length() - 1; i++)
        {
            if (isDigit(expression.charAt(i)) && expression.charAt(i + 1) == 'x' ||
                    (isDigit(expression.charAt(i)) || expression.charAt(i) == 'x' || expression.charAt(i) == ')') && expression.charAt(i + 1) == '(' ||
                    (expression.charAt(i) == 'x' || expression.charAt(i) == ')') && isDigit(expression.charAt(i + 1)))
            {
                expression = (new StringBuilder(expression)).insert(i + 1, "*").toString();
            }

        }
        return expression;
    }

    public static String replaceMinuses(String expression)
    {
        for (int i = 0; i < expression.length() - 1; i++)
        {
            if (expression.charAt(i) == '-')
            {
                expression = (new StringBuilder(expression)).insert(i,"+(").toString();
                int openingBraces = 0;
                for (i+=3; i < expression.length() - 1; i++)
                {
                    if ((expression.charAt(i) == '+' || expression.charAt(i) == '-'
                            || expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == ')') && openingBraces == 0)
                    {
                        expression = (new StringBuilder(expression)).insert(i,')').toString();
                        break;
                    }
                    if (expression.charAt(i) == '(')
                    {
                        openingBraces++;
                    }
                    if (expression.charAt(i) == ')')
                    {
                        openingBraces--;
                    }
                }
                i++;
            }
        }
        return expression;
    }

}
