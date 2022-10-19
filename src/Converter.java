import java.util.Map;
import java.util.TreeMap;

public class Converter {
    public static TreeMap<Integer, Integer> convertToCoefficients(String operand)
    {
        TreeMap<Integer, Integer> result = new TreeMap<>();
        try
        {
            result.put(0, Integer.parseInt(operand));
        }
        catch (Exception e)
        {
            result.put(1, 1);
        }
        return result;
    }

    public static String convertCoefficientsToEquation(TreeMap<Integer, Integer> coefficients)
    {
        boolean first = true;
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : coefficients.entrySet())
        {
            if (!first)
            {
                if (entry.getValue() > 0)
                {
                    result.append("+");
                }
            }
            if (entry.getKey() == 0)
            {
                result.append(entry.getValue());
            }
            else if (entry.getKey() == 1)
            {
                result.append(entry.getValue()).append("x");
            }
            else {
                result.append(entry.getValue()).append("x^").append(entry.getKey());
            }
            first = false;
        }
        result.append("=0");
        return result.toString();
    }
}
