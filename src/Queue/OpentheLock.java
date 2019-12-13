package Queue;

import java.util.*;

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            //size表示一个level中，队列含有几个元素。比如level=1时，初始时size=8；直到size=0，进入level=2；
            while(size > 0) {
                String s = q.poll();
                if(s.equals(target)) return level;
                if(deads.contains(s)) {
                    size --;
                    continue;
                }


                for(int i = 0; i < 4; i ++) {
                    char c = s.charAt(i);
                    String s1 = s.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + s.substring(i + 1);
                    String s2 = s.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + s.substring(i + 1);
                    if(!visited.contains(s1) && !deads.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !deads.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
                size --;
            }
            level ++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        OpentheLock opentheLock = new OpentheLock();
        int res = opentheLock.openLock(deadends, target);
        System.out.println(res);
    }
}
