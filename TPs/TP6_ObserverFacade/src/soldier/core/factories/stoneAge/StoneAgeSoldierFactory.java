
package soldier.core.stoneAge;


public class StoneAgeSoldierFactory implements SoldierFactory {

    
    public Equipment createLeftHand(){
        return new WeaponSword();
    }
 
    public Equipment createRightHand(){
        return new WeaponShield();
    }


}
