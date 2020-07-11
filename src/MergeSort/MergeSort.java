import java.util.Arrays;

/**
 * temp数组：在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
 * 所以每次做合并操作temp数组的内容都会发生改变。
 * 是将有序子数组 合并后放在temp数组中，然后将temp数组的内容拷贝到原数组的对应位置。
 *
 */
public class MergeSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] sortArray(int[] nums) {
        int n = nums.length;
        if(n==0) return null;
        int left =0, right = n-1;
        int[] temp = new int[n];
        sort(nums, left, right, temp);
        return nums;
    }

    //递归程序的运行是 不停的调用自身，直到到达左叶子节点，将左叶子节点运行完后，程序就会回到叶子节点的父节点，继续在父节点那一层运行，也就是运行右子树节点。
    public static void sort(int[] nums, int left, int right, int[] temp) {
        if(left < right) {
            int mid = left + (right - left) /2;
            sort(nums, left, mid, temp); //左边归并排序，使得左子序列有序
            sort(nums, mid+1, right, temp); //右边归并排序，使得右子序列有序
            merge(nums,left, mid, right, temp); //将两个有序子数组合并操作
        }
    }

    public static void merge(int[] nums, int left, int mid,  int right, int[] temp) {
        int i = left; //左序列指针
        int j = mid+1; //右序列指针
        int t = 0;  //临时数组指针
        while(i <= mid && j <=right) {
            if(nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }

        while(i<=mid) { //如果左序列有剩余， 将左边剩余元素填充进temp中
            temp[t++] = nums[i++];
        }

        while(j<=right) { //如果右序列有剩余，将右序列剩余元素填充进temp中
            temp[t++] = nums[j++];
        }

        //将temp中的元素全部拷贝到原数组的对应位置中
        t = 0;
        while(left <= right) {
            nums[left ++] = temp[t++];
        }
    }
}