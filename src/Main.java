public class Main {
    public static void main(String[] args) {
        String[] expressions = {
                "(-7-0*x - 0 * x * x - 0 * x * x * x) = 0",
                "-8*(9)+x + x * x + x * x * x = 0",
                "-8*9+x + x * x + x * x * x = 0",
                "x*x*x - x * x = 0",
                "(x - 5) (x + (6 - x) * (x - 5)) = 0",
                "x=0"
        };
        for (String expression : expressions)
        {
            test(expression);
        }
    }

    public static void test(String expression) {
        expression = ExpressionTransformer.deleteSpaces(expression);
        expression = ExpressionTransformer.addMultiplicationOperators(expression);
        expression = ExpressionTransformer.replaceMinuses(expression);
        Coefficients coefficients = Decomposer.decompose(expression);
        CoefficientsTransformer.deleteZeros(coefficients);
        System.out.println(Converter.convertCoefficientsToEquation(coefficients));
    }
}