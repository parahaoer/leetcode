package String;

public class ReverseWords {
    public String reverseWords(String s) {


        String remainStr = removeExtraSpace(s);
        int len = remainStr.length();
        char[] charArray = remainStr.toCharArray();
        reverseString(charArray, 0, len-1);
        boolean isStarting = false;
        int start=0, end=0;
        for(int i=0; i<len; i++) {
            if((!isStarting) || (charArray[i] != ' ' && charArray[i-1] == ' ')) {
                start = i;

                isStarting = true;
            } 
            if(isStarting && i>0 && charArray[i] == ' ' && charArray[i-1] != ' ') {
                end = i-1;
                isStarting = false;
                reverseString(charArray, start, end);
            } 
            if(i==len-1) {
                end = i;
                reverseString(charArray, start, end);
            }
        }
        return String.valueOf(charArray);
    }

    public String removeExtraSpace(String s) {

        int fast=0;
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        while(fast < length && s.charAt(fast) == ' ')
            fast++;
        
        for(;fast<length; fast++) {
            if(fast>0 && s.charAt(fast) == s.charAt(fast-1) && s.charAt(fast) == ' ') {
                continue;
            } else {
                sb.append(s.charAt(fast));
            }
        }
        int sbLen = sb.length();
        if(sbLen>0 && sb.charAt(sbLen-1) == ' ')
            sb.deleteCharAt(sbLen-1);
        return sb.toString();
    }

    public void reverseString(char[] charArray, int left, int right) {

        while (left < right) {
            char tmp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String res = reverseWords.reverseWords("   a   b  c d   e  ");
        System.out.print(res);
    }
}