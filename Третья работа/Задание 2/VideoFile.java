import java.util.Scanner;

class VideoFile extends File {
    private int duration; // in seconds
    private String resolution;
    private String director;
    private String genre;

    public VideoFile(String name, String extension, double size, String creationDate, int duration, String resolution, String director, String genre) {
        super(name, extension, size, creationDate);
        this.duration = duration;
        this.resolution = resolution;
        this.director = director;
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void inputFromKeyboard() {
        super.inputFromKeyboard();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter duration (seconds): ");
        setDuration(scanner.nextInt());
        scanner.nextLine(); // consume newline

        System.out.print("Enter resolution: ");
        setResolution(scanner.nextLine());

        System.out.print("Enter director: ");
        setDirector(scanner.nextLine());

        System.out.print("Enter genre: ");
        setGenre(scanner.nextLine());
        scanner.close();
    }

    @Override
    public String toString() {
        return "VideoFile [" + super.toString() + ", duration=" + duration + " seconds, resolution=" + resolution + ", director=" + director + ", genre=" + genre + "]";
    }
}