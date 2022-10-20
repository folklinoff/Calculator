import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String[] expressions = {"-5(x - 5) (x + (6 - x) * (x - 5)) * 5"};
        for (String expression : expressions)
        {
            test(expression);
        }
    }

    public static void test(String expression) {
        expression = Transformer.deleteSpaces(expression);
        expression = Transformer.addMultiplicationOperators(expression);
        expression = Transformer.replaceMinuses(expression);
        TreeMap<Integer, Integer> coefficients = Decomposer.decompose(expression);
        System.out.println(Converter.convertCoefficientsToEquation(coefficients));
    }
}