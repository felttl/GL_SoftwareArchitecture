package archi.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import core.BehaviorSoldier;

public class Army extends Iterable implements BehaviorSoldier  { // weird to get BehaviorSoldier here (apply decorator on an army)


    private List<BehaviorSoldier> bs;
    private HashSet<BehaviorSoldier> bsh;
    private String name;

    public Army(){
        this.bs = new ArrayList<>();
        this.name = "defaultName";
    }

    public void addSoldier(BehaviorSoldier bs){
        if (this.bsh.contains(bs)) return;
        this.bs.add(bs);
        this.bsh.add(bs);
    }

    public Iterator<BehaviorSoldier> iterrator(){
        return this.bs.iterator();
    }

    public Army(List<BehaviorSoldier> bs){
        this.bs = bs;
        this.name = "defaultName";
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean alive() {
        int alive = 0;
        int idx = -1;
        while (idx++ < this.bs.size())
            if (this.bs.get(idx).alive()) alive++;
        return alive != 0;
    }

    @Override
    public float getHealthPoints() {
        float total = 0;
        int idx = -1;
        while (idx++ < this.bs.size())
            total += this.bs.get(idx).getHealthPoints();
        return total;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void heal() {
        int idx = -1;
        while (idx++ < this.bs.size())
            this.bs.get(idx).heal();
    }

    @Override
    public float parry(float force) {
        float total = 0;
        int idx = -1;
        while (idx++ < this.bs.size())
            total += this.bs.get(idx).parry(force);
        return total;
    }

    @Override
    public float strike() {
        float total = 0;
        int idx = -1;
        while (idx++ < this.bs.size())
            total += this.bs.get(idx).strike();
        return total;
    } 

    
}
