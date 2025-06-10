package model;

public class LinkedList <T> {
    public NodeGeneric<T> head; // Referencia al primer nodo de la lista
    private int size = 0; // Contador del número de nodos en la lista

    public void appendToTail(T data) {
        if (head == null) {
            head = new NodeGeneric<>(data);
            size++;
            return;
        }

        NodeGeneric<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new NodeGeneric<>(data));
        size++;
    }

    public T findByValue(T data){
        NodeGeneric<T> current = head;
        while(current != null){
            if(current.getData().equals(data)){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
   
    public void deleteNode(T data) {
        if (head == null)
            return;

        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return;
        }

        NodeGeneric<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("END");
            return;
        }
        NodeGeneric<T> current = head;
        while (current.getNext() != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println(current.getData() + " -> END");
    }

    public NodeGeneric<T> getHead() {
        return head;
    }

    public void setHead(NodeGeneric<T> head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
