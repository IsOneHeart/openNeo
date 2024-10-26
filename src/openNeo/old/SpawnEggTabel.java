package openNeo.old;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpawnEggTabel {
    private String propertiesValue = "type=item\n" +
            "items=";
    private String modelValue = "{\n" +
            "  \"parent\": \"minecraft:item/spawn_egg\",\n" +
            "  \"textures\": {\n" +
            "    \"egg\": \"item/spawn_eggs/";
    private List<String> propertiesArray = new ArrayList<>();
    private List<String> modelArray = new ArrayList<>();
    private List<String> eggs = new ArrayList<>();
    private String path = "";

    public void add(String egg) {
        eggs.add(egg);
    }

    public void add(List<String> eggs) {
        this.eggs.addAll(eggs);
    }

    public void remove(String egg) {
        eggs.remove(egg);
    }

    public void remove(List<String> eggs) {
        this.eggs.removeAll(eggs);
    }

    public void clear() {
        eggs.clear();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void generate() {
        for (String mob : eggs) {
            String propertiesResult = propertiesValue + mob + "_spawn_egg\n" + "model=item/spawn_eggs/" + mob + "_spawn_egg\nnbt.EntityTag.id=minecraft:" + mob;
            String modelResult = modelValue + "egg_" + mob + "\"\n" +
                    "  }\n" +
                    "}";
            propertiesArray.add(propertiesResult);
            modelArray.add(modelResult);
        }
    }

    public void print() {
        for (String mob : eggs)
            System.out.println(mob);
    }

    public void save() {
        try {
            for (int i = 0; i < eggs.size(); i++) {
                String mob = eggs.get(i);
                String propertiesResult = propertiesArray.get(i);
                String modelResult = modelArray.get(i);

                File propertiesFile = new File(path + "spawn_eggs/" + mob + "_spawn_egg.properties");
                File modelFile = new File(path + "models/item/spawn_eggs/" + mob + "_spawn_egg.json");

                // 创建目录
                propertiesFile.getParentFile().mkdirs();
                modelFile.getParentFile().mkdirs();

                FileWriter fileWriter = new FileWriter(propertiesFile);
                BufferedWriter out = new BufferedWriter(fileWriter);
                out.write(propertiesResult);
                out.close();

                fileWriter = new FileWriter(modelFile);
                out = new BufferedWriter(fileWriter);
                out.write(modelResult);
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
