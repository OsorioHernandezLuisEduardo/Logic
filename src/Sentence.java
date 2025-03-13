import java.util.Map;
import java.util.Set;

abstract class Sentence {
    abstract  boolean evaluate(Map<String, Boolean> model);
    abstract  String formula();
    abstract Set<String> symbols();
    public static  void  validate (Sentence sentence){
        if(sentence == null){
            throw  new IllegalArgumentException("Must be a logical sentence");
        }
    }
}
