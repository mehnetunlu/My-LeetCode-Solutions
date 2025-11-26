// 19. Remove Nth Node From End od List

// Soruda bağlı bir listeden sondan n. düğümü silmemizi istemiş
// bu soru için floyd algoritmasını kullanacam

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // listeyi gezmek için geçici bir düğüm oluşturdum
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // pointerlerimi oluşturdum
        ListNode fast = dummy;
        ListNode slow = dummy;

        // biz sondan n. düğümü silmek istiyoruz. bu yuzden fast ve slow arasındaki mesafeyi n olacak şekilde ayarlıyorum.
        // fast pointer null olduğu zaman slow pointer silincek düğümden önceki düğümü gösteriyor olacak
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // fast pointerim null olana kadar pointerlerimi ilerletiyorum
        // fast null olduğunda slow pointer silinecek düğümün bir önceki düğümü gösterecek
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow pointeri silincek düğümden bir sonraki düğüme bağlıyorum
        slow.next = slow.next.next;

        // son olarak yeni bagli listeyi döndürüyorum
        return dummy.next;  
    }
}
