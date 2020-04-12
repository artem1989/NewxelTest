package com.coding.test.linkedlisttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Node first = new Node(3, null);
        Node second = new Node(11, first);
        Node third = new Node(15, second);
        Node fourth = new Node(6, third);
        Node fifth = new Node(13, fourth);
        Node sixth = new Node(14, fifth);
        Node seventh = new Node(21, sixth);
        Node eights = new Node(4, seventh);
        Node ninth = new Node(12, eights);
        Node tenth = new Node(7, ninth);
        Node head = new Node(9, tenth);

        Node[] result = separateLinkedList(head);
        Node oddHead = result[0];
        Node evenHead = result[1];

        StringBuilder sb = new StringBuilder();
        while(oddHead != null) {
            sb.append(oddHead.getData());
            sb.append("  ");
            oddHead = oddHead.getNext();
        }

        ((TextView)findViewById(R.id.resultTvOdd)).setText(sb.toString());
        sb.delete(0, sb.length());


        while(evenHead != null) {
            sb.append(evenHead.getData());
            sb.append("  ");
            evenHead = evenHead.getNext();
        }

        ((TextView)findViewById(R.id.resultTvEven)).setText(sb.toString());

    }

    private Node[] separateLinkedList(Node head) {
        Node evenHead = null;
        Node newEvenHead = null;

        Node oddHead = null;
        Node newOddHead = null;

        while(head != null) {
            if(head.getData() % 2 == 0) {
                if(evenHead == null) {
                    evenHead = new Node(head.getData());
                    newEvenHead = evenHead;
                }  else {
                    Node next = newEvenHead;
                    newEvenHead = new Node(head.getData(), next);
                }
            } else {
                if(oddHead == null) {
                    oddHead = new Node(head.getData());
                    newOddHead = oddHead;
                } else {
                    Node next = newOddHead;
                    newOddHead = new Node(head.getData(), next);
                }
            }
            head = head.getNext();
        }
        Node[] result = new Node[2];
        result[0] = newOddHead;
        result[1] = newEvenHead;

        return result;
    }

}
