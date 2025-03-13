import java.util.*;

public class And extends  Sentence{
    private List<Sentence> conjucts;
    public And(Sentence... conjucts){
        this.conjucts= Arrays.asList(conjucts);
    }
    @Override
    boolean evaluate(Map<String, Boolean> model) {
        return conjucts.stream().allMatch(c->c.evaluate(model));
    }

    @Override
    String formula() {
        return String.join(" ∧ ", conjucts.stream().map(Sentence::formula).toArray(String[]::new));
    }

    @Override
    Set<String> symbols() {
        Set<String> symbols = new HashSet<>();
        for (Sentence c : conjucts) {
            symbols.addAll(c.symbols());
        }
        return symbols;
    }
}
