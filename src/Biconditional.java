import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Biconditional extends  Sentence{
    private Sentence left, right;
    public  Biconditional(Sentence left, Sentence right){
        this.right=right;
        this.left=left;
    }
    @Override
    boolean evaluate(Map<String, Boolean> model) {
        return left.evaluate(model) == right.evaluate(model);
    }

    @Override
    String formula() {
        return "(" + left.formula() + " <=> " + right.formula() + ")";
    }

    @Override
    public Set<String> symbols() {
        Set<String> symbols = new HashSet<>(left.symbols());
        symbols.addAll(right.symbols());
        return symbols;
    }
}
