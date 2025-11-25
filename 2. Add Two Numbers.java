// 2. Add Two Numbers

// Mantık basit, soruda iki listede aynı indekste olanları toplamamızı elde oluşursa bir sonraki düğüme eklememizi istiyor.
// Bu soruda en iyi çözüm olarak dummy oluşturarak çözüm yapacaz
// dummy'i geçici düğüm olarak alıp listeleri sırayla dolaşıp topluyoruz


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // ilk olarak dummy düğümünü geçici olarak atıyruz ve başta eldemiz olmadığı için sıfır olarak kabul ediyoruz
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // sonrasında listeleri sıraya dolaşmaya başlıyoruz
        while (l1 != null || l2 != null || carry != 0) {
            
            int sum = carry; // ilk olarak carry değişkenini sum değişkenine atıyroum

            if (l1 != null) { // l1 null olmadığı surece l1 değerlerini sum'a ekliyorum ve l1'i 1 adım ilerletiyorum
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) { // l2 null olmadığı surece l2 değerlerini sum'a ekliyorum ve l2'i 1 adım ilerletiyorum
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(sum % 10);  // Yeni düğüm oluşturup birler basamağını (sum % 10) ekliyoruz
            current = current.next;
            carry = sum / 10; // Onlar basamağını (sum / 10) carry'e atıyoruz
        }
        return dummy.next; // son olarakta yeni liste mi döndürüyorum
    }
}
