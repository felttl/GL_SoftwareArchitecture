/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 UniversitÃ© Bordeaux.
 */
package soldier.core;

public interface BehaviorSoldier {
	public float getHealthPoints();

	public boolean alive();

	public void heal();

	public float parry(float force);

	public float strike();
}
