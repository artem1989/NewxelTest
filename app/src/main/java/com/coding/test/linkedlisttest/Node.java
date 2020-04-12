package com.coding.test.linkedlisttest;

class Node {
    private int data;
    private Node next;

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    int getData() {
        return data;
    }

    void setData(int data) {
        this.data = data;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}
