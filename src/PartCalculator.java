import org.jetbrains.annotations.Contract;

import java.util.Map;

public class PartCalculator {
    // possible combinations
    // 2*3
    // 2*4*x
    // x ^ 2
    // 2 * x * 3
    //
    public static void main(String[] args)
    {
        Coefficients map1 = new Coefficients();
        map1.put(0,1);
        map1.put(1,1);
        Coefficients map2 = new Coefficients();
        map2.put(0,1);
        map2.put(1,1);
        Coefficients sum = addTwoTrees(map1, map2);
        Coefficients mult = multiplyTwoTrees(map1, map2);
    }

    @Contract(pure = true)
    public static Coefficients subtractTwoTrees(Coefficients map1, Coefficients map2)
    {
        Coefficients result = new Coefficients(map1);
        for (Map.Entry<Integer, Integer> entry : map2.entrySet())
        {
            if (result.containsKey(entry.getKey()))
            {
                result.put(entry.getKey(), result.get(entry.getKey()) - entry.getValue());
            }
            else
            {
                result.put(entry.getKey(), -entry.getValue());
            }
        }
        return result;
    }

    @Contract(pure = true)
    public static Coefficients addTwoTrees(Coefficients map1, Coefficients map2)
    {
        Coefficients result = new Coefficients(map1);
        for (Map.Entry<Integer, Integer> entry : map2.entrySet())
        {
            if (result.containsKey(entry.getKey()))
            {
                result.put(entry.getKey(), result.get(entry.getKey()) + entry.getValue());
            }
            else
            {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    @Contract(pure = true)
    public static Coefficients multiplyTwoTrees(Coefficients map1, Coefficients map2)
    {
        Coefficients result = new Coefficients();
        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet())
        {
            for (Map.Entry<Integer, Integer> entry2 : map2.entrySet())
            {
                int power = entry1.getKey() + entry2.getKey();
                if (result.containsKey(power))
                {
                    result.put(power, result.get(power) + entry2.getValue() * entry1.getValue());
                }
                else
                {
                    result.put(power, entry2.getValue() * entry1.getValue());
                }
            }
        }
        return result;
    }
}
