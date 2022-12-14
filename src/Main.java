import java.util.HashSet;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        String path = "text.txt";

        if (args.length > 0) {
            path = args[0];
        } else {
            System.out.println("No path to the file was provided. Will use the default one.");
        }

        Vector<String> words = FileReader.ReadFile(path);

        if (words == null) {
            return;
        }

        HashSet<String> printedWords = new HashSet<>();

        for (String word : words) {
            if (printedWords.contains(word)) {
                continue;
            }

            if (WordAnalyzer.CheckIfOnlyEnglishVowels(word)) {
                System.out.println(word);

                printedWords.add(word);
            }
        }
    }
}
