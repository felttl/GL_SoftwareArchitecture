/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 UniversitÃ¯Â¿Â½ Bordeaux.
 */
package soldier.core;

public abstract class EquipmentAbstract implements Equipment {

	@Override
	public EquipmentAbstract clone() {
		try {
			return (EquipmentAbstract) super.clone();
		} catch (Exception e) {
		}
		return this;
	}

}
