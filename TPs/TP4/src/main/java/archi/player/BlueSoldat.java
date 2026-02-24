
package archi.player;

public class BlueSoldat implements Soldat {

    private int health;

    public BluePlayer(){
        this.health = 100;
    }

    public void parry(int dmg){

    }

    public int strike(){

    }

    public boolean isAlive(){
        return this.health > 0;
    }
    
}
