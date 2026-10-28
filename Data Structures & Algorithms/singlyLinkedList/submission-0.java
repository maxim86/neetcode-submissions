class LinkedList {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    public int get(int index) {
        Node node = navigateTo(index);

        if (node == null) {
            return -1;
        }

        return node.value;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public boolean remove(int index) {
        if (head == null) {
            return false;
        }

        // Removing the head node
        if (index == 0) {
            head = head.next;
            return true;
        }

        Node previous = navigateTo(index - 1);

        // Either index - 1 was invalid, or there is no node at index
        if (previous == null || previous.next == null) {
            return false;
        }

        previous.next = previous.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node current = head;

        while (current != null) {
            values.add(current.value);
            current = current.next;
        }

        return values;
    }

    /**
     * Returns the node at index, or null if the index is out of bounds.
     */
    private Node navigateTo(int index) {
        Node current = head;

        while (current != null && index > 0) {
            current = current.next;
            index--;
        }

        return current;
    }
}