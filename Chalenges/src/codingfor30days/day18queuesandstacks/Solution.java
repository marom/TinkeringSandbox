package codingfor30days.day18queuesandstacks;


import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    Stack<Character> myStack = new Stack<>();
    LinkedList<Character> myQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution p = new Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }

    private char dequeueCharacter() {
        return myQueue.remove();
    }

    private char popCharacter() {
        return myStack.pop();
    }

    private void enqueueCharacter(char c) {
        myQueue.addLast(c);
    }

    private void pushCharacter(char c) {
        myStack.push(c);
    }
}
