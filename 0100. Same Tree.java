class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

// Bu soruda bizden iki ağacın aynı olup olmadığını kontrol eden bir metod yazmamız isteniyor.
// İlk olarak, her iki ağacın kökünü kontrol ediyoruz.
// Eğer her iki ağaç da boşsa, ağaçlar aynıdır, bu yüzden true döndürüyoruz.
// Eğer sadece birinin kökü boşsa, diğerinin kökü boş değilse, ağaçlar farklıdır ve false döndürüyoruz.
// Eğer her iki ağaçta da kök varsa, köklerin değerlerini karşılaştırıyoruz.
// Köklerin değerleri farklıysa, ağaçlar farklıdır, bu yüzden false döndürüyoruz.
// Eğer köklerin değerleri aynıysa, sol ve sağ alt ağaçları rekürsif olarak karşılaştırıyoruz.
// Hem sol alt ağaçların hem de sağ alt ağaçların aynı olması durumunda ağaçlar aynıdır ve true döndürüyoruz.
// Eğer sol veya sağ alt ağaçlardan biri farklıysa, ağaçlar farklıdır ve false döndürüyoruz.


        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
