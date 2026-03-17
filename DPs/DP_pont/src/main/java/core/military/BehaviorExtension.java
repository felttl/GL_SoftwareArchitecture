package core;

import core.BehaviorSoldier;
import core.equipment.Equipment;

public abstract class BehaviorExtension implements BehaviorSoldier {
	
	BehaviorSoldier soldier;
	protected BehaviorSoldier decorated;

	protected float attackBonus;
	protected float defenseBonus;
	protected Equipment owner;

	public BehaviorExtension(BehaviorSoldier s) {
	    soldier = s;
	}
	
	public BehaviorSoldier getParent() {
		return soldier;
	}

	public Equipment getOwner(){
		return this.owner;
	}

	void reparent(BehaviorSoldier newParent) {
		soldier = newParent;
	}
	
	@Override
	public String getName() {
		return soldier.getName();
	}

	@Override
	public float getHealthPoints() {
		return soldier.getHealthPoints();
	}

	@Override
	public boolean alive() {
		return soldier.alive();
	}

	@Override
	public void heal() {
		soldier.heal();
	}

	@Override
	public float parry(float force) {
		return soldier.parry(force);
	}

	@Override
	public float strike() {
		return soldier.strike();
	}


}
