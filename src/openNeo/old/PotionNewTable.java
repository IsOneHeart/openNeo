package openNeo.old;

public class PotionNewTable extends PotionTable {
    @Override
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
                    "model=item/" + "potion_bottle_lingering/potion_bottle_lingering_" + item + "\ncomponents.potion_contents.potion=minecraft:" + item;
            modelResult[1] = modelValue + "potion_bottle/potion_bottle_" + item + "\ncomponents.potion_contents.potion=minecraft:" + item;
            modelResult[2] = "type=item\n" +
                    "items=splash_potion\n" +
                    "model=item/" + "potion_bottle_splash/potion_bottle_splash_" + item + "\ncomponents.potion_contents.potion=minecraft:" + item;

            modelResult[3] = "type=item\n" +
                    "items=lingering_potion\n" +
                    "model=item/" + "potion_bottle_lingering/potion_bottle_lingering_" + item + "_long\ncomponents.potion_contents.potion=minecraft:long_" + item;
            modelResult[4] = modelValue + "potion_bottle/potion_bottle_" + item + "_long\ncomponents.potion_contents.potion=minecraft:long_" + item;
            modelResult[5] = "type=item\n" +
                    "items=splash_potion\n" +
                    "model=item/" + "potion_bottle_splash/potion_bottle_splash_" + item + "_long\ncomponents.potion_contents.potion=minecraft:long_" + item;

            modelResult[6] = "type=item\n" +
                    "items=lingering_potion\n" +
                    "model=item/" + "potion_bottle_lingering/potion_bottle_lingering_" + item + "_strong\ncomponents.potion_contents.potion=minecraft:strong_" + item;
            modelResult[7] = modelValue + "potion_bottle/potion_bottle_" + item + "_strong\ncomponents.potion_contents.potion=minecraft:strong_" + item;
            modelResult[8] = "type=item\n" +
                    "items=splash_potion\n" +
                    "model=item/" + "potion_bottle_splash/potion_bottle_splash_" + item + "_strong\ncomponents.potion_contents.potion=minecraft:strong_" + item;

            modelResult[9] = "type=item\n" +
                    "items=tipped_arrow\n" +
                    "model=item/tipped_arrow/tipped_arrow_" + item + "\ncomponents.potion_contents.potion=minecraft:" + item;
            modelResult[10] = "type=item\n" +
                    "items=tipped_arrow\n" +
                    "model=item/tipped_arrow/tipped_arrow_" + item + "_long\ncomponents.potion_contents.potion=minecraft:long_" + item;
            modelResult[11] = "type=item\n" +
                    "items=tipped_arrow\n" +
                    "model=item/tipped_arrow/tipped_arrow_" + item + "_strong\ncomponents.potion_contents.potion=minecraft:strong_" + item;
            propertiesArray.add(propertiesResult);
            modelArray.add(modelResult);
        }
    }
}
