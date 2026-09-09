import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Ile kostek chcesz rzucić? (3-10)");
            int x = 0;
            while (x < 3 || x > 10) {
                x = scanner.nextInt();
            }

            int[] wyniki = new int[x];
            for (int i = 0; i < x; i++) {
                wyniki[i] = random.nextInt(6) + 1;
                System.out.println("Kostka " + (i + 1) + ": " + wyniki[i]);
            }

            int punkty = 0;
            for (int i = 1; i <= 6; i++) {
                int count = 0;
                for (int number : wyniki) {
                    if (i == number) {
                        count++;
                    }
                }
                if (count >= 2) {
                    punkty += i * count;
                }
            }
            System.out.println("Liczba uzyskanych punktów: " + punkty);

            char again = ' ';
            while (again != 't' && again != 'n') {
                System.out.println("Jeszcze raz? (t/n)");
                again = scanner.next().charAt(0);
            }

           if( again == 'n'){
               playAgain = false;
           }
        }

        scanner.close();
    }
}