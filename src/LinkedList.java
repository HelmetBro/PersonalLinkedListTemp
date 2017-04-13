public class LinkedList implements Comparable {
    private Node head;
    private int listCount;

    public LinkedList(){

        //change new node to add new data for use
        head = new Node(null);
        listCount = 0;
    }

    public void add(Object data){
        Node temp = new Node(data);
        Node current = head;

        //head node, iterate to end of the list
        while(current.getNext() != null){
            current = current.getNext();
        }

        // the last node's next reference set to new node
        current.setNext(temp);

        //increment size
        listCount++;
    }

    public void add(Object data, int index){
        Node temp = new Node(data);
        Node current = head;

        //find index or last element, whichever comes first
        for(int i = 1; i < index && current.getNext() != null; i++){
            current = current.getNext();
        }

        //set new node "next" to this node's "next"
        temp.setNext(current.getNext());

        //set the chain from this to the temp node
        current.setNext(temp);

        //increment size
        listCount++;
    }

    public Object get(int index){
        //index cannot be head node
        if(index <= 0)
            return null;

        Node current = head.getNext();
        for(int i = 1; i < index; i++)
        {
            if(current.getNext() == null)
                return null;

            current = current.getNext();
        }
        return current.getData();
    }

    public boolean remove(int index){
        //if the index is out of range, exit
        if(index < 1 || index > size())
            return false;

        Node current = head;
        for(int i = 1; i < index; i++)
        {
            if(current.getNext() == null)
                return false;

            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--; //decrement the number of elements variable
        return true;
    }

    public int size(){
        return listCount;
    }

    public String toString()
    {
        Node current = head.getNext();
        String output = "";
        while(current != null)
        {
            output += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }
        return output;
    }

    @Override
    public int compareTo(Object o) {

        //compare factors here

        return 0;
    }

    private class Node{
        //reference to the next node, or null
        Node next;

        //data stored
        Object data;

        //default constructor
        public Node(Object _data){
            next = null;
            data = _data;
        }

        // another Node constructor if we want to
        // specify the node to point to.
        public Node(Object data, Node next){
            this.next = next;
            this.data = data;
        }

        public Object getData(){
            return data;
        }

        public void setData(Object data){
            this.data = data;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }
    }//Node
}//LinkedList