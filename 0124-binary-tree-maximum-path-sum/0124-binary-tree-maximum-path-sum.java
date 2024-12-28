/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int maxi; // To store the maximum path sum globally
    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE; // Initialize maxi to the smallest possible value
        helper(root);             // Start the recursive helper function
        return maxi;              // Return the result
    }
    private int helper(TreeNode root) { // Calculates path sum of a node
        if (root == null) return 0;
        int val = root.val;
        // Recursively calculate maximum contributions from left and right subtrees
        int maxL = Math.max(0, helper(root.left));  // Include positive contributions only
        int maxR = Math.max(0, helper(root.right)); // Include positive contributions only
        // Calculate the current path sum including the current node
        int cpath = val + maxL + maxR;
        // Update the global maximum path sum
        maxi = Math.max(maxi, cpath);
        // Return the maximum sum of paths including the current node and one of its subtrees
        return val + Math.max(maxL, maxR);
    }
}
