import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt() + 1;
        while (number % 2 != 0) {
            number++;
        }
        System.out.println(number);
    }
}