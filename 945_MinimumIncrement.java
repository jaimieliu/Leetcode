class Solution {
    public int minIncrementForUnique(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }

        Arrays.sort(nums);
        Set<Integer> set = new HashSet<Integer>();
        int count = 0, last = 0;

        for(int num: nums){
            if(!set.contains(num)){
                set.add(num);
                last = num;
            }
            else{
                //num + 1, but last + 1 in case of 111 121 123 not 121 122
                last = last + 1;
                set.add(last);
                count += last - num;
            }
        }

        return count;

    }
}