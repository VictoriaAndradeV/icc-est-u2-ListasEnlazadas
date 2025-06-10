package model;

public class NodeGeneric <T>{
    private T data; // Dato almacenado en el nodo
    private NodeGeneric<T> next; // Referencia al siguiente nodo

    public NodeGeneric(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public NodeGeneric<T> getNext() {
        return next;
    }

    public void setNext(NodeGeneric<T> next) {
        this.next = next;
    }
}
