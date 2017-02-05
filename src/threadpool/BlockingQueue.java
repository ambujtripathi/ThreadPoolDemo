/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadpool;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ambtripa
 */
public class BlockingQueue {

    private List queue = new LinkedList();
    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item)
            throws InterruptedException {
        while (this.queue.size() == this.limit) {
            System.out.println("Waiting to get the chance to enter the queue");
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        System.out.println("Adding a new runnable item to the queue");
        this.queue.add(item);
    }

    public synchronized Object dequeue()
            throws InterruptedException {
        while (this.queue.size() == 0) {
            System.out.println("Waiting for a task to be pushed into Blocking Queue");
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        System.out.println("Taking out a new item to execute it");
        return this.queue.remove(0);
    }
}
