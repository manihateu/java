import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Directory {
    private List<File> files = new ArrayList<>();

    public void addFile(File file) {
        files.add(file);
    }

    public void removeFile(File file) {
        files.remove(file);
    }

    public void listFiles() {
        for (File file : files) {
            System.out.println(file);
        }
    }

    public int countFiles(Class<?> type) {
        int count = 0;
        for (File file : files) {
            if (type.isInstance(file)) {
                count++;
            }
        }
        return count;
    }

    public void inputFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Audio File");
            System.out.println("2. Add Video File");
            System.out.println("3. List Files");
            System.out.println("4. Count Files");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    AudioFile audioFile = new AudioFile("", "", 0, "", 0, "", "", "");
                    audioFile.inputFromKeyboard();
                    addFile(audioFile);
                    break;
                case 2:
                    VideoFile videoFile = new VideoFile("", "", 0, "", 0, "", "", "");
                    videoFile.inputFromKeyboard();
                    addFile(videoFile);
                    break;
                case 3:
                    listFiles();
                    break;
                case 4:
                    System.out.println("Number of Audio Files: " + countFiles(AudioFile.class));
                    System.out.println("Number of Video Files: " + countFiles(VideoFile.class));
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}