
package soldier.core.factories.modernAge;

import soldier.core.Equipment;
import soldier.core.factories.SoldierFactory;
import soldier.equipment.WeaponGun;
import soldier.equipment.WeaponTruncheon;

public class ModernSoldierFactory implements SoldierFactory {
    
    public Equipment createLeftHand(){
        return new WeaponGun();
    }
 
    public Equipment createRightHand(){
        return new WeaponTruncheon();
    }


}
