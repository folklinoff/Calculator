import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Converter {
    public static Coefficients convertToCoefficients(String operand)
    {
        Coefficients result = new Coefficients();
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

    public static StringBuilder entryToAddend(Map.Entry<Integer, Integer> entry)
    {
        StringBuilder result = new StringBuilder();
        if (entry.getValue() < 0)
        {
            result.append("-");
        }
        if (Math.abs(entry.getValue()) != 1)
        {
            result.append(Math.abs(entry.getValue()));
        }
        if (entry.getKey() >= 1)
        {
            result.append("x");
        }
        if (entry.getKey() >= 2)
        {
            result.append("^").append(entry.getKey());
        }
        return result;
    }

    public static String convertCoefficientsToEquation(TreeMap<Integer, Integer> coefficients)
    {
        boolean first = true;
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : coefficients.entrySet())
        {
            if (entry.getValue() == 0)
            {
                continue;
            }
            if (!first)
            {
                if (entry.getValue() > 0)
                {
                    result.append("+");
                }
            }
            result.append(entryToAddend(entry));
            first = false;
        }
        result.append("=0");
        return result.toString();
    }
}
