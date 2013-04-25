package ajpportal;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author l1065759
 * @param <E> Element type.
 */
public class LinkedBlockingQueue<E> extends AbstractQueue<E> 
implements BlockingQueue<E>, Serializable {
    /**
     * initializes LinkedList l, used to store the queue.
     */
    LinkedList<E> l = new LinkedList();
    /**
     * sleep is a defined value for use in Thread.sleep.
     */
    private final int sleep  = 1000;
    
    
    /**
     * LinkedBlockingQueue constructor.
     */
    public LinkedBlockingQueue() {
        
    }
    

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     * @return iterator i.
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> i;
        i = l.listIterator();
        return i;
    }
    
    /**
     * Returns the number of elements in this queue.
     * @return  size of array.
     */
    @Override
    public int size() {
        return l.size();
    }

    /**
     * Inserts the specified element at the tail of this queue if it is possible
     * to do so immediately without exceeding the queue's capacity, returning 
     * true upon success and false if this queue is full.
     * @param e Element to be returned.
     * @return boolean value.
     */
    @Override
    public boolean offer(E e) {
        if (l.size() < Integer.MAX_VALUE) {
            l.addLast(e);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this 
     * queue is empty.
     * @return e
     */
    @Override
    public E poll() {
        E e;
        if (l.isEmpty()) {
            e = null;
        } else {
            e = l.getFirst();
            l.removeFirst();
        }
       
        return e;
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null 
     * if this queue is empty.
     * @return e
     */
    @Override
    public E peek() {
                E e;
        if (l.isEmpty()) {
            e = null;
        } else {
            e = l.getFirst();
        }
        return e;
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting if 
     * necessary for space to become available.
     * @param e element to be returned.
     * @throws InterruptedException 
     */
    @Override
    public void put(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        } 
        while (l.size() == Integer.MAX_VALUE) {
            Thread.sleep(sleep);
        }
        l.addLast(e);
        
    }
    
    
    /**
     * Inserts the specified element at the tail of this queue, waiting if 
     * necessary for space to become available.
     * @param e element to be returned.
     * @throws InterruptedException 
     */
//    @Override
    public void put(E ... e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        } 
        while (l.size() == Integer.MAX_VALUE) {
            Thread.sleep(sleep);
        }
        
        for(int i = 0; i<e.length; i++ )
        {
            l.addLast(e[i]);
        }
    }

    /**
     *  Inserts the specified element at the tail of this queue, waiting if 
     * necessary up to the specified wait time for space to become available.
     * @param e Element to be returned
     * @param timeout value to wait for.
     * @param unit unused unit.
     * @return e
     * @throws InterruptedException 
     */
    @Override
    public boolean offer(E e, long timeout, TimeUnit unit)
            throws InterruptedException {
        
       if (l.size() == Integer.MAX_VALUE) {
           Thread.sleep(timeout);
       }
       if (l.size() == Integer.MAX_VALUE) {
           return false;
       } else {
           l.addLast(e);
           return true;
       }
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary until 
     * an element becomes available.
     * @return e
     * @throws InterruptedException 
     */
    @Override
    public E take() throws InterruptedException {
        E e;
        while (l.isEmpty()) {
            Thread.sleep(sleep);
        }
//        e = l.getFirst();
//        l.removeFirst();
//        l.pop();
       e= l.pop();
        return e;
    }

    /**
     *  Retrieves and removes the head of this queue, waiting up to the 
     * specified wait time if necessary for an element to become available.
     * @param timeout value to wait.
     * @param unit unused value.
     * @return e Element to be returned.
     * @throws InterruptedException 
     */
    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
       E e;
        if (l.isEmpty()) {
            Thread.sleep(timeout);
        }
        if (l.isEmpty()) {
            e = null;
            return e;
        }
        e = l.getFirst();
        l.removeFirst();
       
        return e;
    }
    

    /**
     * Returns the number of additional elements that this queue can ideally 
     * (in the absence of memory or resource constraints) accept without 
     * blocking.
     * @return e
     */
    @Override
    public int remainingCapacity() {
        final int rC = Integer.MAX_VALUE - size();
        return rC;
    }

    /**
     * Removes all available elements from this queue and adds them to the given
     * collection.
     * @param c collection
     * @return count
     */
    @Override
    public int drainTo(Collection<? super E> c) {
        int count = 0;
        if (c.isEmpty()) {
            return count;
        } else {
            final Iterator i = c.iterator();
            while (i.hasNext()) {
               final E e = (E) i.next();
                l.addLast(e);
                i.remove();
                count++;
            }
            return count;
        }
        
    }

    /**
     * Removes at most the given number of available elements from this queue
     * and adds them to the given collection.
     * @param c collection
     * @param maxElements sets how many elements to remove.
     * @return  count
     */
    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        int count = 0;
        if (c.isEmpty()) {
            return count;
        } else {
            final Iterator i = c.iterator();
            while (i.hasNext() && count < maxElements) {
               final E e = (E) i.next();
                l.addLast(e);
                i.remove();
                count++;
            }
            return count;
        }
    }

}
