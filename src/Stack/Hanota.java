class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {

        if(n==1) {
            // 当n=1时， A移动也应该是队列最后一个元素。
            // 因为如果n=2。 n-1也是等于1。 如果使用A.remove(0)移动队列第一个元素，就会发生错误。
            C.add(A.remove(A.size()-1));
            return;
        }
        move(n-1, A, C, B);
        C.add(A.remove(A.size()-1));
        move(n-1, B, A, C);
    }
}