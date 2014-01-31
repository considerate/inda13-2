
/**
 * A singly linked list.
 * 
 * @author 
 * @version
 */
public class LinkedList<T> { 
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.
    
    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;
        
        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * This TEST METHOD returns true if the following invariants hold:
     * <ul>
     *   <li> size equals the number of list elements, </li>
     *   <li> if size == 0, first == null and last == null, </li>
     *   <li> if size > 0, first != null and last != null, </li>
     *   <li> if size == 1, first == last, </li>
     *   <li> last.next == null. </li>
     * </ul>
     * Time complexity: O(1)
     */
    public boolean isHealthy() {
    	boolean isHealthy = true;

        int count = 0;
        for(ListElement<T> element = this.first; element != null; element = element.next) {
            count += 1;
        }
        isHealthy = isHealthy && (count == size());

        if(isEmpty()) {
            isHealthy = isHealthy && (this.first == null);
            isHealthy = isHealthy && (this.last == null);
            return isHealthy;
        }

        if(size() == 1) {
            isHealthy = isHealthy && (this.first == this.last);    
        } else {
            isHealthy = isHealthy && (this.first != null); 
            isHealthy = isHealthy && (this.last != null);
        }

        isHealthy = isHealthy && (this.last.next == null);
    	return isHealthy;
    }
    
    /**
     * Creates an empty list.
     */
    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;  
    }

    /**
     * Inserts the given element at the beginning of this list.
     * Time complexity: O(1)
     */
    public void addFirst(T element) {
        ListElement<T> firstElement = new ListElement<T>(element);
        if(this.first != null) {
            ListElement<T> previousFirst = this.first;
            firstElement.next = previousFirst;
        } else {
            this.last = firstElement;
        }
        this.first = firstElement;  
        this.size += 1;
    }

    /**
     * Inserts the given element at the end of this list.
     * Time complexity: O(1)
     */
    public void addLast(T element) {
         ListElement<T> lastElement = new ListElement<T>(element);
         ListElement<T> previousLast = this.last;
         if(previousLast != null) {
            previousLast.next = lastElement;
         }
         else {
            //List contains no elements, set first element as well.
            this.first = lastElement;
         }
         this.last = lastElement;
         this.size += 1;
    }

    /**
     * Returns the first element of this list.
     * Returns <code>null</code> if the list is empty.
     * Time complexity: O(1)
     */
    public T getFirst() {
        if(this.first != null) {
            return this.first.data;
        }
        return null;
    }

    /**
     * Returns the last element of this list.
     * Returns <code>null</code> if the list is empty.
     * Time complexity: O(1)
     */
    public T getLast() {
        if(this.last != null) {
            return this.last.data;
        }
        return null;
    }

    /**
     * Returns the element at the specified position in this list.
     * Returns <code>null</code> if <code>index</code> is out of bounds.
     * Time complexity: O(n)
     */
    public T get(int index) {
        if(index > size-1) {
            //throw new IndexOutOfBoundsException();
            return null;
        }
        int currentIndex = 0;
        for(ListElement<T> element = this.first; element != null; element = element.next) {
            if(currentIndex == index) {
                return element.data;
            }          
            currentIndex += 1;
        }
        assert false; //Should never arrive here!
        return null;
    }

    /**
     * Removes and returns the first element from this list.
     * Returns <code>null</code> if the list is empty.
     * Time complexity: O(1)
     */
    public T removeFirst() {
        ListElement<T> firstElement = this.first;
        if(firstElement != null) {
            ListElement<T> nextElement = firstElement.next;
            this.first = nextElement;
            this.size -= 1;
            if(this.size == 0) {
                this.last = null;
            }
            return firstElement.data;
        }
        return null;
    }

    /**
     * Removes all of the elements from this list.
     * Time complexity: O(1)
     */
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Returns the number of elements in this list.
     * Time complexity: O(1)
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns <code>true</code> if this list contains no elements.
     * Time complexity: O(1)
     */
    public boolean isEmpty() {
        if(this.first == null && this.last == null) {
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     * Time complexity: O(n)
     */
    public String toString() {
        String returnString = "[";
        for(ListElement<T> element = this.first; element != null; element = element.next) {
            if(element.data == null) {
                returnString += "null";
            }
            else {
                returnString += element.data.toString();
            }
            //Last element should have no trailing comma
            if(element.next != null) {
                returnString += ", ";
            }
        }
        returnString += "]";
        return returnString;
    }
}
