
package soldier.core.stoneAge;

import soldier.core.Equipment;
import soldier.core.factories.SoldierFactory;
import soldier.equipment.WeaponShield;
import soldier.equipment.WeaponSword;

public class StoneAgeSoldierFactory implements SoldierFactory {

    
    public Equipment createLeftHand(){
        return new WeaponSword();
    }
 
    public Equipment createRightHand(){
        return new WeaponShield();
    }


}
