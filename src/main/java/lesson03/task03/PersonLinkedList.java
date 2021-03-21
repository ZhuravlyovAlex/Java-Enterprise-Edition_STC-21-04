package lesson03.task03;

import lesson03.task03.model.Person;

public class PersonLinkedList implements PersonList {
    private Node first;
    private Node last;
    private int size = 0;

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Person get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(Person person) {
        if (size == 0){
            first = new Node(null, person, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, person, null);
            secondLast.next = last;
        }
        size++;
    }
    @Override
    public void add(Person person, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(person);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, person, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        }else {
            first = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(Person person) {
        Node node = first;
        for(int i = 0; i < size; i++) {
           if(node.value.equals(person)){
               return removeAt(i);
           }
           node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if(nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if(nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public void sort() throws DublicatePersonException {
    }

    Node getNode(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    static class Node {
        private Node previous;
        private Person value;
        private Node next;

        public Node getPrevious() {
            return previous;
        }

        public Person getValue() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(Node previous, Person value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }

}