package Array;


public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {2, 8, 3, 1, 7, 4, 6, 5, 9, 0};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums, 0, nums.length - 1);
        for (int n : nums)
            System.out.print(n + " ");
    }

    public void sort(int[] nums, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = patition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    private int patition(int[] nums, int lo, int hi) {
        if (lo == hi)
            return lo;
        int randomIdx = lo + 1 + (int) (Math.random() * (hi - lo));
        swap(nums, lo, randomIdx);
        int i = lo, j = hi + 1;
        int p = nums[lo];
        while (true) {
            while (nums[++i] < p)
                if (i == hi)
                    break;
            while (nums[--j] > p)
                if (j == lo)
                    break;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}