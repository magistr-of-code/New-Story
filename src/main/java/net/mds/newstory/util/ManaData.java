package net.mds.newstory.util;

public class ManaData {
    public static int addMana(IEntityDataSaver player, int amount) {
        return Data.add(player,amount,"mana",1000);
    }

    public static int RemoveMana(IEntityDataSaver player, int amount) {return Data.Remove(player,amount,"mana");}

    public static int addManaMinus(IEntityDataSaver player, int amount) {return Data.add(player,amount,"manaMinus",10000);}

    public static int RemoveManaMinus(IEntityDataSaver player, int amount) {return Data.Remove(player,amount,"manaMinus");}

}
