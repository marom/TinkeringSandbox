package codingfor30days.day15linkedlist;

import java.util.Scanner;

public class Main {

    public static  Node insert(Node head,int data) {

        Node current = head;

        if (head == null) {
            head = new Node(data);
            return head;
        } else {

            while (head.next != null) {
                head = head.next;
            }
            head.next = new Node(data);
            return current;
        }
    }

    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
}
