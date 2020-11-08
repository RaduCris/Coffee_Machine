import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int nr = scanner.nextInt();
            System.out.print(--nr + " ");
        }
    }
}