public class Main {

        public Node search(String data){
        Node current = head;
           while(current.data != data){
               current = current.next;
           }
           return current;
        }
        public void addEdge(String x, String y){
            Node edge = null;
            Node src = search(x);
            Node dst = search(y);
            if(src.sisi == null){
                src.sisi = edge;
            }
            else{
                Node tmp = src;
                while(tmp.sisi != null){
                    tmp = tmp.sisi;
                }
                tmp.sisi = edge;
            }
            edge.prev = dst;

        }

        public void display(){
            Node current = array[0].head;
            for(int i=0; i<vertex; i++){
                current = array[i].head;
                System.out.print("vertex " + current.data + " : ");
                while(current!=null){
                    System.out.print("-> " + current.data + " ");
                    current=current.next;
                }
                System.out.println();
            }   
        }

    public static void main(String[] args) {
        Main tes = new Main(7);
        tes.addEdge("Mataram", "Gerung");
        tes.addEdge("Mataram", "Selong");
        tes.addEdge("Mataram", "Praya");
        tes.addEdge("Selong", "Masbagik");
        tes.addEdge("Selong", "Sembalun");
        tes.addEdge("Gerung", "Kopang");
        tes.addEdge("Praya", "Kopang");
        tes.addEdge("Masbagik", "Sembalun");
        tes.addEdge("Masbagik", "Kopang");
        tes.display();

    }
}
