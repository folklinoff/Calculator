package Solver;

import java.util.Map;

public enum EquationType
{
    value(0),
    linearEquation(1),
    quadraticEquation(2),
    higherOrderEquation(3);

    private final int type;
    private static Map<Integer, EquationType> map;
    static {
        for (EquationType equationType : EquationType.values())
        {
            map.put(value.type, equationType);
        }
    }
    EquationType(int type)
    {
        this.type = type;
    }

    public int getType()
    {
        return type;
    }

    public static EquationType typeOf(int equationType)
    {
        return map.get(equationType);
    }
}
