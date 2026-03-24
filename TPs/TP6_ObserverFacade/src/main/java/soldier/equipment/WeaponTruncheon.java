package soldier.equipment;

import soldier.core.BehaviorSoldier;
import soldier.core.EquipmentAbstract;

/**
 * Truncheon ("matraque")
 */
public class WeaponTruncheon extends EquipmentAbstract {

    @Override
    public WeaponTruncheon clone(){
        return (WeaponTruncheon) super.clone();
    }

    @Override
    public String getName(){
        return "Truncheon";
    }

    @Override
    public BehaviorSoldier createExtension(BehaviorSoldier s){
        return new BehaviorExtLogLin(this, s);
    }
    
}
