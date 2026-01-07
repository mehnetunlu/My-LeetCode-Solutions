// Bu soruda bize verilen bir ağaçta, kökten yapraklara kadar olan yolların oluşturduğu sayıların toplamını bulmamız isteniyor.
// bunu yapabilmek için ilk olarak  DFS ile ağacı kökten yaprağa doğru traverse ediyoruz
// Her düğümde mevcut yol sayısını güncelliyoruz
// Yaprak düğüme ulaştığımızda (sol ve sağ child yok):
// O yolun oluşturduğu sayıyı return ediyoruz
// Her düğümde sol ve sağ alt ağaçların toplamını return ediyoruz
// Böylece tüm yaprak düğümlerin oluşturduğu sayılar toplanmış oluyor

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
