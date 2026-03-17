
package soldier.core.modernAge;

public class ModernSoldierFactory implements SoldierFactory {
    
    public Equipment createLeftHand(){
        return new WeaponGun();
    }
 
    public Equipment createRightHand(){
        return new WeaponTruncheon();
    }


}
