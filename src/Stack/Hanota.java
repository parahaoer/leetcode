class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {

        if(n==1) {
            // ��n=1ʱ�� A�ƶ�ҲӦ���Ƕ������һ��Ԫ�ء�
            // ��Ϊ���n=2�� n-1Ҳ�ǵ���1�� ���ʹ��A.remove(0)�ƶ����е�һ��Ԫ�أ��ͻᷢ������
            C.add(A.remove(A.size()-1));
            return;
        }
        move(n-1, A, C, B);
        C.add(A.remove(A.size()-1));
        move(n-1, B, A, C);
    }
}