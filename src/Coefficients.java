import java.util.*;
import java.util.stream.Collectors;

public class Coefficients extends TreeMap<Integer, Integer> {
    TreeMap<Integer, Integer> coefficients;


    Coefficients()
    {
        coefficients = new TreeMap<>(Comparator.reverseOrder());
    }

    Coefficients(Coefficients c1)
    {
        super(c1);
    }

    public Integer put(Integer key, Integer value)
    {
        return super.put(key, value);
    }

    public int get(int key)
    {
        return super.get(key);
    }

    public int size()
    {
        return super.size();
    }

    public Set<Map.Entry<Integer, Integer>> entrySet() {
        return super.entrySet();
    }
}
