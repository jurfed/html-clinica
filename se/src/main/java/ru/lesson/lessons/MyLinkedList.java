package ru.lesson.lessons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by jur on 07.01.2019.
 */
public class MyLinkedList implements Iterable {
    private int size = 0;
    private Node head;
    private Node tail;

    public void addNode(Client client) {
        Node tNode = new Node(client);
        size++;
        if (head == null) {
            head = tNode;
            tail = tNode;
        } else {
            tail.next = tNode;
            tNode.prev = tail;
            tail = tNode;
        }

    }

    public Client getNodeByClientName(String clientName) {
        Node currect = head;
        Client returnNode = null;

        while (currect != null) {
            if (currect.getNode().getClientName().equals(clientName)) {
                returnNode = currect.getNode();
            }
            currect = currect.next;
        }
        return returnNode;
    }

    public List getNodeList(){
        Node currect = head;
        Client returnNode = null;
        List nodeList = new ArrayList();

        while (currect != null) {
                nodeList.add(currect.getNode());
            currect = currect.next;
        }
        return nodeList;
    }

    public Client getNodeByPetName(String petName) {
        Node currect = head;
        Client returnNode = null;

        while (currect != null) {
            if (currect.getNode().getPet().getName().equals(petName)) {
                returnNode = currect.getNode();
            }
            currect = currect.next;
        }
        return returnNode;
    }


    public Client getNode(Client client) {
        Node currect = head;
        Client returnNode = null;

        while (currect != null) {
            if (currect.getNode().equals(client)) {
                returnNode = currect.getNode();
            }
            currect = currect.next;
        }
        return returnNode;
    }

    public void removeNode(MyLinkedList myClients, Client t) {
        Node currect = head;
        while (currect != null) {
            if (currect.getNode().equals(t)) {
                if (currect.prev != null) {
                    currect.prev.next = currect.next;
                } else {
                    head = currect.next;
                }
                if (currect.next != null) {
                    currect.next.prev = currect.prev;
                } else {
                    tail = currect.prev;
                }
                size--;
            }
            currect = currect.next;
        }
    }

    public String removeRandomNode() {
        Node currect = head;
        String deleted = "";

        if (size > 0) {
            deleted = head.getClientName();
            if (currect.prev != null) {
                currect.prev.next = currect.next;
            } else {
                head = currect.next;
            }
            if (currect.next != null) {
                currect.next.prev = currect.prev;
            } else {
                tail = currect.prev;
            }
            size--;
        }


        return deleted;
    }


    public int getSize() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    private class Node {
        Node next;
        Node prev;
        Client node;

        public Node(Client t) {
            this.node = t;
        }

        public Client getNode() {
            return node;
        }

        public String getClientName() {
            return this.node.getClientName();
        }

        public String getPetName() {
            return this.node.getPet().getName();
        }
    }

    public String toString() {
        Node currect = head;
        String clientsInfo = "";

        while (currect != null) {
            clientsInfo += currect.getNode().toString();
            currect = currect.next;
        }

        return clientsInfo;
    }

}
