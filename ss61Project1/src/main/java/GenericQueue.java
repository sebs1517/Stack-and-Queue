public class GenericQueue<T> extends GenericList<T>{

    Node<T> tail;

    // constructor to initialize queue
    public GenericQueue(T value) {
        Node<T> newNode = new Node<T>(value);
        newNode.data = value;
        newNode.next = null;
        setHead(newNode);
        tail = getHead();
        setLength(1);
    }

    // removeTail removes tail of the list
    public T removeTail() {
        T tailVal = tail.data;
        Node<T> prev = getHead();
        Node<T> temp = getHead();

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        tailVal = tail.data;
        tail = prev;
        return tailVal;
    }

    // add method adds value onto queue
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        tail.next = newNode;
        tail = newNode;
        tail.next = null;
        setLength(1);
    }

    // enqueue uses add method to add value to back of queue
    public void enqueue(T data) {
        add(data);
    }

    // dequeue uses delete method to delete from from front queue
    public T dequeue() {
        return delete();
    }
}