package openNeo.test;

import openNeo.ImageGridMerger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImageGridMergerTest {
    public static void main(String[] args) {
        String potionPath = "your path";
        String topLayerPath = "your path";
        String resultImagePath = "your path";
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
