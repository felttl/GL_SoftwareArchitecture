package core;

import java.util.Iterator;

import core.equipment.Equipment;

// DRY = Don't Repeat Yourself
public interface Unit extends BehaviorSoldier{


    String getName();

    void addUnit();
    void removeUnit(Unit unit);
    Iterator<Unit> getUnits();

    void addEquipment(Equipment eq);
    void removeEquipment(Equipment eq);
    Iterator<Equipment> getEquipments();
    
    
}
