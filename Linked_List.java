class Linked_List {
    Node head;

    class Node {
        int data;
        Node next = null;

        Node(int data) {
            this.data = data;
            next = null;
        }

    }

    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);

        if (head == null) {
            head = new Node(newData);
            return;
        }
        newNode.next = null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return;
    }

    public void insertAtStart(int d) {
        Node again = new Node(d);
        again.next = head;
        head = again;
    }

    // Insertion after any point of Node
    public void insertAny(Node prevNode, int newData) {
        if (prevNode == null) {
            System.out.println("There is no node after previous Node");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void delNode(Node prevNode) {
        prevNode.next = prevNode.next.next;
    }

    public void reverseIt() {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return;
    }

    public void reverseRec(Node curr, Node prev) {
        if (curr.next == null) {
            head = curr;
            curr.next = prev;
        } else {
            Node nextPtr = curr.next;
            curr.next = prev;
            reverseRec(nextPtr, curr);
        }
    }

    public void middleOfLL() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        System.out.println("Middle of LinkedList is : " + slow.data);

    }
    // Floyd Cycle Detection
    public void detectLoop() {
        Node slow = head;
        Node fast = head;
        int flag = 0;
        while (slow != null && slow.next != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Loop is not detected");
        } else {
            System.out.println("Loop is detected");
        }
    }

    public void searchValue(int X){
        Node temp = head;
        int flag = 0;
        while(temp != null){
            if(temp.data == X){
                flag = 1 ;
                break;
            }
            temp = temp.next;
        }
        if(flag==0){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }

    public void displayNode() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {

        Linked_List llist = new Linked_List();

        llist.insertAtEnd(14);
        llist.insertAtEnd(21);
        llist.insertAtEnd(11);
        llist.insertAtEnd(30);
        llist.insertAtEnd(10);
        llist.insertAtEnd(76);
        
       

        llist.displayNode();

        System.out.println();
        // System.out.println("After Reversing ");
        // llist.reverseIt();

        // llist.reverseRec(llist.head, null);
        // llist.displayNode();
        // llist.middleOfLL();
        llist.insertAny(llist.head.next.next, 45);
         llist.displayNode();
        // Node temp=llist.head;
        // while(temp.next != null){
        //     temp = temp.next;
        // }
        // temp.next = llist.head;
        // llist.detectLoop();

        // llist.searchValue(20);
    }
}