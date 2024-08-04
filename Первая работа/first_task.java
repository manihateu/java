import java.util.Random;
import java.util.Scanner;

class FirstTask {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Введите число");
        int inputNumber = scanner.nextInt();
        scanner.close();
        
        int[] arr = new int[10];
        int result = 0;

        for (int i = 0; i < 10; i++) {
            arr[i] = rnd.nextInt(10) + 1;
            if (inputNumber == arr[i]) result++;
        }

        System.out.println("Массив - " );
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("Число повторений - " + result);
    }
} 