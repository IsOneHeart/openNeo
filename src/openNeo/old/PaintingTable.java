package openNeo.old;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaintingTable {
    protected String propertiesValue = "type=item\n" +
            "matchItems=painting\n" +
            "nbt.EntityTag.variant=minecraft:";
    protected List<String> propertiesArray = new ArrayList<>();
    protected List<String> paintings = new ArrayList<>();
    protected String path = "";

    public void add(String egg) {
        paintings.add(egg);
    }

    public void add(List<String> eggs) {
        this.paintings.addAll(eggs);
    }

    public void remove(String egg) {
        paintings.remove(egg);
    }

    public void remove(List<String> eggs) {
        this.paintings.removeAll(eggs);
    }

    public void clear() {
        paintings.clear();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void generate() {
        for (String painting : paintings) {
            String propertiesResult = propertiesValue + painting;
            propertiesArray.add(propertiesResult);
        }
    }

    public void print() {
        for (String painting : paintings)
            System.out.println(painting);
    }

    public void save() {
        try {
            for (int i = 0; i < paintings.size(); i++) {
                String painting = paintings.get(i);
                String propertiesResult = propertiesArray.get(i);

                File propertiesFile = new File(path + "painting/" + painting + ".properties");
                // 创建目录
                propertiesFile.getParentFile().mkdirs();

                FileWriter fileWriter = new FileWriter(propertiesFile);
                BufferedWriter out = new BufferedWriter(fileWriter);
                out.write(propertiesResult);
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
