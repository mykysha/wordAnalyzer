import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class FileReader {
    // Reads the file and returns the words in it.
    public static Vector<String> ReadFile(String path) {
        Vector<String> words = new Vector<>();
        java.io.FileReader inputStream;

        try {
            inputStream = new java.io.FileReader(path);
        } catch (FileNotFoundException e) {
            System.out.println("Could not read from the file. Perhaps the path is wrong?");

            return null;
        }

        BufferedReader br = new BufferedReader(inputStream);
        StringBuilder currWord = new StringBuilder();
        int ch;

        while (true) {
            try {
                ch = br.read();
            } catch (IOException e) {
                System.out.println("Oof, there should be a symbol that stops me from reading the file. " +
                        "Will do as is, ok?)");

                return words;
            }

            if (currWord.length() == 30 || !Character.isLetter(ch)) {
                if (currWord.length() > 0) {
                    words.add(currWord.toString());

                    currWord = new StringBuilder();
                }

                if (ch == -1) {
                    break;
                }
            }

            if (Character.isLetter(ch)) {
                currWord.append((char) ch);
            }
        }

        try {
            br.close();
        } catch (IOException e) {
            System.out.println("Uh-oh, something went REEEEALLY wrong and the file did not close properly.\n" +
                    "Please submit the bug to the nearest Java fan " +
                    "as the author of this would literally disintegrate from the panic");
        }

        return words;
    }
}
