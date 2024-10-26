package openNeo.old;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PaintingNewTable extends PaintingTable {
    protected String propertiesValue = """
            type=item
            matchItems=painting
            texture=""";

    @Override
    public void generate() {
        for (String painting : paintings) {
            String propertiesResult = propertiesValue + painting + "\ncomponents.entity_data.variant=minecraft:" + painting;
            propertiesArray.add(propertiesResult);
        }
    }

    @Override
    public void save() {
        try {
            for (int i = 0; i < paintings.size(); i++) {
                String painting = paintings.get(i);
                String propertiesResult = propertiesArray.get(i);

                File propertiesFile = new File(path + "painting/" + painting + "_new.properties");
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
