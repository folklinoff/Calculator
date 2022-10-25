import java.util.ArrayList;

public class Roots {
    private final ArrayList<Integer> roots;
    Roots(ArrayList<Integer> roots)
    {
        this.roots = roots;
    }

    public String getRoots()
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < roots.size(); ++i)
        {
            result.append("x").append(i).append(" = ").append(roots.get(i));
            if (i < roots.size() - 1)
            {
                result.append(";");
            }
            else
            {
                result.append(".");
            }
        }
        return result.toString();
    }


}
