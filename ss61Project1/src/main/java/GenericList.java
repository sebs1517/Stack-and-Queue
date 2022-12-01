import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

abstract class GenericList<T> implements Iterable<T>{

    private Node<T> head;
    private int length;

    // generic singly linked list inner node class
    class Node<T> {
        T data;
        Node<T> next;
        // constructor definition to set data equla to val
        public Node(T val) {
            data = val;
        }
    }

    // print method used to print items on list, one item per line
    public void print() {
        if (head == null) {
            System.out.println("Empty List");
        } else {
            Node<T> temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    // add method adds value to list
    public abstract void add(T data);

    // delete method returns first value on list and deletes it
    public T delete() {
        if (head == null) {
            return null;
        } else {
            T firstNode = head.data;
            head = head.next;
            length--;
            return firstNode;
        }
    } 

    // dumpList method stores and returns all values in list into ArrayList and returns it
    // list should be empty at the end
    public ArrayList<T> dumpList() {
        ArrayList<T> arrList = new ArrayList<T>();
        while (head != null) {
            arrList.add(head.data);
            head = head.next;
        }
        length = 0;
        return arrList;
    }

    // get method returns the value at specified index
    public T get( int index) {
        Node<T> temp = head;
        int i = 0;
        while(temp != null) {
            if (i == index) {
                return temp.data;
            }
            temp = temp.next;
            i++;
        }
        return null;
    }

    // set method replaces element at specified position on list and returns old value
    public T set(int index, T element) {
        Node<T> temp = head;
        int i = 0;
        while (temp != null) {
            if (i == index) {
                T prevElement = temp.data;
                temp.data = element;
                return prevElement;
            }
            temp = temp.next;
            i++;
        }
        return null;
    }

    // getLength, setLength, getHead, setHead are all getters/setters for private data members
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;

    }

    public Iterator <T> iterator(){
        return new GLLIterator<T>(this);
    }

    // listIterator method returns list-iterator of the elements of this list at specified position
    public ListIterator<T> listIterator( int index) {
        return new GLListIterator<T>(this, index);
    }  

    // descendingIterator returns iterator over elements of list in reverse order(tail to head)
    public Iterator<T> descendingIterator() {
        return new ReverseGLLIterator<T>(this);
    }
}