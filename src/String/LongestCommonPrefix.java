package String;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i=1; i< strs.length; i++) {
            //当prefix为空串时， strs[i].indexOf(prefix) ==0,会退出while循环
            while(strs[i].indexOf(prefix) != 0) {
                //if(prefix.length()>=0)
                    //substring() 左闭右开
                    prefix = prefix.substring(0, prefix.length()-1);
                //else return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"dog", "racecar", "car"};
        longestCommonPrefix.longestCommonPrefix(strs);
    }
}
