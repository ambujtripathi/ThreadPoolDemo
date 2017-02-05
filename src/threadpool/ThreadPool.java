/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadpool;

/**
 *
 * @author ambtripa
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ambtripa
 */
public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<ThreadPoolImpl> threads = new ArrayList();
    private boolean isStopped = false;

    public ThreadPool(){}
    
    public void initiateThreads(int noOfThreads, int maxNoOfTasks){
        taskQueue = new BlockingQueue(maxNoOfTasks);
        System.out.println("Creating threads for thread pool");
        for(int i=0; i<noOfThreads; i++){
            threads.add(new ThreadPoolImpl(taskQueue));
        }
        System.out.println("Starting the threads for thread pool");
        for(ThreadPoolImpl thread : threads){
            thread.start();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");
        System.out.println("Executing the task at hand");
        this.taskQueue.enqueue(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(ThreadPoolImpl thread : threads){
           thread.doStop();
        }
    }

}
