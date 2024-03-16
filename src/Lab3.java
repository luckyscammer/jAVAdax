import java.util.Scanner;
import java.util.Arrays;

@SuppressWarnings("StringBufferReplaceableByString")
public class Lab3 {
    public static String vowelsToCount = "aeiouyAEIOUYаеєиіїоуюяАЕЄИІЇОУЮЯ";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Будь ласка, введіть рядок (введення повинне містити букви): ");
            String input = scanner.nextLine();
            StringBuilder textBuilder = new StringBuilder(input);

            if (input.isEmpty() || input.matches("\\d+") || !input.matches(".*[" + Lab3.vowelsToCount + "].*")) {
                System.out.println("Введення не відповідає умовам, спробуйте знову.");
                textBuilder.setLength(0);
            } else {
                System.out.println("Ви ввели відповідний рядок: " + textBuilder);
                scanner.close();
                StringBuilder noSymbolsBuilder = deleteSymbols(textBuilder);
                System.out.println("Відредагований текст без зайвих символів: " + noSymbolsBuilder);
                String[] textBuilderWords = noSymbolsBuilder.toString().split("\\s+");
                Arrays.sort(textBuilderWords, (firstWord, secondWord) -> {
                    int vowelsCount1 = countVowels(firstWord);
                    int vowelsCount2 = countVowels(secondWord);
                    if (vowelsCount1 != vowelsCount2) {
                        return vowelsCount1 - vowelsCount2;
                    } else {
                        return firstWord.length() - secondWord.length();
                    }
                });
                String resultString = String.join(" ", textBuilderWords);
                StringBuilder finishedTextBuilder = new StringBuilder(resultString);
                System.out.println("Відсортований текст за зростянням кількості голосних у слові: " + finishedTextBuilder);
                break;
            }
        }
    }

    static StringBuilder deleteSymbols(StringBuilder textBuilder) {
        for (int i = textBuilder.length() - 1; i >= 0; --i) {
            if (!Character.isLetter(textBuilder.charAt(i)) && textBuilder.charAt(i) != ' ') {
                textBuilder.deleteCharAt(i);
            }
        }
        return textBuilder;
    }

    static int countVowels(String word) {
        int count = 0;
        for (int i = 0; i <= word.length() - 1; ++i) {
            if (Lab3.vowelsToCount.indexOf(word.charAt(i)) != -1) {
                ++count;
            }
        }
        return count;
    }
}
