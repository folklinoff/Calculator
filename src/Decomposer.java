public class Decomposer {
    public static boolean isOperand(String expression)
    {
        for (int i = 0; i < expression.length(); ++i)
            if (("()+-/*^").contains(String.valueOf(expression.charAt(i))))
                return false;
        return true;
    }

    public static boolean isEnclosedInBraces(String expression)
    {
        int openingBraces = 0;
        for (int i = 0; i < expression.length(); ++i)
        {
            if (expression.charAt(i) == '(')
            {
                openingBraces++;
            }
            else if (expression.charAt(i) == ')')
            {
                openingBraces--;
            }
            else if (openingBraces == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static String removeOuterBraces(String expression)
    {
        return (new StringBuilder(expression)).substring(1, expression.length() - 1);
    }

    public static Coefficients decompose(String expression)
    {
        if (expression.length() == 0)
        {
            return new Coefficients();
        }
        if (isEnclosedInBraces(expression))
        {
            expression = removeOuterBraces(expression);
        }
        if (isOperand(expression))
        {
            return Converter.convertToCoefficients(expression);
        }
        Coefficients result = convertAdditionToCoefficients(expression);
        return convertAdditionToCoefficients(expression);
    }

    public static Coefficients convertAdditionToCoefficients(String expression)
    {
        int openingBraces = 0;
        boolean isOperand = true;
        for (int i = 0; i < expression.length(); ++i)
        {
            if (expression.charAt(i) == '=')
            {
                Coefficients leftOperand = decompose(expression.substring(0, i));
                Coefficients rightOperand = decompose(expression.substring(i + 1));
                return PartCalculator.subtractTwoTrees(leftOperand, rightOperand);
            }
            if ((expression.charAt(i) == '+' || expression.charAt(i) == '-') && openingBraces == 0)
            {
                Coefficients leftOperand = decompose(expression.substring(0, i));
                Coefficients rightOperand = decompose(expression.substring(i + 1));
                if (expression.charAt(i) == '+')
                {
                    return PartCalculator.addTwoTrees(leftOperand, rightOperand);
                }
                else if (expression.charAt(i) == '-')
                {
                    return PartCalculator.subtractTwoTrees(leftOperand, rightOperand);
                }
            }
            else
            {
                if (expression.charAt(i) == '(')
                {
                    openingBraces++;
                }
                else if (expression.charAt(i) == ')')
                {
                    openingBraces--;
                }
            }
        }

        return convertMultiplicationToCoefficients(expression);
    }

    public static Coefficients convertMultiplicationToCoefficients(String expression)
    {
        int openingBraces = 0;
        Coefficients result = new Coefficients();
        for (int i = 0; i < expression.length(); ++i)
        {
            if (expression.charAt(i) == '*' && openingBraces == 0)
            {
                Coefficients leftOperand = decompose(expression.substring(0, i));
                Coefficients rightOperand = decompose(expression.substring(i + 1));

                return PartCalculator.multiplyTwoTrees(leftOperand, rightOperand);
            }
            else
            {
                if (expression.charAt(i) == '(')
                {
                    openingBraces++;
                }
                else if (expression.charAt(i) == ')')
                {
                    openingBraces--;
                }
            }
        }
        return result;
    }
}
