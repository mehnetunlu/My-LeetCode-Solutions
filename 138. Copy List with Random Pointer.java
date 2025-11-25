// 138. Copy List with Random Pointer

// Soruda bir bağlı liste verilmiş ve bu bağlı listenin bir next işaretçisi bir random işaretçisi var.
// Bizden bu bağlı listenin bir kopyasını oluşturmamız istenmiş
// bu soruyu çözmek için ;
//  ilk olarak her düğümün bir kopyasını oluşturup bir sonraki düğüm olarak atayacaz (1 -> 1' -> 2 -> 2' -> 3 -> 3')
//  sonrasında işaretçileri kopyalayacaz (next, random işaretçileri)
//  son olarak listedeki kopyaları ayırıp oluşan yeni listeyi döndürecez

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Adım 1: Kopya düğümler ekle (original -> copy -> original -> copy)
        Node curr1 = head;
        while(curr1 != null) {
            Node copy = new Node(curr1.val);
            copy.next = curr1.next;
            curr1.next = copy;
            curr1 = copy.next;
        }

         // Adım 2: Random pointer'ları kopyala
         Node curr2 = head;
         while (curr2 != null) {
            if (curr2.random != null) {
                curr2.next.random = curr2.random.next;
            }
            curr2 = curr2.next.next;
         }

         // Adım 3: Listeleri ayır
         Node copyHead = head.next;
         Node original = head;
         Node copy = copyHead;

         while (original != null) {
            original.next = original.next.next;
            copy.next = (copy.next != null) ? copy.next.next : null;
            original = original.next;
            copy = copy.next;
         }
         return copyHead;            
    }
}
