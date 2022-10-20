import com.sun.source.tree.Tree;

import javax.naming.InsufficientResourcesException;
import javax.naming.StringRefAddr;
import java.util.Objects;
import java.util.SimpleTimeZone;
import java.util.TreeMap;

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

    public static TreeMap<Integer, Integer> decompose(String expression)
    {
        if (expression.length() == 0)
            return new TreeMap<>();
        if (isOperand(expression))
        {
            return Converter.convertToCoefficients(expression);
        }
        if (isEnclosedInBraces(expression))
        {
            expression = removeOuterBraces(expression);
        }
        return convertAdditionToTree(expression);
    }

    public static TreeMap<Integer, Integer> convertAdditionToTree(String expression)
    {
        int openingBraces = 0;
        boolean isOperand = true;
        TreeMap<Integer, Integer> result = new TreeMap<>();
        for (int i = 0; i < expression.length(); ++i)
        {
            if ((expression.charAt(i) == '+' || expression.charAt(i) == '-') && openingBraces == 0)
            {
                TreeMap<Integer, Integer> leftOperand = decompose(expression.substring(0, i));
                TreeMap<Integer, Integer> rightOperand = decompose(expression.substring(i + 1));
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

        return convertMultiplicationToTree(expression);
    }

    public static TreeMap<Integer, Integer> convertMultiplicationToTree(String expression)
    {
        int openingBraces = 0;
        TreeMap<Integer, Integer> result = new TreeMap<>();
        for (int i = 0; i < expression.length(); ++i)
        {
            if (expression.charAt(i) == '*' && openingBraces == 0)
            {
                TreeMap<Integer, Integer> leftOperand = decompose(expression.substring(0, i));
                TreeMap<Integer, Integer> rightOperand = decompose(expression.substring(i + 1));

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
