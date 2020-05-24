package ru.kpfu.itis.group905.makarov.ruby;

public class Node<T> {
    private Node<T> prev;
    private Node<T> next;
    private T value;
    private String quantity;

    public Node(Node<T> prev, Node<T> next, T value) {
        this.value = value;
        this.prev = prev;
        this.next = next;
        this.quantity = "1";
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity.toString();
    }

    public String getQuantity() {
        return this.quantity;
    }
}
