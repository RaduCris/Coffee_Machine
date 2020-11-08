import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a;
        double b;
        double c;
    
        switch (sc.next()) {
            case "triangle":
                a = sc.nextDouble();
                b = sc.nextDouble();
                c = sc.nextDouble();
                double p = (a + b + c) / 2;
                System.out.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
                break;
            case "rectangle":
                a = sc.nextDouble();
                b = sc.nextDouble();
                System.out.println(a * b);
                break;
            case "circle":
                a = sc.nextDouble();
                System.out.println(3.14 * a * a);
                break;
            default:
        
        
        }
    }
}