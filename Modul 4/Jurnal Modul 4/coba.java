
public class coba {
    Node awal, last;
    Enque head, tail;

    public void insert(int masuk){
	Node baru;
	baru = new Node();
	baru.data = masuk;
	baru.next = null;
        baru.sisi=null;
        baru.back=null;
	if(awal == null){
            awal = baru;
	} else {
            last = awal;
            while(last.next != null){
		last = last.next;
            }
            last.next = baru;
	}
    }
    
    public void AddEdge(int asal, int tujuan){
		Node edge = new Node();
		Node src = Search(asal);
		Node dst = Search(tujuan);
		if(src.sisi==null){
			src.sisi = edge;
		} else{
                    Node tmp = src;
                    while(tmp.sisi!=null){
                        tmp = tmp.sisi;
                    }
                    tmp.sisi = edge;
		}
		edge.back = dst;
	}
    
    Node Search(int data){
		Node nemu = awal;
		while(nemu.data!=data){
                    nemu = nemu.next;
		}
		return nemu;
	}

    public void adjacency (){
        Node curr = awal;
        while (curr!=null){
            System.out.print(curr.data);
            if(curr.sisi!=null){
                Node temp = curr;
                while(temp.sisi!=null){
                    System.out.print("--->"+temp.sisi.back.data);
                    temp=temp.sisi;
                }
            }
            System.out.println();
            curr=curr.next;
        }
        
    }
    
    
    public void DFS (coba stack){
        Node from = awal;
        stack.push(from.data);
        from.tanda=1;
        
        while (from!=null){
            Node temp = from;
            System.out.print(stack.pop().data+" ");
            while(from.sisi!=null){
                if(from.sisi.back.tanda!=1){
                    stack.push(from.sisi.back.data);
                    from.sisi.back.tanda=1;
                }
                from=from.sisi;
            }   
            from=temp.next;
        }
    }
    
    public void push (int masuk){
        Enque baru = new Enque (masuk);
        
        if(head==null){
            head=tail=baru;
        } else {
            baru.next=head;
            head=baru;
        }
    }
        
    Enque pop (){
     Enque bantu=head;
        if(bantu==null){
            return null;
        } else {
            head=head.next;
            bantu.next=null;
        }
        return bantu;
    }
    
    public void BFS (coba equ){
        Node from = awal;
        equ.enqueue(from.data);
        from.tanda=1;
        Node temp = from;
        
        while (temp!=null){
            from = temp;
            while(from.sisi!=null){
                if(from.sisi.back.tanda!=1){
                    equ.enqueue(from.sisi.back.data);
                    from.sisi.back.tanda=1;
                }
                from=from.sisi;
            }   
            System.out.print(equ.dequeue().data+" ");
            if(equ.head!=null)
                temp=Search(equ.head.data);
            else
                break;
        }
    }
        
    public void enqueue(int masuk){
        Enque baru = new Enque(masuk);
        if (tail==null) {
            head=tail=baru;
        } else {
            tail.next=baru;
            baru.prev=tail;
            tail=baru;
        }
    }
    
    Enque dequeue(){
        Enque temp = head;
        if (temp!=null){
            head=head.next;
            temp.next=null;
        }
        return temp;
    }
    
    public static void main(String[] args) {
        coba graph = new coba();
        coba graph2 = new coba();
        coba equ = new coba();
        coba stack = new coba();
      
        for(int i=0; i<=6; i++){
            graph.insert(i);
            graph2.insert(i);
        }
        
        graph.AddEdge(0, 1);
        graph.AddEdge(4, 0);
        graph.AddEdge(2, 0);
        graph.AddEdge(1, 2);
        graph.AddEdge(1, 5);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 4);
        graph.AddEdge(4, 6);
        graph.AddEdge(5, 6);
        
        
        System.out.println();
        System.out.println("Adjacency :");
        graph.adjacency();
        
        System.out.println();
        System.out.println("BFS :");
        graph.BFS(equ);
        
        graph2.AddEdge(0, 1);
        graph2.AddEdge(4, 0);
        graph2.AddEdge(2, 0);
        graph2.AddEdge(1, 5);
        graph2.AddEdge(1, 2);
        graph2.AddEdge(2, 3);
        graph2.AddEdge(3, 4);
        graph2.AddEdge(4, 6);
        graph2.AddEdge(5, 6);
        
        System.out.println();
        System.out.println();
        System.out.println("DFS :");
        graph2.DFS(stack);
        
        System.out.println();
        
    }	
}
