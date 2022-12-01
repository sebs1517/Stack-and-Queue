import java.util.Iterator;

public class GLIterator<I> implements Iterator<I> {
    
    GenericList<I>.Node<I> linkList;

    public GLIterator(GenericList<I>.Node<I> head) {
        linkList = head;
    }

    // cehcks if there is a value on list
    public boolean hasNext() {
        if(linkList == null) {
            return false;
        }
        return true;
    }

    // returns value and goes to next value
    public I next() {
        I data = linkList.data;
        linkList = linkList.next;
        return data;
    }
}