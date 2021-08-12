import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {

    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory

        Files.walkFileTree(Paths.get(sourceDirectory), new VisitForCopy(Paths.get(sourceDirectory), Paths.get(destinationDirectory)));
    }
}

class VisitForCopy extends SimpleFileVisitor<Path> {
    Path sourceDirectory;
    Path destinationDirectory;


    public VisitForCopy(Path sourceDirectory, Path destinationDirectory) {
        this.sourceDirectory = sourceDirectory;
        this.destinationDirectory = destinationDirectory;

    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destinationDirectory.resolve(sourceDirectory.relativize(dir));
        Files.copy(dir, newDestination,StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destinationDirectory.resolve(sourceDirectory.relativize(file));
        Files.copy(file, newDestination,StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }


}
