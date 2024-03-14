import java.util.Scanner;
//Sum[Sum[i/j*(i+2),{j,1,10}],{i,1,10}]

public class Lab1 {
    static float calc(int a, int n, int b, int m) {
        float result = 0;
        int C = 2;

        if (n < a || m < b) {
            return 0;
        }

        if ((-C >= a) && (-C <= n)) {
            System.out.println("Вхід 0 є у проміжок.");
        } else {
            for (float i = a; i <= n; i++) {
                if (i != -C) {
                    float abc = i + C;
                    for (float j = b; j <= m; j++) {
                        if (j != 0) {
                            result += (i / j) / abc;
                        }
                    }
                }
            }
        }
        return result;
    }

    static int getUserInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = getUserInput(scanner, "Введіть значення a: ");
        int n = getUserInput(scanner, "Введіть значення n: ");
        int b = getUserInput(scanner, "Введіть значення b: ");
        int m = getUserInput(scanner, "Введіть значення m: ");

        scanner.close();

        float result = calc(a, n, b, m);
        System.out.println("Результат обчислень: " + result);
    }
}
