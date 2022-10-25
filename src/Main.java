import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String[] expressions = {"(x - 5) (x + (6 - x) * (x - 5)) = 0",
                "-89(98-23-6*4+5*6*7*(7*(5+1)))+x = 0",
                "5(-7*8*9*0-x*3x*(x-1))-x*0*x*4 = 0",
                "x*x*x - x * x = 0",
                "x=0"};
        for (String expression : expressions)
        {
            test(expression);
        }
    }

    public static void test(String expression) {
        expression = Transformer.deleteSpaces(expression);
        expression = Transformer.addMultiplicationOperators(expression);
        expression = Transformer.replaceMinuses(expression);
        Coefficients coefficients = Decomposer.decompose(expression);

        System.out.println(Converter.convertCoefficientsToEquation(coefficients));
    }
}