public class LinkedList {
    public Node head , tail = null;
    public Enque first,last;

    public void addNode(String nama){
        Node baru = new Node(nama);
        if(head == null){
            head = tail = baru;
        }
        else{
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
    }

    public String Dequeue(){
        String temp;
        Node current = head;
        if(current.next == null){
            temp = current.data;
            this.head = null;
        }
        else{
            head = head.next;
            current.next = null;
            temp = current.data;
        }
        return temp;
    }

    public void Enqueue(String data){
        Node baru = new Node(data);
        if(head == null){
            head = tail = baru;
        }
        else{
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
    }

    public  void Push(String data){
        Enque baru = new Enque(data);
        if(first==null) {
			first = last =  baru;
		}
		else {
            baru.next = first;
			first = baru;
        }
    }
}
