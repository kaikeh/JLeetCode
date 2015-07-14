/**
 *Question
 *Invert a binary tree.
 *
 *     4
 *   /   \
 *  2     7
 * / \   / \
 *1   3 6   9
 *to
 *     4
 *   /   \
 *  7     2
 * / \   / \
 *9   6 3   1
 *Trivia:
 *This problem was inspired by this original tweet by Max Howell:
 *Google: 90% of our engineers use the software you wrote (Homebrew), 
 *but you can’t invert a binary tree on a whiteboard so fuck off.
**/

//Solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //recursion
    public TreeNode invertTree(TreeNode root) {
        if(root != null) {
        	TreeNode temp;
        	temp = root.left;
        	root.left = root.right;
        	root.right = temp;
        	invertTree(root.left);
        	invertTree(root.right);
        }
        return root;
    }
    
    //non-recursion
    public TreeNode invertTreeNoRecursion(TreeNode root) {
    	Queue<TreeNode> treeQueue =  new LinkedList<>();
    	treeQueue.offer(root);
    	while(!treeQueue.isEmpty()) {
    		TreeNode p, pTmp;
    		p = treeQueue.poll();
    		if(p != null) {
    			pTmp = p.left;
    			p.left = p.right;
    			p.right = pTmp;
    			if(p.left != null)
    				treeQueue.offer(p.left);
    			if(p.right != null)
    				treeQueue.offer(p.right);
    		}
    	}
    	return root;
    }
}
