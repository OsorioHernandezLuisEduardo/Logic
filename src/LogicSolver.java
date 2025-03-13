import java.util.*;

public class LogicSolver {
    public  static boolean modelCheck(Sentence knowledge, Sentence query){
        //Obtener todos los simbolos existentes en conocimiento y consulta
        Set<String> symbols = new HashSet<>();
        symbols.addAll(knowledge.symbols());
        symbols.addAll(query.symbols());
        //Verificar todas la combinaciones posibles de los símbolos
        return checkAll(knowledge, query, new ArrayList<>(symbols), new HashMap<>());
    }
    private  static  boolean checkAll(Sentence knowledge, Sentence query, List<String> symbols, Map<String, Boolean> model){
        //Si no hay símbolos- Terminamos de asignar cada símbolo con cada valor (True, false)
        if (symbols.isEmpty()) {
            //Si la base de conocimiento es verdadera en el modelo, entonces la consulta también debe ser verdadera
            System.out.println(knowledge.evaluate(model));
            if (knowledge.evaluate(model)) {
                System.out.println("Respuesta consulta"+query.evaluate(model));
                return query.evaluate(model); //Verifica si la consulta es verdadera
            }
            return true;//únicamente interesa que la consulta sea verdadera
        }
        //Si no se han asignado todos los símbolos
        //Obtengo el primer símbolo de la lista de símbolos
        String p = symbols.remove(0);
        Map<String, Boolean> modelTrue = new HashMap<>(model);
        //Crea una copia del modelo donde p es true
        modelTrue.put(p, true);
        Map<String, Boolean> modelFalse = new HashMap<>(model);
        //Crea una copia del modelo donde p es false
        modelFalse.put(p, false);
        //Verificar los valores en ambos modelos donde p es true y p es false
        return checkAll(knowledge, query, new ArrayList<>(symbols), modelTrue) &&
                checkAll(knowledge, query, new ArrayList<>(symbols), modelFalse);
    }
}
