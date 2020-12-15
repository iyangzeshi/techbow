package OOD_Advanced.session03_OODquestions.blocking_queue;

abstract class Queue<T> {
    
    public boolean offer(T t) {
        return false;
    }
    public T peek() {
        return null;
    }
    public T poll() {
        return null;
    }
}