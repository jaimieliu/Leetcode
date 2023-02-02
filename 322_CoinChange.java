class Solution {
    public int coinChange(int[] coins, int amount) {
        //finding coins for this big amount, find coins for each value smaller than it
        
        int[] amounts = new int[amount+1];
        //each amounts[i] is its own amount
        
        Arrays.fill(amounts, Integer.MAX_VALUE);
        amounts[0] = 0;
        //coin could be apart of the coins to get to this amount
                    //say amounts[i] is 32, and coin is 25, then youre trying to find okay the number of coins needed to get to 7, and then add 1, bc 25 can be added, if this is smaller than waht it is then use this
                    //otherwise use what you had before
                    
                    //i.e. coins = 2 dimes, 1 nickle, 7 pennies = 9 coins, but if you look 25 lower than amount (only doing this now since you have a 25 coin) can see how many coins to get to 7, add 1 and if less this is new value of min coins to get to that number
                    //eventually have the min number of coins for your amount
        
        for(int i = 1; i < amounts.length; i++){
            for(int coin: coins){
                if(coin <= i && amounts[i-coin] != Integer.MAX_VALUE){
                    amounts[i] = Math.min(amounts[i], amounts[i-coin] + 1);
                }
            }
        }
        if(amounts[amount] != Integer.MAX_VALUE)
            return amounts[amount];
        return -1;
    }
}