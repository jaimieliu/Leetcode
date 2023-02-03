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
    HashMap<TreeNode, Integer> map = new HashMap<>();       //represents upward climb child to parent 15->20->-10
    HashMap<TreeNode, Integer> map2 = new HashMap<>();      //represents child to parent to child 15->20->7
    public int maxPathSum(TreeNode root) {
        helper(root);   //now each node has their maximum sum that they are the start of, so now find the max value among the map
        helper2(root);

        int max1 = Collections.max(map.values());
        
        if(map2.isEmpty())
            return max1;
        
        int max2 = Collections.max(map2.values());
        return Integer.max(max1, max2);
    }

    public int helper(TreeNode root){
        if(root == null)
            return Integer.MIN_VALUE + 1000;
        map.put(root, root.val);
        int left = Integer.MIN_VALUE + 1000, right = Integer.MIN_VALUE + 1000;  //so if number = -1000 and is added to left or right it will still be neg min and not wrap around to max number area
        if(root.left != null || root.right != null){
            left = helper(root.left);
            right = helper(root.right);
        }
        int value = Math.max(map.get(root), Math.max(map.get(root) + left, map.get(root) + right));
        map.put(root, value);
        return value;
    }

    public void helper2(TreeNode root){
        if(root.left != null && root.right != null){
            int value = map.get(root.left) + map.get(root.right) + root.val;
            map2.put(root, value);
            helper2(root.left);
            helper2(root.right);
        }
        else if(root.left != null){
            int value = map.get(root.left) + root.val;
            map2.put(root, value);
            helper2(root.left);
        }
        else if(root.right != null){
            int value = map.get(root.right) + root.val;
            map2.put(root, value);
            helper2(root.right);
        }
    }
}