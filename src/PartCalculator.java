import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.TreeMap;

public class PartCalculator {
    // possible combinations
    // 2*3
    // 2*4*x
    // x ^ 2
    // 2 * x * 3
    //
    public static void main(String[] args)
    {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        map1.put(0,1);
        map1.put(1,1);
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        map2.put(0,1);
        map2.put(1,1);
        TreeMap<Integer, Integer> sum = addTwoTrees(map1, map2);
        TreeMap<Integer, Integer> mult = multiplyTwoTrees(map1, map2);
    }

    @Contract(pure = true)
    public static TreeMap<Integer, Integer> subtractTwoTrees(TreeMap<Integer, Integer> map1, TreeMap<Integer, Integer> map2)
    {
        TreeMap<Integer, Integer> result = new TreeMap<>(map1);
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
    public static TreeMap<Integer, Integer> addTwoTrees(TreeMap<Integer, Integer> map1, TreeMap<Integer, Integer> map2)
    {
        TreeMap<Integer, Integer> result = new TreeMap<>(map1);
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
    public static TreeMap<Integer, Integer> multiplyTwoTrees(TreeMap<Integer, Integer> map1, TreeMap<Integer, Integer> map2)
    {
        TreeMap<Integer, Integer> result = new TreeMap<>();
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
