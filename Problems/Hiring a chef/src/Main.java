//put imports you need here

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final ArrayList<String> lines = new ArrayList<>(5);
        try (final Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 5; i++) {
                lines.add(scanner.nextLine());
            }
        }
    
        System.out.println("The form for " + lines.get(0)
                + " is completed. We will contact you if we need a chef that cooks " + lines.get(4)
                + " dishes.");
    }
}