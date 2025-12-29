// Bu soruda, bize verilen bir ağacın ters çevrilmesi isteniyor.
// İlk olarak, ağacın kökünü kontrol ediyoruz. Eğer kök null ise, ağaç boş demektir,
// bu yüzden null döndürüyoruz. Eğer kök varsa, işlemi gerçekleştirmeye başlıyoruz.
// Kök düğümünde, sol ve sağ alt ağaçları yer değiştiriyoruz. Yani, kökün sol çocuğu
// sağ çocukla, sağ çocuğu ise sol çocukla yer değiştiriyor.
// sonrasında, her bir alt ağaç için aynı işlemi rekürsif olarak uyguluyoruz. Yani, 
// sol ve sağ alt ağaçları ters çeviriyoruz. Bu işlem her alt ağaç için tekrarlanır,
// böylece tüm ağaç ters çevrilmiş olur.


class Solution {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;        
    }
}
