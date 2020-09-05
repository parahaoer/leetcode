import java.util.*;

public class GetPermutation {
    int count_track = 0;
    LinkedList<Integer> res = new LinkedList();

    public String getPermutation(int n, int k) {
        LinkedList<Integer> track = new LinkedList();
        
        backtrack(n, track, k);

        return toString(res);

    }

    public boolean backtrack(int n, LinkedList<Integer> track, int k) {


        if(track.size() == n) {
            count_track ++;
            if(count_track == k) 
                res = new LinkedList(track);

            return true;
        }

        for(int i=1; i<=n; i++) {
            if(!track.contains(i)) {
                track.add(i);
                if(backtrack(n, track, k) && count_track == k)
                    return true;
                track.removeLast();
            }
        }
        return false;
    }

    public String toString(List list) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GetPermutation getPermutation  = new GetPermutation();
        getPermutation.getPermutation(3,1);
        System.out.println(getPermutation.res);
    }
}
