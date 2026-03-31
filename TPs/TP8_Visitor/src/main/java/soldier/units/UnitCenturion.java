/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.units;

import soldier.core.Equipment;
import soldier.core.EquipmentException;
import soldier.core.UnitInfantry;

public class UnitCenturion extends UnitInfantry {

	public UnitCenturion(String soldierName) {
		super(soldierName, new BehaviorSoldierStd(15, 100));
	}

	/**
	 * A Centurion can have at most two equipments
	 */
	@Override
	public void addEquipment(Equipment w) {
		if (nbWeapons() > 2)
			throw new EquipmentException();
		super.addEquipment(w);
	}

}
