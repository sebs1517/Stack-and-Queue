public class GenericStack<T> extends GenericList<T> {
    
    Node<T> tail;
    
    // constructor to initialize stack
    public GenericStack(T value) {
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

    // add method adds value onto stack
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = getHead();
        setHead(newNode);
        setLength(1);
    }

    // push uses add method to add on to the top of stack
    public void push(T data) {
        add(data);
    }

    // pop uses delete method to remove from top of stack
    public T pop() {
        return delete();
    }
}