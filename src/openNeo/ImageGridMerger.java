package openNeo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ImageGridMerger {

    public static List<File> getPngFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        return files != null ? new ArrayList<>(List.of(files)) : new ArrayList<>();
    }

    public static List<File> getLayeredImage(String folderPath, String topLayerPath, String resultImagePath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        File topLayer = new File(topLayerPath);
        File[] topLayerFiles = topLayer.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));

        List<File> result = new ArrayList<>();

        File resultFolder = new File(resultImagePath);
        if (!resultFolder.exists()) {
            resultFolder.mkdirs();
        }

        for (File file : files) {
            for (File topLayerFile : topLayerFiles) {
                BufferedImage mergedImage = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = mergedImage.createGraphics();

                try {
                    BufferedImage baseImage = ImageIO.read(file);
                    BufferedImage topLayerImage = ImageIO.read(topLayerFile);

                    g2d.drawImage(baseImage, 0, 0, 16, 16, null);
                    g2d.drawImage(topLayerImage, 0, 0, 16, 16, null);

                    String resultFileName = file.getName().replace(".png", "") + "_" + topLayerFile.getName();
                    File resultFile = new File(resultImagePath + File.separator + resultFileName);
                    ImageIO.write(mergedImage, "PNG", resultFile);

                    result.add(resultFile);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    g2d.dispose();
                }
            }
        }
        return result;
    }

    public static List<File> potionListSort(List<File> files) {
        //File folder = new File(folderPath);
        //File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        List<File> result = new ArrayList<>();
        List<File> normalPotions = new ArrayList<>();
        List<File> spalshPotions = new ArrayList<>();
        List<File> lingeringPotions = new ArrayList<>();
        for (File file : files) {
            if (file.getName().contains("splash")) {
                spalshPotions.add(file);
            } else if (file.getName().contains("lingering")) {
                lingeringPotions.add(file);
            } else {
                normalPotions.add(file);
            }
        }
        result.addAll(normalPotions);
        result.addAll(spalshPotions);
        result.addAll(lingeringPotions);
        return result;
    }

    public static BufferedImage mergePngsIntoGrid(List<File> pngFiles, int gridWidth, int gridHeight, int tileWidth, int tileHeight) {
        BufferedImage mergedImage = new BufferedImage(gridWidth * tileWidth, gridHeight * tileHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = mergedImage.createGraphics();
        int tileIndex = 0;
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                if (tileIndex < pngFiles.size()) {
                    try {
                        BufferedImage tileImage = ImageIO.read(pngFiles.get(tileIndex));
                        g2d.drawImage(tileImage, x * tileWidth, y * tileHeight, tileWidth, tileHeight, null);
                        tileIndex++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        g2d.dispose();
        System.out.print(tileIndex+" Images are merged.");
        return mergedImage;
    }

    public static void fileSort(List<File> files) {
        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return Long.compare(f1.length(), f2.length());
            }
        });
    }

    public static List<File> getNameTagList(String folderPath, String jebPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
        List<File> result = new ArrayList<>();
        for (File file : files) {
            if (file.getName().contains("jeb")) {
                String inputImagePath = folderPath;
                String outputFolder = jebPath;
                File inputFile = new File(inputImagePath);
                if (!inputFile.exists()) {
                    System.out.println("输入文件不存在：" + inputImagePath);
                    return result;
                }
                try {
                    BufferedImage inputImage = ImageIO.read(file);
                    for (int i = 0; i < 16; i++) {
                        BufferedImage subImage = inputImage.getSubimage(0, i * 16, 16, 16);
                        String outputImagePath = outputFolder + File.separator + "output_" + i + ".png";
                        result.add(new File(outputImagePath));
                        ImageIO.write(subImage, "PNG", new File(outputImagePath));
                    }
                    System.out.println("图像拆分完成。");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                result.add(file);
            }
        }
        fileSort(result);
        return result;
    }
}
