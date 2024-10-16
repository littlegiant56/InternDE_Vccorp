import java.util.ArrayList;
import java.util.List;

public class FolderComposite implements FileComponent {
    private String name;
    private List<FileComponent> files = new ArrayList<>();

    public FolderComposite(String name) {
        this.name = name;
    }

    public void add(FileComponent fileComponent) {
        files.add(fileComponent);
    }

    public void remove(FileComponent fileComponent) {
        files.remove(fileComponent);
    }

    @Override
    public void showProperty() {
        System.out.println("Folder: " + name);
        for (FileComponent file : files) {
            file.showProperty();
        }
    }

    @Override
    public long totalSize() {
        long total = 0;
        for (FileComponent file : files) {
            total += file.totalSize();
        }
        return total;
    }
}
