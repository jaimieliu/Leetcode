class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> output = new ArrayList<String>();

        int first, second;

        if(nums.length == 0){
            if(lower != upper)
                output.add(lower + "->" + upper);
            else
                output.add(String.valueOf(lower));
        }
        if(nums.length != 0 && nums[0]-1 == lower){
            output.add(String.valueOf(lower));
        }
        else if(nums.length != 0 && nums[0] > lower){
            output.add(lower + "->" + (nums[0]-1));
        }

        for(int i = 0; i < nums.length - 1; i++){
            first = nums[i] + 1; 
            second = nums[i+1] -1;
            if(first == second){
                output.add(String.valueOf(first));
            }
            else if(second > first){
                output.add(first + "->" + second);
            }
        }

        if(nums.length != 0 && nums[nums.length-1]+1 == upper){
            output.add(String.valueOf(upper));
        }
        else if(nums.length != 0 && nums[nums.length-1] < upper){
            output.add((nums[nums.length-1] + 1) + "->" + upper);
        }

        return output;
    }
}