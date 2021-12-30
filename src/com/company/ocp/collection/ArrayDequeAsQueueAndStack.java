package com.company.ocp.collection;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by bikra on 12/15/2019 5:42 PM.
 */
public class ArrayDequeAsQueueAndStack {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println("Offer 10 to last:" + queue.offer(10));
        System.out.println("Add 4 to last:" + queue.add(4));
        System.out.println("Peek the top: " + queue.peek());
        System.out.println("Check the top: " + queue.element());
        System.out.println("Poll from top: " + queue.poll());
        System.out.println("Remove from top: " + queue.remove());
        System.out.println("Peek the top when empty: " + queue.peek());
        System.out.println("poll the top when empty: " + queue.poll());
        try {
            System.out.println("Remove the top when empty: " + queue.remove());
        } catch (Exception e) {
            System.out.println("Exception while removing the top when empty.");
            e.printStackTrace();
        }
        System.out.println(queue);

        // push and pop not allowed in queue.
        /*System.out.println("Add 6 to last:" + queue.push(6));
        System.out.println("Pop the top when empty: " + queue.pop());*/

        // queue with capacity to know exception while trying to add items more than capacity.
        System.out.println();
        Queue<Integer> queueFixedSized = new LinkedBlockingQueue<>(2);
        System.out.println("Offer 10 to last:" + queueFixedSized.offer(10));
        System.out.println("Add 4 to last:" + queueFixedSized.add(4));
        System.out.println("Offer when it is full: " + queueFixedSized.offer(6));
        try {
            System.out.println("Add when it is full: " + queueFixedSized.add(7));
        } catch (Exception e) {
            System.out.println("Exception while adding item when it is full.");
            e.printStackTrace();
        }
        System.out.println(queueFixedSized);

        // Stack
        System.out.println();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        System.out.println("Push 10 to top: ");
        stack.push(10);
        System.out.println("Add 5 to bottom: " + stack.add(5));
        System.out.println("Push 4 to top: ");
        stack.push(4); // queue method
        System.out.println("Peek at the top: " + stack.peek());
        System.out.println("Element at the top: " + stack.element());
        System.out.println("Poll from the top: " + stack.poll());
        System.out.println("Remove from the top: " + stack.remove());
        System.out.println("Pop from the top: " + stack.pop());
        System.out.println("Peek when empty. " + stack.peek());
        System.out.println(stack);
    }
}
