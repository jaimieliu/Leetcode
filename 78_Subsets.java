class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> list = new HashSet<List<Integer>>();
        list.add(new ArrayList<Integer>());
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.add(numsList);
        int total = numsList.size() -1;
        
        remove(list, numsList);
        
        return new ArrayList<>(list);
    }
    
    public void remove(Set<List<Integer>> list, List<Integer> nums){
        for(int i = 0; i < nums.size(); i++){
            List<Integer> newList = new ArrayList<Integer>(nums);
            newList.remove(i);
            list.add(newList);
            remove(list, newList);
        }
    }
}