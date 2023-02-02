class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<Integer>();
        for(int num: nums)
            list.add(num);
        for(int i = 0; i < list.size(); i++){
            int i2 = list.indexOf(target - list.get(i));
            if(i2 != -1 && i != i2){
                return new int[]{i, i2};
            }
        }
        return new int[]{0,0};
    }
}