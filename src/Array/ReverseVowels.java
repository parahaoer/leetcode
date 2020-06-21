class Solution {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        
        int n = chs.length;
        
        int i=0;
        int j= n-1;
        
        List<Character> list = new ArrayList();
        
        Collections.addAll(list, 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'); 
        
        while(i<j) {
                        
            while(i<j && !list.contains(chs[i])) {
                i++;
            }
            while(i<j && !list.contains(chs[j])) {
                j--;
                
            }
            
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
        
        return String.valueOf(chs);
    }
}