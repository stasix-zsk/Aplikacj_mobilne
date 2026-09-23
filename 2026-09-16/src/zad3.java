import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class zad3 {
    public static void main(String[] args) {
        int[] array = new int[10000];
        int n = 0;

        try (Scanner scanner = new Scanner(new File("liczby.txt"))) {
            while (scanner.hasNextInt() && n < array.length) {
                array[n++] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        long[][] dp = new long[6][n];
        for (int i = 0; i < n; i++) {
            dp[1][i] = 1;
        }
        for (int k = 2; k <= 5; k++) {
            for (int i = 0; i < n; i++) {
                long suma = 0;
                for (int j = 0; j < n; j++) {
                    if (array[j] < array[i] && array[i] % array[j] == 0) {
                        suma += dp[k - 1][j];
                    }
                }
                dp[k][i] = suma;
            }
        }

        long trojkiCount = 0;
        for (int i = 0; i < n; i++) {
            trojkiCount += dp[3][i];
        }

        long piatkiCount = 0;
        for (int i = 0; i < n; i++) {
            piatkiCount += dp[5][i];
        }

        try (FileWriter writer = new FileWriter("trojki.txt")) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (array[x] >= array[y] || array[y] % array[x] != 0) continue;
                    for (int z = 0; z < n; z++) {
                        if (array[z] <= array[y] || array[z] % array[y] != 0) continue;
                        writer.write(array[x] + " " + array[y] + " " + array[z] + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(trojkiCount);
        System.out.println(piatkiCount);
    }
}