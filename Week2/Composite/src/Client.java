public class Client {
    public static void main(String[] args) {
        // Create file leafs
        FileComponent file1 = new FileLeaf("File1.txt", 1000);
        FileComponent file2 = new FileLeaf("File2.jpg", 2000);
        FileComponent file3 = new FileLeaf("File3.doc", 3000);

        // Create a folder composite
        FolderComposite folder1 = new FolderComposite("Folder1");
        folder1.add(file1);
        folder1.add(file2);

        // Create another folder composite
        FolderComposite folder2 = new FolderComposite("Folder2");
        folder2.add(folder1);
        folder2.add(file3);

        // Show properties of files and folders
        folder2.showProperty();
        System.out.println("Total size: " + folder2.totalSize() + " bytes");
    }
}
