//put imports you need here

import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            strings.push(scanner.next());
        }
        while (!strings.empty()) {
            System.out.println(strings.pop());
        }
    }
}