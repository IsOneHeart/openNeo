package openNeo.old.test;

import openNeo.old.PotionNewTable;
//import neostar.PotionTable;

public class PotionTest {
    public static void main(String[] args) {
        //PotionTable potion = new PotionTable();
        PotionNewTable potion = new PotionNewTable();
        potion.add("night_vision");
        potion.add("invisibility");
        potion.add("leaping");
        potion.add("fire_resistance");
        potion.add("swiftness");
        potion.add("slowness");
        potion.add("water_breathing");
        potion.add("healing");
        potion.add("harming");
        potion.add("poison");
        potion.add("regeneration");
        potion.add("strength");
        potion.add("weakness");
        potion.add("levitation");
        potion.add("luck");
        potion.add("turtle_master");
        potion.add("slow_falling");
        potion.add("infested");
        potion.add("oozing");
        potion.add("weaving");
        potion.add("wind_charged");

        potion.generate();
        potion.save();
    }
}
