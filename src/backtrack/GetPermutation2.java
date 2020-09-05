import java.util.*;

public class GetPermutation2 {

    int count_track = 0;
    LinkedList<Integer> res = new LinkedList();

    public String getPermutation(int n, int k) {
        LinkedList<Integer> track = new LinkedList();

        backtrack(n, track, k);

        return toString(res);

    }

    public void backtrack(int n, LinkedList<Integer> track, int k) {

        if (count_track == k) {
            return;
        }

        if (track.size() == n) {
            count_track++;
            if (count_track == k)
                res = new LinkedList(track);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!track.contains(i)) {
                track.add(i);
                backtrack(n, track, k);
                track.removeLast();
            }
        }
    }

    public String toString(List list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GetPermutation2 getPermutation = new GetPermutation2();
        getPermutation.getPermutation(3, 1);
        System.out.println(getPermutation.res);
    }
}
