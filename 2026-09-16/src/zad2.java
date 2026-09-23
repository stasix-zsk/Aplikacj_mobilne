import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class zad2 {
    public static void main(String[] args) {
        int[] array = new int[200];
        int n = 0;

        try (Scanner scanner = new Scanner(new File("przyklad.txt"))) {
            while (scanner.hasNextInt() && n < array.length) {
                array[n++] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        int theMost = 0;
        int theMostCounted = 0;
        int theMostDifferent = 0;
        int theMostDifferentCounted = 0;

        for (int liczba : array){
            int original = liczba;
            int divider = 2;
            int previousDivider = 1;
            int theMostCount = 0;
            int theMostDifferentCount = 0;
            while(liczba != 1){
                if(liczba % divider != 0){
                    divider+=1;

                }
                else{
                    liczba /= divider;
                    theMostCount += 1;
                    if(divider>previousDivider){
                        theMostDifferentCount +=1;
                        previousDivider = divider;
                    }
                }
            }
            if(theMostCount > theMostCounted){
                theMostCounted = theMostCount;
                theMost = original;
            }
            if(theMostDifferentCount>theMostDifferentCounted){
                theMostDifferentCounted = theMostDifferentCount;
                theMostDifferent = original;
            }
        }
        System.out.println(theMost);
        System.out.println(theMostCounted);
        System.out.println(theMostDifferent);
        System.out.println(theMostDifferentCounted);

    }
}