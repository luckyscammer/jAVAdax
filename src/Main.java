public class Main {
    public static void main(String[] args) {
        int groupNumber = 3525;

        int C5 = groupNumber % 5;
        int C7 = groupNumber % 7;
        int C11 = groupNumber % 11;

        System.out.println("C5: " + C5);
        System.out.println("C7: " + C7);
        System.out.println("C11: " + C11);
    }
}
