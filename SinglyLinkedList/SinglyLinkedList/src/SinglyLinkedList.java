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



}
