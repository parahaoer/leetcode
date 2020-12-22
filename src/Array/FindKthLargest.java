package Array;

public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        findKthLargest.findKthLargest(nums, k);
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quickSelect(nums, 0, n - 1, n - k);
        return nums[n - k];
        
    }

    public void quickSelect(int[] nums, int lo, int hi, int k) {
        int j = patition(nums, lo, hi);
        System.out.println(j);
        if (k > j) {
            quickSelect(nums, j + 1, hi, k);
        } else if (k < j) {
            quickSelect(nums, lo, j - 1, k);
        } else {
            return;
        }
    }

    public int patition(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return lo;
        int randomIdx = lo + 1 + (int) (Math.random() * (hi - lo));
        swap(nums, lo, randomIdx);
        int p = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] < p) {
                if (i == hi) break;
            }
            while (nums[--j] > p) {
                if (j == lo) break;
            }
            if (i >=j)
                break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}