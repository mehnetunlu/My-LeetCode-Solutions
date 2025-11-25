// 141. Linked List Cycle

// Mantık basit, bize bir liste veriliyor ve bu listenin döngüsel olup olmadığını bulmamızı istiyor. 
// Bu tür sorularda en iyi çözüm Fast & Slow Pointer (Floyd's Algorithm) kullanmaktır.
// Listeyi koşu pisti olarak düşünelim:
// Fast pointer = Tavşan (her adımda 2 ileri gider)
// Slow pointer = Kaplumbağa (her adımda 1 ileri gider)
// Eğer pist daireselse Tavşan kaplumbağaya mutlaka yetişir (döngü var)
// Eğer pist düzse Tavşan pistin sonuna ulaşır, yetişemez (döngü yok)


public class Solution {
    public boolean hasCycle(ListNode head) {

        // ilk olarak liste olup olmadığını kontrol ediyoruz, liste yoksa false döndürecez
        if (head == null || head.next == null) {
            return false;
        }

        // sonrasında iki pointer oluşturup döngüye giriyoruz
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;  // 1 adım gitsin
            fast = fast.next.next; // 2 adım gitsin

            // eğer döngüde slow fast eşit olursa döngü var demektir, true döndürecez
            if (slow == fast) {
                return true;
            }
        }
        // döngü yoksa false döndürecez
        return false;
    }
}
