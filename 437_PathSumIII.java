/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int total = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if(root != null){
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
        }

        helper(root, targetSum);
        return total;
    }

    public void helper(TreeNode root, long targetSum){
        if(root == null)
            total += 0;
        else if(root.val == targetSum){     //found end of path that works!
            helper(root.left, 0);       //see if there are any more paths you can count if nodes after this cancel each other
            helper(root.right, 0);
            total += 1;
        }
        else{
            helper(root.left, targetSum - root.val);
            helper(root.right, targetSum - root.val);
        }
        
    }
}