class MyLinkedList {

    class Node {
        Node next;
        int val;
        Node prev;

        Node() {}

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        Node succ = pred.next;
        Node toAdd = new Node(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        Node toDelete = pred.next;
        Node succ = toDelete.next;
        pred.next = succ;
        succ.prev = pred;
        size--;
    }
}
