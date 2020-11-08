import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nrOfElements = scanner.nextInt();
        int[] array = new int[nrOfElements];
        for (int i = 0; i < nrOfElements; i++) {
            array[i] = scanner.nextInt();
        }
        int[] product = new int[nrOfElements - 1];
        int j = 0;
    
        for (int i = 0; i < nrOfElements - 1; i++) {
            product[j] = array[i] * array[i + 1];
            j++;
        }
        int maxProductOfTwoAdjElem = product[0];
        for (int k = 1; k < product.length; k++) {
            if (maxProductOfTwoAdjElem < product[k]) {
                maxProductOfTwoAdjElem = product[k];
            }
        }
        System.out.println(maxProductOfTwoAdjElem);
    }
}