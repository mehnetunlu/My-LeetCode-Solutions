// Soruda bize bir binary tree ve bir targetSum veriliyor
// Root'tan başlayıp leaf node'a kadar olan herhangi bir yolda,
// tüm node değerlerinin toplamının targetSum'a eşit olup olmadığını kontrol etmemiz isteniyor
// Eğer böyle bir yol varsa true, yoksa false döndürüyoruz


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        int remainingSum = targetSum - root.val;

        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);

        
    }
}
