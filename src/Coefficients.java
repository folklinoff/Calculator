import java.util.*;

public class Coefficients extends TreeMap<Integer, Integer> {
    public TreeMap<Integer, Integer> coefficients;
    Coefficients()
    {
        super();
        coefficients = new TreeMap<>();
    }

    Coefficients(Coefficients c1)
    {
        super(c1);
        coefficients = c1.coefficients;
    }

    @Override
    public Integer remove(Object key) {
        return coefficients.remove(key);
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return coefficients.put(key, value);
    }

    @Override
    public Integer get(Object key) {
        return coefficients.get(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return coefficients.containsKey(key);
    }

    public Set<Map.Entry<Integer, Integer>> entrySet()
    {
        TreeSet<Map.Entry<Integer, Integer>> result = new TreeSet<>((o1, o2) -> {
            if (o1.getKey() > o2.getKey())
                return -1;
            if (o1.getKey().equals(o2.getKey()))
                return 0;
            return 1;
        });
        result.addAll(coefficients.entrySet());
        return result;
    }
}
