class Solution {
    public int maxDepth(TreeNode root) {

// Bu soruda, bizden bir ağaç veri yapısının derinliğini bulmamız isteniyor.
// İlk olarak, ağacın kökünü kontrol ediyoruz. Eğer kök boş ise,
// bu durumda ağaç yok demektir ve derinlik 0 olmalıdır, bu yüzden 0 döndürüyoruz.
// Eğer kök varsa, ağaçta düğümler bulunuyor demektir. Bu durumda, 
// metodumuzu rekürsif olarak çağırıyoruz ve her alt ağacın derinliğini
// hesaplıyoruz. Sol ve sağ alt ağaçların derinlikleri arasında maksimum değeri alıp,
// 1 ekleyerek o anki düğümün derinliğini hesaplıyoruz. 
// Math.max fonksiyonu, iki değerin en büyüğünü alır, bu sayede derinliğin doğru bir şekilde
// hesaplanmasını sağlarız. 


        if (root == null) {
            return 0;
        }
        else {
            int left_depth = maxDepth(root.left);
            int right_depth = maxDepth(root.right);

            return Math.max(left_depth, right_depth) + 1;
        }
    }
}
