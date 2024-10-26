# openNeo开发者文档
**openNeo**是基于Java的用于批量生成、管理Minecraft纹理包配置文件的脚本库。最新API版本为**2.0**。  
API2.0新增了FileCreater类，替代了API2.0以前的PotionTable、SpawnEggTabel和PaintingTable等类，使用更加便捷的文件统一生成、维护能力。  
被替代的类仍让可以在API2.0及之后使用，但不被推荐使用，将不会出现在本文档中。

## （一） CreateFileInterface接口
CreateFileInterface接口提供了用于批量生成文件的抽象方法。开发者可以通过实现接口，创建新的文件生成对象。
|抽象成员方法|形式参数类型|
|------------|---------|
|add|String 或 List\<String\> 或 Vector\<String\>|
|remove|String 或 List\<String\> 或 Vector\<String\>|
|clear||
|setPath||
|generate||
|print||
|save||

## （二） FileCreater类
FileCreater类是FileCreaterInterface接口的实现，可以用于批量生成Minecraft Java版纹理包的配置文件。并且FileCreater允许对一个游戏对象同时生成**properties**文件和**json**文件。
|公共成员方法|形式参数类型|由抽象方法重写|功能|在generate前必须执行|在generate后执行|
|------------|---------|-----|---|---|---|
|add|String 或 Vector\<String\>|true|添加待生成项|true|false|
|remove|String 或 Vector\<String\>|true|移除待生成项|false|false|
|clear||true|清空待生成项|false|false|
|setPath||true|设置文件存储路径|true|false|
|generate||true|生成文件内容|||
|save||true|保存文件至路径|false|true|
|setPropertiesStructure|String 或 Vector\<String\>|false|设置properties文件通用结构|false|false|
|setModelStructure|String 或 Vector\<String\>|false|设置json文件通用结构|false|false|
|setValues|Vector\<String\[\]\>|false|设置待生成项目的附加属性|false|false|
|setCustomVersion|String|false|设置文件版本|false|false|

### setPropertiesStructure和setModelStructure方法的结构关键块
setPropertiesStructure和setModelStructure可以传入String字符串或文本块。在openNeo中，在生成的每个文件中（传入String字符串或文本块）相同的部分称为**非关键内容**，不相同的部分称为**关键内容**。  
关键内容必须包含在**this块**中，this块中必须是**THIS语句**。
|THIS语句|含义|
|-|-|
|THIS.ITEM|待生成项关键字（一般是ID）|
|THIS.VALUE\[0\]|待生成项的其他属性|
|THIS.VALUE\[1\]|待生成项的其他属性|
|THIS.VALUE\[...\]|待生成项的其他属性|

例如使用add方法添加如下内容：
```java
potion.add("night_vision");
potion.add("invisibility");
potion.add("leaping");
```
并使用setPropertiesStructure方法传入如下通用文件内容：
```
potion.setPropertiesStructure("""
            type=item
            matchItems=painting
            texture=<this>THIS.ITEM</this>""");
```
那么调用generate和save方法后则可以产生三个文件，内容分别为：
```
type=item
matchItems=painting
texture=night_vision
```
```
type=item
matchItems=painting
texture=invisibility
```
```
type=item
matchItems=painting
texture=leaping
```

###示例代码
```java
package openNeo.test;

import openNeo.FileCreater;
import java.util.Vector;

public class FishBucketTest {
    public static void main(String[] args) {
        //批量生成可视化谜之炖菜配置文件
        String[] items = {"blindness", "fire_resistance", "jump_boost", "night_vision", "poison", "regeneration", "saturation", "weakness", "wither"};
        String[] value0 = {"15", "12", "8", "16", "19", "10", "23", "18", "20"};
        FileCreater fc = new FileCreater(items);
        fc.setPath("E:/StarVision JE/script/output");
        fc.setPropertiesStructure("""
                type=item
                items=minecraft:suspicious_stew
                nbt.Effects.0.EffectId=<this>THIS.VALUE[0]</this>
                texture=suspicious_stew_<this>THIS.ITEM</this>""");
        Vector<String[]> values = new Vector<>();
        values.add(value0);
        fc.setValues(values);
        fc.setCustomVersion("new"); // 在每个文件名后添加版本new
        fc.generate();
        fc.save();
    }
}
```

