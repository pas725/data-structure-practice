package misc.LRUCache;

/**
 * Created by psagar on 2/9/2017.
 */
public class Node<E> {
    public E value;
    public Node<E> next;
    public Node<E> prev;

    public Node(){
        next = prev = null;
    }
}
