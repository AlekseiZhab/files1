import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("D://Games2//temp"),
                new File("D://Games2//src"),
                new File("D://Games2//res"),
                new File("D://Games2//savegames"),
                new File("D://Games2//src//main"),
                new File("D://Games2//src//test"),
                new File("D://Games2//res//drawables"),
                new File("D://Games2//res//vectors"),
                new File("D://Games2//res//icons")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " - создан\n");
            else sb.append("Каталог " + folder + " - не создан\n");
        });


        List<File> fileList = Arrays.asList(
                new File("D://Games2//src//main//Main.java"),
                new File("D://Games2//src//main//Utils.java"),
                new File("D://Games2//temp//temp.txt")
        );

        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " - создан\n");
                else sb.append("Файл " + file + " - не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage());
            }
        });
        try (FileWriter log = new FileWriter("D://Games2//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage());
        }
        System.out.println(sb);

    }
}
