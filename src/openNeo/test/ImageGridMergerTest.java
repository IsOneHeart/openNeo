package openNeo.test;

import openNeo.ImageGridMerger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImageGridMergerTest {
    public static void main(String[] args) {
        String potionPath = "C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\textures\\item\\potion"; // 替换为你的文件夹路径
        String topLayerPath = "E:\\StudyE\\Java\\第11章 IO(输入输出)流\\top"; // 替换为你的顶部图层文件夹路径
        String resultImagePath = "E:\\StudyE\\Java\\第11章 IO(输入输出)流\\resultImage"; // 替换为你的结果图像文件夹路径
        String arrowPath = "C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\textures\\item\\tipped_arrow";
        String arrowTopLayerPath = "E:\\StudyE\\Java\\第11章 IO(输入输出)流\\top2";
        String arrowResultPath = "E:\\StudyE\\Java\\第11章 IO(输入输出)流\\resultImage2";

        List<File> potionResultFiles = ImageGridMerger.getLayeredImage(potionPath, topLayerPath, resultImagePath);
        List<File> arrowResultFiles = ImageGridMerger.getLayeredImage(arrowPath, arrowTopLayerPath, arrowResultPath);
        System.out.println("Generated " + potionResultFiles.size() + " images.");
        String enchantedBookPath = "E:\\StudyE\\Java\\第11章 IO(输入输出)流\\pngs";
        String nameTagPath = "C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\optifine\\cit\\name_tag";
        String suspiciousStewPath = "C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\optifine\\cit\\suspicious_stew";
        String potteryPath="C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\script\\image\\pottery";
        String spawnEggPath="C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\textures\\item\\spawn_eggs";
        String goatHornpath="C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\optifine\\cit\\goat_horn";
        String paintingPath="C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\optifine\\cit\\painting";
        String totemPath="C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\optifine\\cit\\totem";
        String bannerPatternPath="C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\textures\\item\\banner_pattern";
        String tropicalFishBucketPath="C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\optifine\\cit\\tropical_fish_bucket";
        String axolotlBucketPath="C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\optifine\\cit\\axolotl_bucket";
        String mapPath="C:\\Users\\21290\\AppData\\Roaming\\.minecraft\\versions\\1.20.1ZY\\resourcepacks\\StarVision JE\\assets\\minecraft\\optifine\\cit\\map";

        potionResultFiles.addAll(ImageGridMerger.getPngFilesInFolder(potionPath));
        potionResultFiles = ImageGridMerger.potionListSort(potionResultFiles);
        arrowResultFiles.addAll(ImageGridMerger.getPngFilesInFolder(arrowPath));

        int gridWidth = 24; // 网格宽度
        int gridHeight = 27; // 网格高度
        int tileWidth = 16; // 每个PNG图像的宽度
        int tileHeight = 16; // 每个PNG图像的高度

        List<File> pngFiles = ImageGridMerger.getPngFilesInFolder(enchantedBookPath);
        pngFiles.addAll(ImageGridMerger.getNameTagList(nameTagPath,"E:\\StudyE\\Java\\第11章 IO(输入输出)流\\jebNameTag"));
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
