package Solver;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public abstract class Solver {
    public static int getMaxPower(TreeMap<Integer, Integer> coefficients)
    {
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : coefficients.entrySet())
        {
            max = Math.max(entry.getKey(), max);
        }
        return max;
    }

    public static EquationType getEquationType (TreeMap<Integer, Integer> coefficients)
    {
        return EquationType.typeOf(Math.min(getMaxPower(coefficients), 3));
    }

    public static ArrayList<Double> getRoots(TreeMap<Integer, Integer> coefficients)
    {
        return switch (getEquationType(coefficients)) {
            case value -> ConstantEquationSolver.getRoots(coefficients);
            case linearEquation -> LinearEquationSolver.getRoots(coefficients);
            case quadraticEquation -> QuadraticEquationSolver.getRoots(coefficients);
            case higherOrderEquation -> HigherOrderEquationSolver.getRoots(coefficients);
        };
    }
}
