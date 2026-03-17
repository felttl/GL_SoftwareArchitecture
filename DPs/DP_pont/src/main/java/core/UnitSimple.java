package core;

public abstract class UnitSimple implements Unit {

    // disgusting protected
    protected BehaviorSoldier behavior;
    protected String name;

    private float health;


    public UnitSimple(BehaviorSoldier bs, String name){
        this.behavior = bs;
        this.name = name;
        this.health = 100;
    }
    
    public float parry(float force){
        this.health -= force;
        return force;
    }

    public float strike(){
        return 10f;
    }

    public float getHP(){
        return this.health;
    }

    public alive(){
        if (this.health > 0f) return true;
        return false;
    }

    
}
