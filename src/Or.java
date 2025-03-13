import java.util.*;

public class Or extends  Sentence{
    private List<Sentence> disjuncts;
    public  Or(Sentence... disjuncts){
        this.disjuncts = Arrays.asList(disjuncts);
    }
    @Override
    boolean evaluate(Map<String, Boolean> model) {
        return disjuncts.stream().anyMatch(d -> d.evaluate(model));
    }

    @Override
    String formula() {
        return String.join(" ∨ ", disjuncts.stream().map(Sentence::formula).toArray(String[]::new));
    }

    @Override
    Set<String> symbols() {
        Set<String> symbols = new HashSet<>();
        for (Sentence d : disjuncts) {
            symbols.addAll(d.symbols());
        }
        return symbols;
    }
}
