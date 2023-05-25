public class BinaryTreeFromPre_In {
    static int index = 0;

    public static void main(String[] args) {
        int pre[] = {3,9,20,15,7};
        int in[] = {9,3,15,20,7};

        var n = buildTree(pre, in);
        System.out.println(n.val);
        
    }

    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return buildTreeU(preorder, inorder, 0, n-1);
    }

    static public TreeNode buildTreeU(int[] preorder, int[] inorder, int l, int r) {
        if (l<=r && index < inorder.length) {
            int key = preorder[index];
            index++;
            int p = bin(inorder, key, l, r);
            var node = new TreeNode(key);
            node.left = buildTreeU(preorder, inorder, l, p-1);
            node.right = buildTreeU(preorder, inorder, p+1, r);
            return node;
        }
        return null;
    }

    static public int bin(int[] inorder, int key, int l, int r) {
        int i = l;
        while (i<=r) {

            if (inorder[i] == key) {
                return i;
            }
            i++;
        }
        return -1;
    }
}


   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
