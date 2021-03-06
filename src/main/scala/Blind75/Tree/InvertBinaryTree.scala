package Blind75.Tree

/**
 * Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

/**
 * Definition for a binary tree node.
 */
private class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object InvertBinaryTree {
  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) return root
    var tempNode: TreeNode = null
    tempNode = invertTree(root.right)
    root.right = invertTree(root.left)
    root.left = tempNode
    root
  }
}