package model;

public class LinkedList<T> {
    private NodeGeneric<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void appendToTail(T value) {
        NodeGeneric<T> newNode = new NodeGeneric<>(value);
        if (head == null) {
            head = newNode;
        } else {
            NodeGeneric<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public T findByValue(T value) {
        NodeGeneric<T> current = head;
        while (current != null) {
            if (current.getData().equals(value)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteByValue(T value) {
        if (head == null) return;

        if (head.getData().equals(value)) {
            head = head.getNext();
            size--;
            return;
        }

        NodeGeneric<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(value)) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public void print() {
        NodeGeneric<T> current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    // Getters y Setters
    public NodeGeneric<T> getHead() {
        return head;
    }

    public void setHead(NodeGeneric<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }
}