## （三） ImageGridMerger类
ImageGridMerger类用于快速生成等大小的图片的网格型预览图，可用于展示所有的纹理包纹理。
|公共成员方法|形式参数类型|返回值类型|功能|静态方法|
|-|-|-|-|-|
|getPngFilesInFolder|String|List\<File\>|获取一个路径下所有png图像的文件列表|true|
|getLayeredImage|String,String,String|List\<File\>|将两个个路径下的所有png图像分别作为第一二个图层，生成所有排列情况的图像并导出到另一个路径|true|
|potionListSort|List\<File\>|List\<File\>|将同个文件列表下的所有Minecraft药水图像按普通药水、投掷型药水、滞留型药水的顺序排列|true|
|mergePngsIntoGrid|List\<File\>,int,int,int,int|BufferedImage|设置图片大小并合成图像|true|
|fileSort|List\<File\>|void|将一个文件列表中的文件按文件名升序排列|true|
|getNameTagList|String,String|List\<File\>|将一个路径下名为“jeb”的png图像拆分成多个16*16图像，与同路径下的其他png图像存储在新路径中并获取文件列表|true|
### 示例代码
```java
package openNeo.test;

import openNeo.ImageGridMerger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImageGridMergerTest {
    public static void main(String[] args) {
        String potionPath = "your path"; // 替换为你的文件夹路径
        String topLayerPath = "your path"; // 替换为你的顶部图层文件夹路径
        String resultImagePath = "your path"; // 替换为你的结果图像文件夹路径
        String arrowPath = "your path";
        String arrowTopLayerPath = "your path";
        String arrowResultPath = "your path";

        List<File> potionResultFiles = ImageGridMerger.getLayeredImage(potionPath, topLayerPath, resultImagePath);
        List<File> arrowResultFiles = ImageGridMerger.getLayeredImage(arrowPath, arrowTopLayerPath, arrowResultPath);
        System.out.println("Generated " + potionResultFiles.size() + " images.");
        String enchantedBookPath = "your path";
        String nameTagPath = "your path";
        String suspiciousStewPath = "your path";
        String potteryPath="your path";
        String spawnEggPath="your path";
        String goatHornpath="your path";
        String paintingPath="your path";
        String totemPath="your path";
        String bannerPatternPath="your path";
        String tropicalFishBucketPath="your path";
        String axolotlBucketPath="your path";
        String mapPath="your path";

        potionResultFiles.addAll(ImageGridMerger.getPngFilesInFolder(potionPath));
        potionResultFiles = ImageGridMerger.potionListSort(potionResultFiles);
        arrowResultFiles.addAll(ImageGridMerger.getPngFilesInFolder(arrowPath));

        int gridWidth = 24; // 网格宽度
        int gridHeight = 27; // 网格高度
        int tileWidth = 16; // 每个PNG图像的宽度
        int tileHeight = 16; // 每个PNG图像的高度

        List<File> pngFiles = ImageGridMerger.getPngFilesInFolder(enchantedBookPath);
        pngFiles.addAll(ImageGridMerger.getNameTagList(nameTagPath,"your path"));
        pngFiles.addAll(potionResultFiles);
        pngFiles.addAll(arrowResultFiles);
        pngFiles.addAll(ImageGridMerger.getPngFilesInFolder(suspiciousStewPath));
        pngFiles.addAll(ImageGridMerger.getPngFilesInFolder(potteryPath));
        pngFiles.addAll(ImageGridMerger.getPngFilesInFolder(spawnEggPath));
        pngFiles.addAll(ImageGridMerger.getPngFilesInFolder(goatHornpath));
        pngFiles.addAll(ImageGridMerger.getPngFilesInFolder(paintingPath));
        pngFiles.addAll(ImageGridMerger.getPngFilesInFolder(totemPath));
        pngFiles.addAll(ImageGridMerger.getPngFilesInFolder(bannerPatternPath));
        pngFiles.addAll(ImageGridMerger.getPngFilesInFolder(tropicalFishBucketPath));
        pngFiles.addAll(ImageGridMerger.getPngFilesInFolder(axolotlBucketPath));
        pngFiles.addAll(ImageGridMerger.getPngFilesInFolder(mapPath));
        BufferedImage mergedImage = ImageGridMerger.mergePngsIntoGrid(pngFiles, gridWidth, gridHeight, tileWidth, tileHeight);
        try {
            ImageIO.write(mergedImage, "PNG", new File("merged_image.png")); // 保存合并后的图像
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---
>Copyright(c) 2024 IsOneHeart SoulHarbor, All Rights Reserved.
