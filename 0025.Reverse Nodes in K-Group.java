// 25.Reverse Nodes in K-Group

// soruda bize bir liste verildiğini ve bu listeyi gruplar halinde ters çevirmemizi istemiş
// örnek olarak listemiz 1 -> 2 -> 3 -> 4 -> 5 olsun ve k=2 olsun 
// k = 2 olduğu için listeyi 2 li gruplar haline getirip ters çevirmemiz gerekiyor
// çıktmız  2 -> 1 -> 4 -> 3 -> 5 olur (Son grup 1 elemanlı olduğu için ters çevirmeye gerek yok)

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Eğer liste boşsa ya da k=1 ise ters çevirmeye gerek yok
        if (head == null || k == 1) {
            return head;
        }  
        
        // listeyi gezebilmek için geçici bir dummy oluşturuyoruz
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode current = head;
        
        while (current != null) {
            ListNode groupStart = current;
            int count = 0;
            
            // Önce k kadar eleman olup olmadığını kontrol ediyoruz
            while (current != null && count < k) {
                current = current.next;
                count++;
            }
            
            // Eğer k kadar eleman varsa, grubu tersine çevir
            if (count == k) {
                ListNode prev = null;
                ListNode next = null;
                ListNode groupEnd = groupStart;
                
                // k elemanını tersine çeviriyoruz
                // bunu yaparken bağlantıları değiştiriyoruz
                while (groupStart != current) {
                    next = groupStart.next;
                    groupStart.next = prev;
                    prev = groupStart;
                    groupStart = next;
                }
                
                // Grup tersine çevrildikten sonra, önceki grubun sonunu yeni gruba bağla
                prevGroupEnd.next = prev;
                
                // Tersine çevrilen grubun sonundaki elemanları geri bağla
                groupEnd.next = current;
                
                // Bir sonraki grup için prevGroupEnd'i güncelle
                prevGroupEnd = groupEnd;
            }
        }
        
        // dummy.next baştan değişmiş olan listeyi döndürüyor
        return dummy.next;
    }
}
