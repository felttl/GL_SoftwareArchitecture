/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universitz Bordeaux.
 */
package soldier.units;

import soldier.core.Equipment;
import soldier.core.EquipmentException;
import soldier.core.UnitRider;

public class UnitBikerMan extends UnitRider {

	public UnitBikerMan(String soldierName) {
		super(soldierName, new BehaviorSoldierStd(20, 120));
	}

	/**
	 * A BikerMan can have at most one equipment
	 */
	@Override
	public void addEquipment(Equipment w) {
		if (nbWeapons() > 2)
			throw new EquipmentException();
		super.addEquipment(w);
	}

}
