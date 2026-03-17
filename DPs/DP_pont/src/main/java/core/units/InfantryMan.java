package core.units;

import core.UnitSimple;

public class InfantryMan extends UnitSimple {

    public InfantryMan(BehaviorSoldier bs, String name){
        super(bs,name);
        this.addEquipment(new Shield(this));
    }

  
}
