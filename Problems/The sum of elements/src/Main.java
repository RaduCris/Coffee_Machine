import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int newNum;
        int sum = 0;
        while ((newNum=scanner.nextInt()) != 0) {
            sum += newNum;
        }
        System.out.println(sum);
    }
}
