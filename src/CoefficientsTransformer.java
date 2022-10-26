import java.util.Map;

public class CoefficientsTransformer {
    public static void deleteZeros(Coefficients coefficients)
    {
        for (Map.Entry<Integer, Integer> entry : coefficients.entrySet()){
            if (entry.getValue() == 0)
            {
                coefficients.remove(entry.getKey());
            }
        }
    }
}
