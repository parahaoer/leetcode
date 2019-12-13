package BinarySearch;

public class TwoSumInputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {

        for(int i=0; i<numbers.length; i++) {
            int lo=i+1;
            int hi =numbers.length-1;
            while(lo <= hi) {
                int mid = lo + (hi-lo)/2;
                if(numbers[mid] == target-numbers[i])
                    return new int[]{i, mid};
                else if(numbers[mid] > target-numbers[i]) {
                    hi = mid -1;
                } else if(numbers[mid] < target-numbers[i]) {
                    lo = mid +1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{5,25,75};
        int target = 100;
        TwoSumInputarrayissorted twoSumInputarrayissorted = new TwoSumInputarrayissorted();
        twoSumInputarrayissorted.twoSum(numbers, target);
    }
}
