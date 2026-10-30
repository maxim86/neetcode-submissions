class BrowserHistory {

    int size;
    class Node {
        String url;
        Node next;
        Node prev;
        Node() {
        }
        Node (String url) {
            this.url = url;
        }
    }

    Node head;
    Node tail;
    Node current;

    public BrowserHistory(String homepage) {
        tail = new Node();
        head = new Node();
        current = new Node(homepage);
        
        head.next = current;
        tail.prev = current;

        current.next = tail;
        current.prev = head;
    }
    
    public void visit(String url) {
        var visited = new Node(url);
        visited.next = tail;
        tail.prev = visited;

        visited.prev = current;
        current.next = visited;
        
        current = visited;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            current = current.prev;
            if (current == head) {
                current = current.next;
                break;
            }
        }

        return current.url;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            current = current.next;
            if (current == tail) {
                current = current.prev;
                break;
            }
        }

        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */