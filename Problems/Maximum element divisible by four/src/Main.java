import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nrOfElements = scanner.nextInt();
        int[] array = new int[nrOfElements];
        int output = 0;
        for (int i = 0; i < nrOfElements; i++) {
            array[i] = scanner.nextInt();
            if (array[i] % 4 == 0 && array[i] > output) {
                output = array[i];
            }
        }
        System.out.println(output);
    }
}