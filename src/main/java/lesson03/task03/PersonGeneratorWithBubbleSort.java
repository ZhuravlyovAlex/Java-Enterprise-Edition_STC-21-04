package lesson03.task03;

import lesson03.task03.model.Person;
import org.w3c.dom.Node;

import java.util.Comparator;

public class PersonGeneratorWithBubbleSort extends PersonLinkedList {


    @Override
    public void sort() throws DublicatePersonException {
        Node node;
        Node nodePrevious;
        for(int i = size(); i > 1; i--) {
            node = getLast();
            nodePrevious = node.getPrevious();
            for(int j = i - 1; j > 0; j-- ){
                if(node.getValue().compareTo(nodePrevious.getValue()) < 0 ) {
                    if(node  == getLast()){
                        setLast(nodePrevious);
                    }
                    if(nodePrevious == getFirst()){
                        setFirst(node);
                        setLast(getFirst());
                    } else {
                        Node secondLast = getLast();
                        setLast(new Node(secondLast, node.getValue(),null));
                        secondLast.setNext(getLast());
                    }
                }
            }
        }
    }


}
