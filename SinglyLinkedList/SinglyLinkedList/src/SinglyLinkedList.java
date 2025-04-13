public class SinglyLinkedList {
    Node head;
    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public static void main(String[] args) throws Exception {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(null);
        singlyLinkedList.addFirst(10);
        singlyLinkedList.addFirst(20);
        singlyLinkedList.addFirst(30);
        singlyLinkedList.addLast(40);
        singlyLinkedList.addAtIndex(25, 2);
        singlyLinkedList.addAtIndex(50, 0);
        singlyLinkedList.traverse();
    }

    public void traverse() {
        Node current = head;
        while(current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.println("null");
    }


    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void addAtIndex(int value, int index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException("The position start at 0");
        }
        if(index == 0) {
            addFirst(value);
        }

        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }
        if(current == null) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }






}
