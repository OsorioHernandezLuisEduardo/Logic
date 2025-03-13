import java.util.Map;
import java.util.Set;

public class Not extends  Sentence{
    private Sentence operand;
    public Not(Sentence operand){
        validate(operand);
        this.operand=operand;
    }
    @Override
    boolean evaluate(Map<String, Boolean> model) {
        return !operand.evaluate(model);
    }

    @Override
    String formula() {
        return "¬(" + operand.formula() + ")";
    }

    @Override
    Set<String> symbols() {
        return operand.symbols();
    }
}
