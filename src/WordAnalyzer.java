public class WordAnalyzer {
    // Checks if the word contains only English vowels.
    public static boolean CheckIfOnlyEnglishVowels(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!isEnglishVowel(word.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // Checks if the character is an English vowel.
    private static boolean isEnglishVowel(char ch) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};

        for (char vowel : vowels) {
            if (vowel == ch) {
                return true;
            }
        }

        return false;
    }
}
