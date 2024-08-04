import java.util.ArrayList;
import java.util.Random;

public class second_task {
    public static void main(String[] args) {
        Random rnd = new Random();
    
        int[][] arr = new int[10][10];
        ArrayList<Integer> result_arr = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = rnd.nextInt(100);
                if ((i + j) % 2 == 0) result_arr.add(arr[i][j]);
            }
        }

        System.out.println("Массив - " );
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Результат - " );
        for (int i = 0; i < result_arr.size(); i++) {
            System.out.print(result_arr.get(i) + " ");
        }
    }
}
