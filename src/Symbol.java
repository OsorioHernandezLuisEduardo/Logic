import java.util.Map;
import java.util.Set;

public class Symbol  extends  Sentence{
    private String name;
    public  Symbol(String name){
        this.name=name;
    }
    @Override
    boolean evaluate(Map<String, Boolean> model) {
        if(!model.containsKey(name))
            throw  new RuntimeException("variable "+ name + " not in model");
        return  model.get(name);
    }

    @Override
    String formula() {
        return name;
    }

    @Override
    Set<String> symbols() {
        return Set.of(name);
    }
}
