import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        int heightOfBus = scan.nextInt();
    
        int heightOfBridges;
    
        int willCrash = 0;
    
        if (scan.hasNext()) {
            int numOfBridges = scan.nextInt();
        }
    
        for (int i = 1; scan.hasNext() ; i++) {
        
            heightOfBridges = scan.nextInt();
        
            if (heightOfBridges <= heightOfBus) {
                willCrash = 1;
                System.out.println("Will crash on bridge " + i);
                break;
            }
        }
        if (willCrash == 0) {
            System.out.println("Will not crash");
        }
    }
}