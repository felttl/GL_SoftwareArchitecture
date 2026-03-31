/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Universite Bordeaux.
 */
package soldier.core;

import soldier.equipment.WeaponVisitor;

public abstract class EquipmentToy extends EquipmentAbstract {

	@Override
	public void accept(WeaponVisitor v) {
		v.visit(this);
	}
}
