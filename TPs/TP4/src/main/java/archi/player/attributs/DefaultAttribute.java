import java.security.KeyStore.Entry.Attribute;

public bastract class DefaultAttribute implements Player {
    
    private Attribute attr;
    private int health;

    public DefaultAttribute(Attribute attr){
        this.attr = attr;
    }

    public void parry(int dmg){
        if (dmg>=0)
            this.health-=dmg;
    }

    public int strike(){
        this.attr.strike();
    }

    public boolean isAlive(){
        return 
    }

}
