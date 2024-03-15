import java.util.Arrays;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        while (true) {
            System.out.print("Будь ласка, введіть рядок (введення повинне містити букви): ");
            text = scanner.nextLine();

            if (text.isEmpty() || text.matches("\\d+")) {
                System.out.println("Введення не відповідає умовам, спробуйте знову.");
            } else {
                System.out.println("Ви ввели відповідний рядок: " + text);
                break;
            }
        }
        scanner.close();

        System.out.println(text);
        String[] eachWordArray = text.split(" ");
        System.out.println(Arrays.toString(eachWordArray));
    }
}
