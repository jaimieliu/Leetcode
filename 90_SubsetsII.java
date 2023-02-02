class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        set.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> tempSet = new ArrayList<List<Integer>>();
            for(List<Integer> list: set){
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[i]);
                tempSet.add(temp);
            }
            set.addAll(tempSet);
        }

        return new ArrayList<>(set);
    }
}