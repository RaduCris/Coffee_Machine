import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        System.out.println(
                str1.replaceAll("\\s", "")
                        .equals(
                                str2.replaceAll("\\s", "")));
    }
}