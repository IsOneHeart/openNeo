package openNeo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileCreater implements CreateFileInterface {
    private String ITEM = "<this>THIS.ITEM</this>";
    private Vector<String> VALUE = new Vector<>();
    private Vector<Vector<String>> value = new Vector<>();
    private String propertiesValue = "";
    private String modelValue = "";
    private Vector<String> propertiesArray = new Vector<>();
    private Vector<String> modelArray = new Vector<>();
    private Vector<String> items = new Vector<>();
    private String path = "";
    private String customVersion = "";
    private Vector<String> propertiesStructure = new Vector<>();
    private Vector<String> modelStructure = new Vector<>();

    private void initializer() {
        int count = 0;
        for (String value : VALUE) {
            value = "<this>THIS.ITEM[" + count + "]</this>";
        }
    }

    public void setCustomVersion(String customVersion) {
        this.customVersion = "_" + customVersion;
    }

    public void setPropertiesStructure(Vector<String> propertiesStructure) {
        this.propertiesStructure = propertiesStructure;
    }

    public void setPropertiesStructure(String structure) {
        String[] split = structure.split("</?this>");
        for (String string : split)
            propertiesStructure.add(string);
    }

    public void setModelStructure(Vector<String> modelStructure) {
        this.modelStructure = modelStructure;
    }

    public void setModelStructure(String structure) {
        String[] split = structure.split("</?this>");
        for (String string : split)
            modelStructure.add(string);
    }

    public void setValues(Vector<String[]> values) {
        for (String[] strings : values) {
            Vector<String> vector = new Vector<>();
            for (String string : strings) {
                vector.add(string);
            }
            this.value.add(vector);
        }
    }


    @Override
    public void add(String item) {
        items.add(item);
    }

    @Override
    public void add(Vector<String> items) {
        this.items.addAll(items);
    }

    public void add(String[] items) {
        for (String item : items) {
            this.items.add(item);
        }
    }

    @Override
    public void remove(String item) {
        items.remove(item);
    }

    @Override
    public void remove(Vector<String> items) {
        this.items.removeAll(items);
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public void setPath(String path) {
        if (path.endsWith("/"))
            this.path = path;
        else
            this.path = path + "/";
    }

    @Override
    public void generate() {
        int count=0;
        for (String item : items) {
            propertiesValue = "";
            modelValue = "";
            for (String property : propertiesStructure) {
                String regex = "THIS\\.VALUE\\[(\\d+)\\]";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(property);
                int number = 0;
                if (matcher.find()) {
                    // 提取捕获组中的内容
                    number = Integer.valueOf(matcher.group(1));
                    property=value.get(number).get(count);
                }
                propertiesValue += property.replace("THIS.ITEM", item);
            }
            for (String model : modelStructure) {
                String regex = "THIS\\.VALUE\\[(\\d+)\\]";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(model);
                int number = 0;
                if (matcher.find()) {
                    // 提取捕获组中的内容
                    number = Integer.valueOf(matcher.group(1));
                    model=value.get(number).get(count);
                }
                modelValue += model.replace("THIS.ITEM", item);
            }
            propertiesArray.add(propertiesValue);
            modelArray.add(modelValue);
            count++;
        }
    }

    @Override
    public void save() {
        try {
            for (int i = 0; i < items.size(); i++) {
                if (items.size() == 0 || propertiesArray.size() == 0 || modelArray.size() == 0) {
                    throw new IllegalStateException("One of the arrays is empty.");
                }
                String item = items.get(i);
                String propertiesResult = propertiesArray.get(i);
                String modelResult = modelArray.get(i);

                File propertiesFile = new File(path + "optifine/cit/save/" + item + customVersion + ".properties");
                File modelFile = new File(path + "models/item/save/" + item + customVersion + ".json");

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

    public FileCreater() {
    }

    public FileCreater(Vector<String> items) {
        this.items = items;
    }

    public FileCreater(String[] items) {
        for (String item : items) {
            this.items.add(item);
        }
    }
}
