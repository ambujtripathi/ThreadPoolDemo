/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadpool;

import java.util.Scanner;

/**
 *
 * @author ambtripa
 */
public class ThreadPoolDriver {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        threadPool.initiateThreads(4, 10);
          
        /*
        for(int i = 0; i < 10; i++){
            try {
                Worker w = new Worker("Thread_" + i, i);
                threadPool.execute(w);
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Could not launch the job");
            }
        }
        
        //threadPool.stop();
        
        */
        Scanner sc = new Scanner(System.in);
        int input = 10;
        do{
            System.out.println("Enter a positive number to continue, -ve to exit: ");
            input = sc.nextInt();
            if(input > 0){
                System.out.println("Pushing a job to the thread pool : " + input);
                try{
                    Worker w = new Worker("NewTask_" + input, input);
                    threadPool.execute(w);
                }catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println("Exception occurred");
                }
            }else{
                threadPool.stop();
                break;
            }
        }while(input > 0);
        
        //threadPool.stop();
    }
}