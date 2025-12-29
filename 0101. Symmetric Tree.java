// Bu soruda, bize verilen bir ağacın simetrik olup olmadığını kontrol etmemiz isteniyor.
// Ağacın simetrik olması, sol ve sağ alt ağaçlarının birbirinin aynası olduğu anlamına gelir.
// İlk olarak, ağacın kökünü kontrol ediyoruz. Eğer kök null ise, ağaç boş demektir ve 
// simetrik kabul edilir, bu yüzden true döndürüyoruz.
// Eğer kök varsa, bir yardımcı fonksiyon kullanarak sol ve sağ alt ağaçları birbirleriyle 
// karşılaştırıyoruz. Bu karşılaştırma, her düğümün sol alt ağacının sağ alt ağacına ve 
// sağ alt ağacının sol alt ağacına eşit olmasını kontrol eder.
// Yani, her iki alt ağaç da aynı yapıyı taşımalı, aynı değere sahip olmalı ve yerleri 
// ters olmalıdır. Eğer bu koşullar sağlanıyorsa, ağaç simetriktir ve true döneriz, değilse false döneriz.



class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        } 

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);

    }
}
