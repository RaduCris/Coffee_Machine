import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        int n = scanner.nextInt();
        int current = 1;
        int count = 0;
    
        while (count != n) {
            for (int i = 0; i < current; i++) {
                System.out.print(current + " ");
                count += 1;
            
                if (count == n) {
                    break;
                }
            }
            current += 1;
        }
    }
}