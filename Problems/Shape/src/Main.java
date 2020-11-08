import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        String message = "You have chosen a ";
        switch (input) {
            case 1:
                System.out.println(message + "square");
                break;
            case 2:
                System.out.println(message + "circle");
                break;
            case 3:
                System.out.println(message + "triangle");
                break;
            case 4:
                System.out.println(message + "rhombus");
                break;
            default:
                System.out.println("There is no such shape!");
                break;
        }
    }
}