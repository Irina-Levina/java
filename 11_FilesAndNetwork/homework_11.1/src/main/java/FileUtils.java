import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {


    public static long calculateFolderSize(String path) {

        Path folder = Paths.get(path);
        long summLengthFile = (long) 0.0;

        try {
            summLengthFile = Files.walk(folder)
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .mapToLong(File::length)
                    .sum();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        return summLengthFile;
    }
}
