public class CountSmaller {
    /**
     * 因为在归并排序的过程中，元素的位置会变化，所以使用索引数组来替代元素数组进行归并排序
     * “原始数组” 不变，用于比较两个元素的大小，真正位置变换的是 “索引数组”。
     */
    
    public static void main(String []args){
        int []arr = {5,2,6,1};
        Solution s = new Solution();
        List<Integer> list = s.countSmaller(arr);
        System.out.println(list);
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList();
        if(n ==0) return list;
        int left = 0, right = n-1;
        int[] temp = new int[n];
        int[] res = new int[n];
        int[] indexes = new int[n];

        for(int i=0; i<n; i++) {
            indexes[i] = i;
        }

        sort(nums, left, right, temp, res, indexes);

        for(int i=0; i<res.length; i++) {
            list.add(res[i]);
        }

        return list;
    }

    public  void sort(int[] nums, int left, int right, int[] temp, int[] res, int[] indexes) {
        if(left < right) {
            int mid = left + (right - left) /2;
            sort(nums, left, mid, temp, res, indexes); //左边归并排序，使得左子序列有序
            sort(nums, mid+1, right, temp, res, indexes); //右边归并排序，使得右子序列有序
            merge(nums,left, mid, right, temp, res,indexes); //将两个有序子数组合并操作
        }
    }

    public  void merge(int[] nums, int left, int mid,  int right, int[] temp, int[] res, int[] indexes) {
        int i = left; //左序列指针
        int j = mid+1; //右序列指针
        int t = 0;  //临时数组指针
        
        while(i <= mid && j <=right) {
            if(nums[indexes[i]] <= nums[indexes[j]]) {
                res[indexes[i]] += j- mid - 1;
                temp[t++] = indexes[i++];
            } else {
                temp[t++] = indexes[j++];
            }
        }

        while(i<=mid) { //如果左序列有剩余， 将左边剩余元素填充进temp中
            
            res[indexes[i]] += right - mid;
            temp[t++] = indexes[i++];
        }

        while(j<=right) { //如果右序列有剩余，将右序列剩余元素填充进temp中
            temp[t++] = indexes[j++];
        }

        //将temp中的元素全部拷贝到索引数组的对应位置中
        t = 0;
        while(left <= right) {
            indexes[left ++] = temp[t++];
        }
    }
}