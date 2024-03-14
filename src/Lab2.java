import java.util.Random;
import java.util.Scanner;

public class Lab2 {
    static int getIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    static void showMatrix(long[][] matrix, int n, int m, int[] maxLength) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int padding = maxLength[j] - String.valueOf(matrix[i][j]).length();
                System.out.print(" ".repeat(padding) + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void sumCalc(long[][] matrix, int n, int m, long[] sums) {
        for (int i = 1; i < n; i += 2) {
            long extremum = matrix[i][0];
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] > extremum) {
                    extremum = matrix[i][j];
                }
            }
            sums[0] += extremum;
        }
        for (int i = 0; i < n; i += 2) {
            long extremum = matrix[i][0];
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] < extremum) {
                    extremum = matrix[i][j];
                }
            }
            sums[1] += extremum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int n = getIntInput(scanner, "Введіть кількість рядків (n): ");
        int m = getIntInput(scanner, "Введіть кількість стовпців (m): ");
        int a = getIntInput(scanner, "Задайте константу (a): ");

        long[][] matrix = new long[n][m];
        int[] maxLength = new int[m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = random.nextInt(501) - 250;
                int length = String.valueOf(matrix[i][j]).length();
                maxLength[j] = Math.max(maxLength[j], length);
            }
        }

        System.out.println("\nМатриця B[" + n + "x" + m + "]:");
        showMatrix(matrix, n, m, maxLength);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                matrix[i][j] *= a;
                int length = String.valueOf(matrix[i][j]).length();
                maxLength[j] = Math.max(maxLength[j], length);
            }
        }

        System.out.println("\nМатриця C[a * B]:");
        showMatrix(matrix, n, m, maxLength);

        long[] sums = new long[2];
        sumCalc(matrix, n, m, sums);

        System.out.println("\nСума найбільших елементів в рядках матриці з непарними номерами: " + sums[0]);
        System.out.println("Сума найменших елементів в стовпцях матриці з парними номерами: " + sums[1]);
    }
}
