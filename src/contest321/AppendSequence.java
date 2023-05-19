package contest321;

/**
 * You are given two strings s and t
 * consisting of only lowercase English letters.
 *
 * Return the minimum number of characters that need to be
 * appended to the end of s so that t becomes a subsequence of s.
 *
 * A subsequence is a string that can be derived from another
 * string by deleting some or no characters without changing the order of the remaining characters.
 *
 *
 * **/

public class AppendSequence {

    public int appendCharacters(String s, String t) {
        int result = 0;
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            var ch = t.charAt(i);
            var temp = string.toString() + ch;
            if (!s.contains(temp)) {
                string.append(ch);
            } else {
                result += string.length();
                string = new StringBuilder();
            }
        }
        return result + string.length();
    }

    public static void main(String[] args) {
        var sequence = new AppendSequence();
        System.out.println(sequence.appendCharacters("coaching", "coding"));
        System.out.println(sequence.appendCharacters("abcde", "a"));
        System.out.println(sequence.appendCharacters("z", "abcde"));
        System.out.println(sequence.appendCharacters("iloveyoubaggionoila", "starkndustry"));
    }

}

