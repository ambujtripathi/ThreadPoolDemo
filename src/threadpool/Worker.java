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
public class Worker implements Runnable{
    private String taskName;
    private int taskCount;
    
    public Worker(){
    }
    
    public Worker(int taskCount){
        this.taskCount = taskCount;
    }
    
    public Worker(String taskName, int taskCount){
        this.taskName = taskName;
        this.taskCount = taskCount;
    }
    
    @Override
    public void run() {
        for(int i = 0; i < taskCount; i++){
            System.out.println("executing task : " + taskName );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Thread is interrupted to do another task");
            }
        }
    }
    
    public String getTaskName(){
        return taskName;
    }
    
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }
}