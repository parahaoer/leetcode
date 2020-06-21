class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n==0) return true;
        
        int i = 0;
        int j= n-1;
        
        while(i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            // 通过ASCII 判断字符不是数字或者字母
            if(!((a >= 97 && a <= 122) || (a>=65 && a<=90) || (a>=48 && a<=57))) { 
                i++;
                continue;
            }
            if(!((b >= 97 && b <= 122) || (b>=65 && b<=90) || (b>=48 && b<=57))) { 
                j--;
                continue;
            }
            //System.out.println(Character.toLowerCase('2')); 结果为2，将数字字符转换成小写，结果仍然是本身
            if(Character.toLowerCase(a) != Character.toLowerCase(b)) return false;
            i++;
            j--;
        }
        return true;
    }
}