package misc.LRUCache;

/**
 * Created by psagar on 2/9/2017.
 * Creates Linked list of Nodes
 *      - Each Add operation will add new Node at start of LL
 *      - Remove operation can be done on any Node.
 */
public class LinkedList<E> {

    private Node<E> head;
    private Node<E> last;
    private int size;

    public LinkedList (){
        size = 0;
        head = null;
        last = null;
    }

    private Node<E> addFirst( Node<E> node ){
        if( head == null ){
            head = last = node;
        } else {
            Node<E> oldHead = head;
            node.next = oldHead;
            oldHead.prev = node;
            head = node;
        }
        size++;
        return node;
    }

    public Node<E> add(E item){
        Node<E> node = new Node<>();
        node.value = item;
        return addFirst(node);
    }

    public Node<E> add(Node<E> node){
        return addFirst(node);
    }


    public Node<E> removeLast(){

        Node<E> node = null;
        if ( last == null ){
            return node;
        } else if( head == last ){
            node = last ;
            head = last = null;
        } else {
            node = last;
            last = node.prev;
            last.next = null;
        }
        node.prev = null;
        node.next = null;
        return node;
    }

    public Node<E> remove (Node<E> node){

        Node<E> next = null;
        Node<E> prev = null;

        if  ( head == node && last == node){
            head = last = null;
        } else if ( last == node ){
            prev = node.prev;
            prev.next = null;
            last = prev;

        } else if ( head == node ) {
            next = node.next;
            next.prev = null;
            head = next;
        } else {
            prev = node.prev;
            next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        node.next = null;
        node.prev = null;
        size--;
        return node;
    }

    public String print(){
        Node<E> node = head;
        StringBuilder sb = new StringBuilder("");
        while ( node != null ){
            sb.append(" "+ node.value);
            node = node.next;
        }
        return sb.toString().trim();
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

}
