package OOD_Advanced.session03_OODquestions.blocking_queue;


//Project: techbow
//Package: OOD_Advanced.session03_OODquestions.blocking_queue
//ClassName: BlockingQueue
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2021-02-19 星期五 0:42
class BlockingQueue<T> extends Queue<T> {
   private int count = 0;
   private final int capacity;
  
   public BlockingQueue(int capacity) {
       this.capacity = capacity;
   }
  
   public synchronized boolean offer(T t) {
       while (count == capacity) {
           try {
               wait();
           } catch (InterruptedException e) {

           }
       }
       super.offer(t);
       count++;
       notifyAll();
       return false;
   }
    
    @Override
    public T peek() {
        return null;
    }
    
    @Override
    public synchronized T poll() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            
            }
        }
        T result = super.poll();
        count--;
        notifyAll();
        return result;
    }
    
}