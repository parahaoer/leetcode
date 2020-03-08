package String;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ') continue;
            if (s.charAt(i) != ' ' && s.charAt(i+1) == ' ')
                return null;
        }
        return  null;
    }
}
