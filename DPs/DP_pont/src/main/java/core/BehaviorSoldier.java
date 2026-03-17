package core;

public interface BehaviorSoldier {
	public float parry(float force);  // Returns the force that the soldier did not absorb
	public float strike();
	public float getHealthPoints();
	public void heal();
	public boolean alive();
	public String getName();
}
