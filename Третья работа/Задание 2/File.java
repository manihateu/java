import java.util.Scanner;

abstract class File {
    private String name;
    private String extension;
    private double size; // in MB
    private String creationDate;

    public File(String name, String extension, double size, String creationDate) {
        this.name = name;
        this.extension = extension;
        this.size = size;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void inputFromKeyboard() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        setName(scanner.nextLine());

        System.out.print("Enter extension: ");
        setExtension(scanner.nextLine());

        System.out.print("Enter size (MB): ");
        setSize(scanner.nextDouble());
        scanner.nextLine(); // consume newline

        System.out.print("Enter creation date: ");
        setCreationDate(scanner.nextLine());
        scanner.close();
    }

    @Override
    public String toString() {
        return "File [name=" + name + ", extension=" + extension + ", size=" + size + "MB, creationDate=" + creationDate + "]";
    }
}