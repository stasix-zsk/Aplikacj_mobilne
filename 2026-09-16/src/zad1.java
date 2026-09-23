import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class zad1 {
    public static void main(String[] args) {
        int[] array = new int[200];
        int n = 0;

        try (Scanner scanner = new Scanner(new File("liczby.txt"))) {
            while (scanner.hasNextInt() && n < array.length) {
                array[n++] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        int firstValue = 0;
        int count = 0;
        for(int liczba : array){
            int original = liczba;
            int lastNumber = liczba % 10;
            int firstNumber = 0;

            while(liczba>0){
                firstNumber = liczba%10;
                liczba = liczba /  10;
            }
            if(lastNumber == firstNumber){
                if(count == 0){
                    firstValue = original;
                }
                count+=1;

            }


        }

        System.out.println(count);
        System.out.println(firstValue);

    }
}