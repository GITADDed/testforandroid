package ru.kpfu.itis.group905.makarov.ruby;

public class MyLinkedList2<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList2(){
        this.size = 0;
    }

    // Этот метод собирает все одинаковые по значению ноды, и начинает хранить их количество в неповторяющихся нодах.
    public void combineTheSameItem() {
        Node<T> node = this.head;
        Node<T> currNode = this.head.getNext();
        int temp = 1;
        // Этот цикл убирает все одинаковые значения рядом с головой списка и хранит их количество в классе Node
        // у поля quantity
        while (this.head == node && currNode != null) {
            if (node.getValue().equals(currNode.getValue())) {
                this.head = currNode;
                currNode.setPrev(null);
                temp++;
                currNode.setQuantity(temp);
                node = this.head;
                currNode = node.getNext();
            } else {
                node = currNode;
                currNode = node.getNext();
                temp = 1;
            }
        }

        // Этот цикл совмещает все одинаковые значения после того как значение у головы поменяется
        // и тоже хранит их количество в Node.quantity
        while (this.tail != node && currNode != null) {
            if (node.getValue().equals(currNode.getValue())) {
                currNode.setPrev(node.getPrev());
                node.getPrev().setNext(currNode);
                temp++;
                currNode.setQuantity(temp);
                node = currNode;
                currNode = node.getNext();
            } else {
                node.setQuantity(temp);
                node = currNode;
                currNode = node.getNext();
                temp = 1;
            }
        }

        // проверка конечного значения
        if (currNode != null && node.getValue().equals(currNode.getValue())) {
            currNode.setPrev(node.getPrev());
            node.getPrev().setPrev(currNode);
            temp++;
            currNode.setQuantity(temp);
        }
    }

    // метод возвращает номер и количество
    public String getQuantityAndValue() {
        StringBuilder result = new StringBuilder();
        Node<T> node = this.head;

        while (node != null) {
            result.append(node.getQuantity());
            result.append(node.getValue());
            node = node.getNext();
        }

        return result.toString();
    }

    // вставка элемента в конец списка
    public void insert(T k) {
        Node<T> node;

        if (this.size != 0) {
            node = this.tail;
            this.tail = new Node<T>(node, null, k);
            node.setNext(this.tail);
        }
        else this.head = this.tail = new Node<T>(null, null, k);

        this.size++;
    }

    // метод делает количество числом
    // Я знаю про unchecked cast.
    public void InsertQuantityBeforeItem() {
        Node<T> node = this.head;
        Node<T> beforeNode = new Node<T>(null, node, (T) node.getQuantity());
        node.setQuantity(1);
        this.head = beforeNode;
        node.setPrev(beforeNode);
        this.size++;
        node = node.getNext();
        if (node != null)
        while (node != null) {
            this.tail = node;
            beforeNode = new Node<T>(node.getPrev(), node, (T) node.getQuantity());
            node.getPrev().setNext(beforeNode);
            node.setPrev(beforeNode);
            node.setQuantity(1);
            node = node.getNext();
            this.size++;
        }
    }
}
