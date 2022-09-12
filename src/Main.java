import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        File dirGames = new File("C:/Users/shayl/Games");
        if (dirGames.mkdir())
            System.out.println("Каталог /Games создан");
        else
            System.out.println("Каталог /Games был создан ранее");


        String[] dirList1 = new String[]{"src", "res", "savegames", "temp"};
        sb.append(createDirectory(String.valueOf(dirGames), dirList1));

        String[] dirList2 = new String[]{"main", "test"};
        sb.append(createDirectory(dirGames + "/src", dirList2));

        String[] dirList3 = new String[]{"drawables", "vectors", "icons"};
        sb.append(createDirectory(dirGames + "/res", dirList3));

        String[] fileList1 = new String[]{"Main.java", "Utils.java"};
        sb.append(createFile(dirGames + "/src/main/", fileList1));

        String report = sb.toString();
        System.out.println(report);

        File temp = new File(dirGames + "/temp/temp.txt");
        try {
            if (temp.createNewFile())
                System.out.println("Файл temp.txt создан");
            else
                System.out.println("Файл temp.txt был создан ранее");
        } catch (IOException e) {
            System.out.println("Файл не создан");
        }

        try (FileWriter text = new FileWriter(dirGames + "/temp/temp.txt")) {
            text.write(report);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String createDirectory(String mainDir, String[] dirList) {
        StringBuilder sb = new StringBuilder();
        for (String dir : dirList) {
            File newDir = new File(mainDir + "/" + dir);
            if (newDir.mkdir()) {
                sb.append("Каталог ").append(mainDir).append("/").append(dir).append(" создан\n");
            } else {
                sb.append("Каталог ").append(mainDir).append("/").append(dir).append(" был создан ранее\n");
            }
        }
        return sb.toString();
    }

    public static String createFile(String mainDir, String[] fileList) {
        StringBuilder sb = new StringBuilder();
        for (String file : fileList) {
            File newFile = new File(mainDir + file);
            try {
                if (newFile.createNewFile()) {
                    sb.append("Файл ").append(file).append(" создан\n");
                } else {
                    sb.append("Файл ").append(file).append(" был создан ранее\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return sb.toString();
    }
}
