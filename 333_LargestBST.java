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
 // [0] min node value
 // [1] max node value
 // [2] size of max bst in that nodes subtree
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        int[] result = traverse(root);
        return result[2];
    }

    private int[] traverse(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        
        //good
        if(root.val > left[1] && root.val < right[0]){  //root can join the bst
            return new int[]{Math.min(left[0], root.val), Math.max(right[1], root.val), left[2] + right[2] + 1};
        }
        else{
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }
}