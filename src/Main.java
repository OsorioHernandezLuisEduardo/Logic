//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Symbol llueve= new Symbol("llueve");
        Symbol maria= new Symbol("maria");
        Symbol pepe= new Symbol("pepe");

        And knowledge= new And(
            new Implication(new Not(llueve), maria),
            new Or(maria, pepe),
            new  Not( new And(maria, pepe)),
            pepe
        );
        //System.out.println(new Implication(new Not(llueve), maria).formula());
        LogicSolver.modelCheck(knowledge, pepe);
    }
}