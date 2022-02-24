public class tesJurnal1 {
    class Node{
        String data;
        Node next;
        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;
    public int size = 0;

    void tambahNode(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            tail.next = null;
        }else{
            tail.next = newNode;
            tail = newNode;
            newNode.next = null;
        }
        size++;

    }

    void tukarNode(String data1, String data2){
        Node prevNode1 = null, prevNode2 = null, node1 = head, node2 = head; 
        if(head == null) { 
            return;  
        }  
        if(data1 == data2){
            return;  
        }
           
        while(node1 != null && node1.data != data1){
            prevNode1 = node1;  
            node1 = node1.next;  
        }  
          
        while(node2 != null && node2.data != data2){  
            prevNode2 = node2;  
            node2 = node2.next;  
        }   
        if(node1 != null && node2 != null) { 
            if(prevNode1 != null){
                prevNode1.next = node2;  
            }           
            else { 
                head  = node2;
            } 
            if(prevNode2 != null) { 
                prevNode2.next = node1; 
            }     
            else {
                head  = node1; 
            }
                 
            Node temp = node1.next; 
            node1.next = node2.next; 
            node2.next = temp; 
        }      
        else {  
            System.out.println("Tidak bisa tukar"); 
        }  

    }

    void tampilkan(){
        if(head == null){
            System.out.println("Linked list kosong");
        }else{
            Node current = head;
            for(int i = 0; i<size;i++){
                System.out.print( current.data + " ");
                current = current.next;
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        tesJurnal1 tes = new tesJurnal1();

        tes.tambahNode("Ginting"); 
        tes.tambahNode("Markus & Kevin"); 
        tes.tambahNode("Cesar");  
        tes.tambahNode("Fajar & Rian"); 
        tes.tambahNode("Jojo");
        System.out.println("Pentandingan awal"); 
        tes.tampilkan();
        System.out.println("Pertandingan selanjutnya");
        tes.tukarNode("Jojo","Cesar");
        tes.tampilkan();
    }
}
