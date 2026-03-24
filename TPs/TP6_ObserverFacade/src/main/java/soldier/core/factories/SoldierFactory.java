
package soldier.core.factories;

import soldier.core.Equipment;

public interface SoldierFactory {
    
    Equipment createLeftHand();
    Equipment createRightHand();

}
