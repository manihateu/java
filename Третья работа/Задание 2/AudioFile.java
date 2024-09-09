import java.util.Scanner;

class AudioFile extends File {
    private int duration; 
    private String artist;
    private String album;
    private String genre;

    public AudioFile(String name, String extension, double size, String creationDate, int duration, String artist, String album, String genre) {
        super(name, extension, size, creationDate);
        this.duration = duration;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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
        scanner.nextLine(); 

        System.out.print("Enter artist: ");
        setArtist(scanner.nextLine());

        System.out.print("Enter album: ");
        setAlbum(scanner.nextLine());

        System.out.print("Enter genre: ");
        setGenre(scanner.nextLine());
        scanner.close();
    }

    @Override
    public String toString() {
        return "AudioFile [" + super.toString() + ", duration=" + duration + " seconds, artist=" + artist + ", album=" + album + ", genre=" + genre + "]";
    }
}