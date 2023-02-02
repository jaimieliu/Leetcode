class Solution {
    public int findMin(int[] nums) {
        //must run in log n time 
        //binary search
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start < end){
            mid = (start + end)/2;
            if(nums[mid] < nums[end])
                end = mid;
            else
                start = mid + 1;
        }
        return nums[end];
    }
}