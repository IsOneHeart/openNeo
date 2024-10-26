package openNeo.old.test;

import openNeo.old.PaintingNewTable;
//import neostar.PaintingTable;

import java.util.ArrayList;
import java.util.List;

public class PaintingTest {
    public static void main(String[] args) {
        //PaintingTable p = new PaintingTable();
        PaintingNewTable p = new PaintingNewTable();
        List<String> ps = new ArrayList<>();
        ps.add("alban");
        ps.add("aztec");
        ps.add("aztec2");
        ps.add("backyard");
        ps.add("baroque");
        ps.add("bomb");
        ps.add("bouquet");
        ps.add("burning_skull");
        ps.add("bust");
        ps.add("cavebird");
        ps.add("changing");
        ps.add("cotan");
        ps.add("courbet");
        ps.add("creebet");
        ps.add("donkey_kong");
        ps.add("earth");
        ps.add("endboss");
        ps.add("fern");
        ps.add("fighters");
        ps.add("finding");
        ps.add("fire");
        ps.add("graham");
        ps.add("humble");
        ps.add("kebab");
        ps.add("lowmist");
        ps.add("match");
        ps.add("meditative");
        ps.add("orb");
        ps.add("owlemons");
        ps.add("painting");
        ps.add("passage");
        ps.add("pigscene");
        ps.add("plant");
        ps.add("pointer");
        ps.add("pond");
        ps.add("pool");
        ps.add("prairie_ride");
        ps.add("sea");
        ps.add("skeleton");
        ps.add("skull_and_roses");
        ps.add("stage");
        ps.add("sunflowers");
        ps.add("sunset");
        ps.add("tides");
        ps.add("unpacked");
        ps.add("void");
        ps.add("wanderer");
        ps.add("wasteland");
        ps.add("water");
        ps.add("wind");
        ps.add("wither");
        p.add(ps);
        p.generate();
        p.save();
    }
}
