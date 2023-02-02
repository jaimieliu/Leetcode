class Solution {
    // HashSet contains() method runs in O(1) time
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }
            else{
                set.add(nums[i]);
            }
        }

        for(Integer elem: set){
            return elem;
        }
        return 0;
    }
}