package Solver;

import java.util.ArrayList;
import java.util.TreeMap;

public class QuadraticEquationSolver extends Solver{
    public static ArrayList<Double> getRoots(TreeMap<Integer, Integer> coefficients)
    {
        ArrayList<Double> roots = new ArrayList<>();
        int a = coefficients.get(2);
        int b = coefficients.get(1);
        int c = coefficients.get(0);
        double D = b * b - 4 * a * c;
        roots.add((-1.0*b+Math.sqrt(D))/(2 * a));
        roots.add((-1.0*b-Math.sqrt(D))/(2 * a));
        return roots;
    }
}
