package misc.LRUCache;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by psagar on 2/9/2017.
 */
public class LRUCache {

    private Map<Integer, Node<Integer>> map;
    private LinkedList<Integer> linkedList;
    private int cacheSize;

    public LRUCache( int size ){
        if (size <= 1){
            throw new IllegalArgumentException("Cache size must be grater than 2");
        }
        cacheSize = size;
        map = new HashMap<>(cacheSize);
        linkedList = new LinkedList<>();
    }

    public int accessPage( int pageNo ){

        int result = -1;
        if ( map.containsKey(pageNo)){
            // remove node and add it to first     [CACHE HIT]
            Node<Integer> node = map.get(pageNo);
            node = linkedList.remove(node);
            linkedList.add(node);
            result = pageNo;
        } else {
            // create a new node and add it to first [CACHE MISS]
            Node<Integer> node = null;
            if ( map.size() >= cacheSize ){
                Node<Integer> removedNode = linkedList.removeLast();
                map.remove(removedNode.value);
                node = linkedList.add(pageNo);
            } else {
                node = linkedList.add(pageNo);
            }
            map.put(pageNo,node);
        }

        return result;
    }

    public String print(){
        return linkedList.print();
    }
}


