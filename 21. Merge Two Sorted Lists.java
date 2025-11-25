// 21. Merge Two Sorted Lists

// mantık basit, soruda elimizde iki liste olduğunu ve bu listedeki elemanları küçükten büyüğe sırayla birleştirmemizi istiyor.
// bu soru için en iyi çözüm olarak dummy adında yeni bir liste oluşturup elemanları karşılaştırarak sırayla yeni listeye eklemek 

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // ilk olarak yeni bir ldüğüm oluşturuoyuz sonrasında bunu geçici olarak currente atıyoruz
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // listelerdeki bütün elemanları dolaşana kadar düğüm değerlerini karşılşatırıp currente ekliyoruz
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            }
            else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }
        else {
            current.next = list2;
        }
        // son olarakta oluşan yeni listeyi döndürüyoruz
        return dummy.next; 
    }
}
