import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Implication extends Sentence{
    private Sentence antecedent, consequent;
    public Implication(Sentence antecedent, Sentence consequent) {
        validate(antecedent);
        validate(consequent);
        this.antecedent = antecedent;
        this.consequent = consequent;
    }
    @Override
    public boolean evaluate(Map<String, Boolean> model) {
        return !antecedent.evaluate(model) || consequent.evaluate(model);
    }

    @Override
    public String formula() {
        return "(" + antecedent.formula() + " => " + consequent.formula() + ")";
    }

    @Override
    public Set<String> symbols() {
        Set<String> symbols = new HashSet<>(antecedent.symbols());
        symbols.addAll(consequent.symbols());
        return symbols;
    }
}
