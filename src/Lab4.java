import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vetement[] vetementsArray = {
                new Vetement("Футболка", "Червоний", 42, 299.99, 4.5, true),
                new Vetement("Джинси", "Синій", 48, 599.99, 4.7, true),
                new Vetement("Куртка", "Чорний", 50, 999.99, 4.8, false),
                new Vetement("Спідниця", "Зелений", 38, 649.99, 4.6, true),
                new Vetement("Светр", "Білий", 46, 499.99, 4.4, false),
                new Vetement("Худі", "Чорний", 54, 399.99, 4.2, true),
                new Vetement("Шорти", "Синій", 40, 299.99, 4.6, true),
                new Vetement("Пальто", "Бежевий", 52, 1099.99, 4.9, false),
                new Vetement("Кросівки", "Білий", 44, 899.99, 4.8, true),
                new Vetement("Шарф", "Червоний", 0, 149.99, 4.3, true),

        };
        printVetements(vetementsArray, "[+] Весь одяг, що є в списку:");
        while (true) {
            System.out.println("""
            
            [+] Чи хочете ви застосувати стандартне сортування?
            [1] - За умовою
            [2] - Вручну
            [3] - Вихід""");
            String preChoice = getLine(scanner, "\n[+] Введіть обраний варіант: ");
            switch (preChoice) {
                case "1":
                    while (true) {
                        System.out.println("""

                                [+] Виберіть пункт для сортування за зростанням та другий за спаданням (через ,):
                                [1] - За іменем
                                [2] - За кольором
                                [3] - За розміром
                                [4] - За ціною
                                [5] - За рейтингом
                                [6] - За наявністю
                                [7] - Вихід""");
                        String input = getLine(scanner, "\n[+] Введіть обрані варіанти: ");
                        String[] choices = input.split(",\\s*");

                        if (choices.length == 2 && isNumber(choices[0]) && isNumber(choices[1])) {
                            if (isValidChoice(choices[0]) && isValidChoice(choices[1])) {
                                Arrays.sort(vetementsArray, compareVetements(choices[0], true));
                                printVetements(vetementsArray, "\n[+] Весь одяг після першого сортування:");
                                Arrays.sort(vetementsArray, compareVetements(choices[1], false));
                                printVetements(vetementsArray, "\n[+] Весь одяг після другого сортування:");
                                return;
                            } else {
                                System.out.println("\n[+] Неправильний вибір, введіть числа від 1 до 7.");
                            }
                        } else {
                            System.out.println("\n[+] Неправильний формат вводу. Будь ласка, введіть два числа через кому.");
                        }
                    }
                case "2":
                    while (true) {
                        System.out.println("""

                                [+] Виберіть за яким параметром відбувається сортування одягу:
                                [1] - За іменем
                                [2] - За кольором
                                [3] - За розміром
                                [4] - За ціною
                                [5] - За рейтингом
                                [6] - За наявністю
                                [7] - Вихід""");
                        String input = getLine(scanner, "\n[+] Введіть обраний варіант: ");
                        if ("7".equals(input)) {
                            System.out.println("\n[+] Ви успішно вийшли з програми. Гарного дня!");
                            return;
                        }
                        boolean isAscending = ascendingCheck(scanner);
                        if (input.matches("[1-6]")) {
                            Arrays.sort(vetementsArray, compareVetements(input, isAscending));
                            printVetements(vetementsArray, "\n[+] Весь одяг після сортування:");
                            return;
                        } else {
                            System.out.println("\n[+] Було обрано неправильний варіант, спробуйте ще раз!");
                        }
                    }
                case "3":
                    System.out.println("\n[+] Ви успішно вийшли з програми. Гарного дня!");
                    return;
                default:
                    System.out.println("\n[+] Було обрано неправильний варіант, спробуйте ще раз!");
            }
        }
    }

    static boolean ascendingCheck(Scanner scanner) {
        while (true) {
            System.out.println("""
                
                [+] Виберіть спосіб сортування одягу:
                [1] - За зростанням
                [2] - За спаданням""");
            String input = getLine(scanner, "\n[+] Введіть обраний варіант: ");
            switch (input) {
                case "1": return true;
                case "2": return false;
                default:
                    System.out.println("\n[+] Було обрано неправильний варіант, спробуйте ще раз!");
            }
        }
    }

    static String getLine(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    static boolean isNumber(String choice) {
        try {
            Integer.parseInt(choice);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isValidChoice(String choice) {
        int intChoice = Integer.parseInt(choice);
        return intChoice >= 1 && intChoice <= 7;
    }

    static void printVetements(Vetement[] array, String prompt) {
        System.out.println(prompt);
        for (Vetement vetement : array) {
            System.out.println(vetement);
        }
    }

    static Comparator<Vetement> compareVetements(String choice, boolean byAscending) {
        Comparator<Vetement> comparator = switch (choice) {
            case "1" -> Comparator.comparing(Vetement::getName);
            case "2" -> Comparator.comparing(Vetement::getColor);
            case "3" -> Comparator.comparingInt(Vetement::getSize);
            case "4" -> Comparator.comparingDouble(Vetement::getPrice);
            case "5" -> Comparator.comparingDouble(Vetement::getRate);
            case "6" -> Comparator.comparing(Vetement::getInStock);
            default -> throw new IllegalArgumentException("[+] Неправильний вибір.");
        };
        return byAscending ? comparator : comparator.reversed();
    }
}

class Vetement {
    String name;
    String color;
    int size;
    double price;
    double rate;
    boolean inStock;

    public String getName() { return name; }
    public String getColor() { return color; }
    public int getSize() { return size; }
    public double getPrice() { return price; }
    public double getRate() { return rate; }
    public boolean getInStock() { return inStock; }

    public Vetement(String name, String color, int size, double price, double rate, boolean inStock) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
        this.rate = rate;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return String.format("Name : %-9s | Color : %-9s | Size : %-2d | Price : %-7.2f $ | Rate : %-3.1f | In Stock : %-5b",
                name, color, size, price, rate, inStock);
    }
}
