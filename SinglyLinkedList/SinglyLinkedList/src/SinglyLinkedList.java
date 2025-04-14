import java.util.HashSet;

public class SinglyLinkedList {
    Node head;
    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public static void main(String[] args) throws Exception {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(null);
        // singlyLinkedList.addFirst(10);
        // singlyLinkedList.addFirst(20);
        // singlyLinkedList.addFirst(30);
        // singlyLinkedList.addLast(40);
        // singlyLinkedList.addAtIndex(25, 2);
        // singlyLinkedList.addAtIndex(50, 0);
        // singlyLinkedList.removeHead();
        // singlyLinkedList.removeTail();
        // singlyLinkedList.removeAtIndex(2);
        singlyLinkedList.insertSorted(20);
        singlyLinkedList.insertSorted(10);
        singlyLinkedList.insertSorted(10);
        singlyLinkedList.insertSorted(50);
        singlyLinkedList.insertSorted(50);
        singlyLinkedList.insertSorted(50);
        singlyLinkedList.traverse();
        singlyLinkedList.removeDuplicate();
        singlyLinkedList.traverse();
        System.out.println(singlyLinkedList.toString());
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

    public void removeHead() {
        if(head != null) {
            Node temp = head;
            head = head.next;
            temp = null;
        }
    }

    public void removeTail() {
        if(head == null) {return;}
        if(head.next == null) {
            removeHead();
            return;
        } 
        Node current = head;
        while(current.next != null && current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void removeAtIndex(int index) {
        if(index == 0 || head == null) {
            return;
        }
        if(index == 0) {
            removeHead();
            return;
        }
        Node current = head;
        for(int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if(current != null && current.next != null) {
            Node temp = current.next;
            current.next = current.next.next;
            temp = null;
        }
    }

    public int size() {
        int count = 0;
        Node current = head;
        while(current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while(current != null) {
            sb.append(current.value);
            if(current.next != null) {
                sb.append(" - ");    
            }
            current = current.next;
        }
        return sb.toString();
    }
    public void insertSorted(int value) {
        if(head == null || value < head.value) {
            addFirst(value);
            return;
        }
        Node newNode = new Node(value);
        Node current = head;
        while(current.next != null && current.next.value < value) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    
    public Node search(int value) {
        if(head == null) {
            return null;
        }
        Node current = head;
        while(current != null) {
            if(current.value == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Boolean contains(int value) {
        if(head != null) {
            Node current = head;
            while(current != null) {
                if(current.value == value) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public void removeDuplicate() {
        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        int countNode = 0;
        while(current != null) {
            if(set.contains(current.value)) {
                removeAtIndex(countNode);
            }
            else {
                set.add(current.value);
                countNode++;
            }
            current = current.next;
        }
    }





}
