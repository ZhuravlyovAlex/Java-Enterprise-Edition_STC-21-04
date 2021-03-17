package lesson03.task03;

import lesson03.task03.model.Person;

import java.util.Comparator;

public class PersonGeneratorWithBubbleSort extends PersonLinkedList {

    @Override
    public void sort() throws DublicatePersonException {
        Comparator<Person> personComparator = new Person.PersonSexComparator().thenComparing(new Person.PersonAgeComparator()).thenComparing(new Person.PersonNameComparator());
//
//        Node node;
//        Node nodePrevious;
//        Node prev_rest;
//        Node next_rest;
//        for (int i = size(); i > 1; i--) {
//            node = getNode(i - 1);
//            setLast(node);
//            nodePrevious = node.getPrevious();
//            for (int j = i - 1; j > 0; j--) {
//                if (personComparator.compare(node.getValue(), nodePrevious.getValue()) < 0) {
//                    if (node == getLast()) {
//                        prev_rest = node.getPrevious();
//                        next_rest = node.getNext();
//
//                        node.setPrevious(nodePrevious.getPrevious());
//                        node.setNext(nodePrevious.getNext());
//                        nodePrevious.setPrevious(prev_rest);
//                        nodePrevious.setNext(next_rest);
//                    }
//                    if (nodePrevious == getFirst()) {
//                        prev_rest = node.getPrevious();
//                        next_rest = node.getNext();
//                        nodePrevious.setPrevious(next_rest);
//                        nodePrevious.setNext(node.getNext());
//                        setFirst(node);
//                        prev_rest = null;
//                    } else {
//                        node = node.getPrevious();
//                        nodePrevious = node.getPrevious();
//                    }
//                }
//            }
//        }
    }
}
