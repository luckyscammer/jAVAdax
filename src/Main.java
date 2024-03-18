public class Main {
    public static void main(String[] args) {
        int groupNumber = 3525;

        int C3 = groupNumber % 3;
        int C13 = groupNumber % 17;
        int C11 = groupNumber % 11;

        System.out.println("C5: " + C3);
        System.out.println("C13: " + C13);
        System.out.println("C11: " + C11);
    }
}