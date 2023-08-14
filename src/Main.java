import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder info = new StringBuilder();
        File file = new File("D://Games");
        File file1 = new File("D://Games/src/main");
        File file2 = new File("D://Games/src/main/Main.java");
        File file3 = new File("D://Games/src/main/Utils.java");
        File file4 = new File("D://Games/src/test");
        File file5 = new File("D://Games/res/drawables");
        File file6 = new File("D://Games/res/vectors");
        File file7 = new File("D://Games/res/icons");
        File file8 = new File("D://Games/savegames");
        File file9 = new File("D://Games/temp");
        File file10 = new File("D://Games/temp/temp.txt");

        if (file.mkdir()) {
            info.append(file + " создан\n");
        }

        if (file1.mkdirs()) {
            info.append(file1 + " создан\n");
        }

        try {
            if (file2.createNewFile()) {
                info.append(file2 + " был создан\n");
            }
        } catch (IOException e) {
            info.append(e.getMessage());
        }

        try {
            if (file3.createNewFile()) {
                info.append(file3 + " был создан\n");
            }
        } catch (IOException e) {
            info.append(e.getMessage());
        }

        if (file4.mkdirs()) {
            info.append(file4 + " создан\n");
        }

        if (file5.mkdirs()) {
            info.append(file5 + " создан\n");
        }

        if (file6.mkdirs()) {
            info.append(file6 + " создан\n");
        }

        if (file7.mkdirs()) {
            info.append(file7 + " создан\n");
        }

        if (file8.mkdirs()) {
            info.append(file8 + " создан\n");
        }

        if (file9.mkdir()) {
            info.append(file9 + " создан\n");
        }

        try {
            if (file10.createNewFile()) {
                info.append(file10 + " был создан\n");
            }
        } catch (IOException e) {
            info.append(e.getMessage());
        }

        if (file.isDirectory()) {
            recursionDirectories(file, info);
        }

        try (FileWriter text = new FileWriter(file10)) {
            text.write(String.valueOf(info));
            text.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void recursionDirectories(File directory, StringBuilder info) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File item : files) {
                if (item.isDirectory()) {
                    info.append(item.getName()).append(" - каталог\n");
                    recursionDirectories(item, info);
                } else {
                    info.append(item.getName()).append(" - файл\n");
                }
            }
        }
    }
}