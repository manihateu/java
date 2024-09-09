import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RockPaperScissorsGame {
    private static final String[] MOVES = {"Камень", "Ножницы", "Бумага"};
    private static int player1Score = 0;
    private static int player2Score = 0;
    private static int player3Score = 0;
    private static final int TOTAL_ROUNDS = 10000;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread player1 = new Thread(new Player("Игрок 1"));
        Thread player2 = new Thread(new Player("Игрок 2"));
        Thread player3 = new Thread(new Player("Игрок 3"));

        player1.start();
        player2.start();
        player3.start();

        try {
            player1.join();
            player2.join();
            player3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        showResults();
    }

    static class Player implements Runnable {
        private final String playerName;

        public Player(String playerName) {
            this.playerName = playerName;
        }

        @Override
        public void run() {
            try (FileWriter writer = new FileWriter("game_results.txt", true)) {
                Random random = new Random();
                for (int i = 0; i < TOTAL_ROUNDS / 3; i++) {
                    String move1 = MOVES[random.nextInt(MOVES.length)];
                    String move2 = MOVES[random.nextInt(MOVES.length)];
                    String move3 = MOVES[random.nextInt(MOVES.length)];

                    lock.lock();
                    try {
                        String result = playRound(move1, move2, move3);
                        writer.write(playerName + ": " + move1 + ", " + move2 + ", " + move3 + " -> " + result + "\n");
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String playRound(String move1, String move2, String move3) {
        if (move1.equals(move2) && move2.equals(move3)) {
            return "Ничья";
        }

        int result1 = getResult(move1, move2, move3);
        if (result1 == 1) player1Score++;
        else if (result1 == 2) player2Score++;
        else if (result1 == 3) player3Score++;

        return "Победитель: Игрок " + result1;
    }

    public static int getResult(String move1, String move2, String move3) {
        if ((move1.equals("Камень") && move2.equals("Ножницы") && move3.equals("Ножницы")) ||
            (move1.equals("Ножницы") && move2.equals("Бумага") && move3.equals("Бумага")) ||
            (move1.equals("Бумага") && move2.equals("Камень") && move3.equals("Камень"))) {
            return 1;
        } else if ((move2.equals("Камень") && move1.equals("Ножницы") && move3.equals("Ножницы")) ||
                   (move2.equals("Ножницы") && move1.equals("Бумага") && move3.equals("Бумага")) ||
                   (move2.equals("Бумага") && move1.equals("Камень") && move3.equals("Камень"))) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void showResults() {
        JFrame frame = new JFrame("Результаты игры");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JLabel label1 = new JLabel("Счет Игрока 1: " + player1Score, SwingConstants.CENTER);
        JLabel label2 = new JLabel("Счет Игрока 2: " + player2Score, SwingConstants.CENTER);
        JLabel label3 = new JLabel("Счет Игрока 3: " + player3Score, SwingConstants.CENTER);

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);

        frame.add(panel);
        frame.setVisible(true);
    }
}
