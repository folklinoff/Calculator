package Solver;

import java.util.ArrayList;
import java.util.TreeMap;

public class LinearEquationSolver extends Solver {
    public static ArrayList<Double> getRoots(TreeMap<Integer, Integer> coefficients)
    {
        ArrayList<Double> roots = new ArrayList<>();
        roots.add(-1.0*coefficients.get(1)/coefficients.get(0));
        return roots;
    }
}
