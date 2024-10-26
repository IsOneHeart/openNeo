package openNeo.old;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PotionTable {
    protected String propertiesValue = "{\n" +
            "    \"parent\": \"item/generated\",\n" +
            "    \"textures\": {\n" +
            "        \"layer0\": \"item/null\",\n" +
            "        \"layer1\": \"item/";
    protected String modelValue = "type=item\n" +
            "items=potion\n" +
            "model=item/";
    protected List<String[]> propertiesArray = new ArrayList<>();
    protected List<String[]> modelArray = new ArrayList<>();
    protected List<String> items = new ArrayList<>();
    protected String path = "";

    public void add(String egg) {
        items.add(egg);
    }

    public void add(List<String> eggs) {
        this.items.addAll(eggs);
    }

    public void remove(String egg) {
        items.remove(egg);
    }

    public void remove(List<String> eggs) {
        this.items.removeAll(eggs);
    }

    public void clear() {
        items.clear();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void print() {
        for (String mob : items)
            System.out.println(mob);
    }

    public void generate() {
        for (String item : items) {
            String[] propertiesResult = new String[12];
            propertiesResult[0] = propertiesValue + "potion/potion_bottle_lingering_" + item + "\"\n" +
                    "    }\n" +
                    "}";
            propertiesResult[1] = propertiesValue + "potion/potion_bottle_" + item + "\"\n" +
                    "    }\n" +
                    "}";
            propertiesResult[2] = propertiesValue + "potion/potion_bottle_splash_" + item + "\"\n" +
                    "    }\n" +
                    "}";

            propertiesResult[3] = propertiesValue + "potion/potion_bottle_lingering_" + item + "\",\n" +
                    "        \"layer2\": \"item/potion_long\"\n" +
                    "    }\n" +
                    "}";
            propertiesResult[4] = propertiesValue + "potion/potion_bottle_" + item + "\",\n" +
                    "        \"layer2\": \"item/potion_long\"\n" +
                    "    }\n" +
                    "}";
            propertiesResult[5] = propertiesValue + "potion/potion_bottle_splash_" + item + "\",\n" +
                    "        \"layer2\": \"item/potion_long\"\n" +
                    "    }\n" +
                    "}";

            propertiesResult[6] = propertiesValue + "potion/potion_bottle_lingering_" + item + "\",\n" +
                    "        \"layer2\": \"item/potion_strong\"\n" +
                    "    }\n" +
                    "}";
            propertiesResult[7] = propertiesValue + "potion/potion_bottle_" + item + "\",\n" +
                    "        \"layer2\": \"item/potion_strong\"\n" +
                    "    }\n" +
                    "}";
            propertiesResult[8] = propertiesValue + "potion/potion_bottle_splash_" + item + "\",\n" +
                    "        \"layer2\": \"item/potion_strong\"\n" +
                    "    }\n" +
                    "}";

            propertiesResult[9] = propertiesValue + "tipped_arrow/tipped_arrow_" + item + "\"\n" +
                    "    }\n" +
                    "}";
            propertiesResult[10] = propertiesValue + "tipped_arrow/tipped_arrow_" + item + "\",\n" +
                    "        \"layer2\": \"item/arrow_long\"\n" +
                    "    }\n" +
                    "}";
            propertiesResult[11] = propertiesValue + "tipped_arrow/tipped_arrow_" + item + "\",\n" +
                    "        \"layer2\": \"item/arrow_strong\"\n" +
                    "    }\n" +
                    "}";

            String[] modelResult = new String[12];
            modelResult[0] = "type=item\n" +
                    "items=lingering_potion\n" +
                    "model=item/" + "potion_bottle_lingering/potion_bottle_lingering_" + item + "\nnbt.Potion=minecraft:" + item;
            modelResult[1] = modelValue + "potion_bottle/potion_bottle_" + item + "\nnbt.Potion=minecraft:" + item+"\nuseGlint=false";
            modelResult[2] = "type=item\n" +
                    "items=splash_potion\n" +
                    "model=item/" + "potion_bottle_splash/potion_bottle_splash_" + item + "\nnbt.Potion=minecraft:" + item;

            modelResult[3] = "type=item\n" +
                    "items=lingering_potion\n" +
                    "model=item/" + "potion_bottle_lingering/potion_bottle_lingering_" + item + "_long\nnbt.Potion=minecraft:long_" + item;
            modelResult[4] = modelValue + "potion_bottle/potion_bottle_" + item + "_long\nnbt.Potion=minecraft:long_" + item;
            modelResult[5] = "type=item\n" +
                    "items=splash_potion\n" +
                    "model=item/" + "potion_bottle_splash/potion_bottle_splash_" + item + "_long\nnbt.Potion=minecraft:long_" + item;

            modelResult[6] = "type=item\n" +
                    "items=lingering_potion\n" +
                    "model=item/" + "potion_bottle_lingering/potion_bottle_lingering_" + item + "_strong\nnbt.Potion=minecraft:strong_" + item;
            modelResult[7] = modelValue + "potion_bottle/potion_bottle_" + item + "_strong\nnbt.Potion=minecraft:strong_" + item;
            modelResult[8] = "type=item\n" +
                    "items=splash_potion\n" +
                    "model=item/" + "potion_bottle_splash/potion_bottle_splash_" + item + "_strong\nnbt.Potion=minecraft:strong_" + item;

            modelResult[9] = "type=item\n" +
                    "items=tipped_arrow\n" +
                    "model=item/tipped_arrow/tipped_arrow_" + item + "\nnbt.Potion=minecraft:" + item;
            modelResult[10] = "type=item\n" +
                    "items=tipped_arrow\n" +
                    "model=item/tipped_arrow/tipped_arrow_" + item + "_long\nnbt.Potion=minecraft:long_" + item;
            modelResult[11] = "type=item\n" +
                    "items=tipped_arrow\n" +
                    "model=item/tipped_arrow/tipped_arrow_" + item + "_strong\nnbt.Potion=minecraft:strong_" + item;
            propertiesArray.add(propertiesResult);
            modelArray.add(modelResult);
        }
    }

    public void save() {
        try {
            for (int i = 0; i < items.size(); i++) {
                for (int j = 0; j < 12; j++) {
                    String item = items.get(i);
                    String propertiesResult = propertiesArray.get(i)[j];
                    String modelResult = modelArray.get(i)[j];

                    String pathPart = "", pathPart2 = "";
                    if (j == 0 || j == 3 || j == 6) {
                        pathPart = "potion_bottle_lingering";
                    } else if (j == 1 || j == 4 || j == 7) {
                        pathPart = "potion_bottle";
                    } else if (j == 2 || j == 5 || j == 8) {
                        pathPart = "potion_bottle_splash";
                    } else if (j < 12) {
                        pathPart = "tipped_arrow";
                    }
                    if (j == 3 || j == 4 || j == 5 || j == 10) {
                        pathPart2 = "_long";
                    } else if (j == 6 || j == 7 || j == 8 || j == 11) {
                        pathPart2 = "_strong";
                    } else {
                        pathPart2 = "";
                    }

                    File modelFile = new File(path + "optifine/cit/" + pathPart + "/" + pathPart + "_" + item + pathPart2 + ".properties");
                    File propertiesFile = new File(path + "models/item/" + pathPart + "/" + pathPart + "_" + item + pathPart2 + ".json");

                    // 创建目录
                    propertiesFile.getParentFile().mkdirs();
                    modelFile.getParentFile().mkdirs();

                    // 检查 propertiesResult 是否为 null
                    if (propertiesResult != null) {
                        FileWriter fileWriter = new FileWriter(propertiesFile);
                        BufferedWriter out = new BufferedWriter(fileWriter);
                        out.write(propertiesResult);
                        out.close();
                        fileWriter = new FileWriter(modelFile);
                        out = new BufferedWriter(fileWriter);
                        out.write(modelResult);
                        out.close();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
