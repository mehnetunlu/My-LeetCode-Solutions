// Soruda bize verilen bir ağaç yapısını pre-order sırasında bağlı liste haline getirmemizi istiyor
// İlk olarak root'u curr olarak atıyoruz
// curr null olana kadar döngü ile geziniyoruz
// Eğer curr'in sol çocuğu varsa işlem yapıyoruz
// Sol alt ağacın en sağ node'unu buluyoruz
// Çünkü pre-order'da sol alt ağaç bittikten sonra sağ alt ağaç gelecek
// Sol alt ağacın en sağ node'unu curr'in sağ çocuğuna bağlıyoruz
// Sol alt ağacı curr'in sağına taşıyoruz
// Sol pointer'ı null yapıyoruz çünkü bağlı liste'de left hep null olmalı
// Sağa doğru ilerliyoruz
// Bunları yaptıktan sonra ağaç pre-order sırasında right pointer'lar ile bağlı liste haline gelir


class Solution {
    public void flatten(TreeNode root) {

        TreeNode curr = root;
        
        while (curr != null) {
            if (curr.left != null) {
                TreeNode rightmost = curr.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                
                rightmost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}

