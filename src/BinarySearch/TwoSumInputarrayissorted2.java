package BinarySearch;

public class TwoSumInputarrayissorted2 {

    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i<numbers.length; i++) {
            int l = i+1, r = numbers.length-1;
            while(l <=r) {
                int mid = l + (r-l)/2;
                //i+1,mid+1 是因为题目是从1开始计数，不是从0开始计数
                if(numbers[mid] == target-numbers[i]) return new int[]{i+1, mid+1};
                else if(numbers[mid] > target-numbers[i]) r = mid-1;
                else l = mid +1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSumInputarrayissorted2 twoSumInputarrayissorted = new TwoSumInputarrayissorted2();
        twoSumInputarrayissorted.twoSum(numbers, target);
    }
}
