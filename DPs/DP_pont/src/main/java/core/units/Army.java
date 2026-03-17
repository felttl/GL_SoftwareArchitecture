package core.units;

import core.Unit;

public class Army implements Unit {

    // happy private !
    private List<BehaviorSoldier> units;
    // prot"shit
    protected String name;

    public Army(String name, List<BehaviorSoldier> units){
        this.name = name;
        this.units = units;
    }

    // impls here :
    

}
