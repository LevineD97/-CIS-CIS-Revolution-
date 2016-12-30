public class LinkedList<T> implements List<T> {
    
    // Pointer head to the beginning of the list
    private Node head = null;
    
    // Pointer tail to the end of the list,
    // referring to the same element as head
    private Node tail = head;
    
    // Int size initialized at 0 for the amount of
    // elements currently in the linked list
    private int size = 0;
    
    public static void main(String[] args) {
    }
    
    private class Node {
        // Stores element of generic type in the node
        T element;
        
        // Reference to the next node in the linked list
        Node next;
    }
    
    /**
     * Adds the object x to the end of the list.
     * @param x the element to be added to this list
     * @return true
     */
    public boolean add(T x) {
        // If statement that evaluates if head is currently null
        if (head == null) {
            
            // Initializes head as a new Node
            head = new Node();
            
            // Inputs the element x as the element in the Node head
            head.element = x;
            
            // Reinitializes tail to be equivalent to head
            tail = head;
            
            // Increments size by 1
            size++;
            
            // Returns true
            return true;
        }
        
        // Initializes a new Node for addition to the list
        Node newNode = new Node();
        
        // Inputs the element x as the element of the new node
        newNode.element = x;
        
        // Creates a current Node reference for use in the loop
        Node current = head;
        
        // A for loop that runs through the current size of the for loop
        for (int i = 0; i < size() + 1; i++) {
            
            // If statement that evaluates the position of the last node
            // in the list
            if (current.next == null) {
                
                // Links the new node to the end of the current node
                current.next = newNode;
                
                // Moves the tail reference 
                tail = newNode;
                
                //Breaks for loop after addition of new Node
                break;
            }
            
            // Iterates current to current.next through list
            current = current.next;
        }
        
        // Increments size by 1
        size++;
        
        // Returns true
        return true;
    }
    
    /**
     * Adds the object x at the specified position
     * @param index the position to add the element
     * @param x the element to be added to the list
     * @return true if the operation succeeded, false otherwise
     */
    public boolean add(int index, T x) {
        
        // If statement that evaluates if the index is
        // valid for adding an item to the linked list
        if (index > size() || index < 0) {
            
            // Throws error if invalid index
            throw new IllegalArgumentException("Invalid node index.");
        }
        
        // Constructs a new Node
        Node newNode = new Node();
        
        // Inputs the element x into the new node
        newNode.element = x;
        
        // If statement that evaluates if the linked list is empty
        if (isEmpty()) {
            
            // Sets the head reference to the new node
            head = newNode;
            
            // Sets the element in head to the element in the new node
            head.element = newNode.element;
            
            // Equates tail and head
            tail = head;
            
            // Increments size by 1
            size++;
            
            // Returns true
            return true;
        }
        
        // If statement that evalutes if the index
        // is equal to the current size of the list
        if (index == size()) {
            
            // Runs the method that adds x to the end of the list
            add(x);
            
            // Returns true afterwards
            return true;
        }
        
        // If statement that evaluates if the index is 0
        if (index == 0) {
            
            // Affixs the new node to the start of the linked list
            newNode.next = head;
            
            // Reassigns head to refer to this new node
            head = newNode;
            
            // Increments size by 1
            size++;
            
            // Returns true
            return true;
        }
        
        // Initializes a node index at 0 to relate
        // array indexing to linked listing
        int nodeIndex = 0;
        
        // A Node for loop that increments via i.next
        for (Node i = head; i != null; i = i.next) {
            
            // If statement that evaluates if the current node index
            // is 1 below the designated addition index
            if (nodeIndex == index - 1) {
                
                // If so, inputs the new node through
                // reassignment of next via the current 
                // linked list positions
                newNode.next = i.next;
                i.next = newNode;
                
                // Increments size by 1
                size++;
                
                // Returns true
                return true;
            }
            
            // Increments node index by 1 if if statement not satisfied
            nodeIndex++;
        }
        
        // Returns false if addition was not successful
        return false;
    }
    
    /**
     * Returns the number of elements in this list
     * @return the number of elements in this list
     */
    public int size() {
        
        // Returns the current value of size, stored in a class variable
        return size;
    }
    
    /**
     * Returns the element with the specified position in this list
     * @param index the position of the element
     * @return the element at the specified position in this list
     */
    public T get(int index) {
        
        // If statement that evaluates the validity of the desired index
        if (index >= size() || index < 0) {
            
            // Throws error if not
            throw new IllegalArgumentException("Invalid node index.");
        }
        
        // A counter for node indexing related to array indexing
        int nodeIndex = 0;
        
        // A node for loop that runs through the linked list
        for (Node x = head; x != null; x = x.next) {

            // If statement that evaluates if the nodeindex 
            // is equal to the desired linked list index
            if (index == nodeIndex) {
                
                // Returns the element at the current node
                return x.element;
            }  
            
            // Increments node index by 1 otherwise
            nodeIndex++;
        }
        
        // Returns null otherwise, mostly unreachable
        return null;
    }
    
    /**
     * Replaces the object at the specified position
     * @param index the position to replace
     * @param x the element to be stored
     * @return the previous value of the element at index
     */
    public T set(int index, T x) {
        
        // If statement that evaluates the validity of the desired index
        if (index >= size() || index < 0) {
            
            // Throws a new error if not
            throw new IllegalArgumentException("Invalid node index.");
        }
        
        // Initializes a element for storage and return as null
        T element = null;
        
        // Initializes a node index for relation to array indexing
        int nodeIndex = 0;
        
        // For loop that runs through the linked list via i.next
        for (Node i = head; i != null; i = i.next) {
            
            // If statement that evaluates if the current nodeindex
            // is equal to the desired index for setting
            if (index == nodeIndex) {
                
                // Sets the storage element to the element in node i
                element = i.element;
                
                // Changes the element in i to the element x
                i.element = x;
                
                // Breaks from the for loop
                break;
            }  
            
            // Increments the node index by 1
            nodeIndex++;
        }
        
        // Returns the element stored from the node
        return element;
    }
    
    /**
     * Removes the object at the specified position
     * @param index the position to remove
     * @return the object that was removed
     */
    public T remove(int index) {
        
        // Initializes a storage element as null
        T element = null;
        
        // If statement that evaluates if the index is 0
        if (index == 0) {
            
            // Sets the storage element to the element in head
            element = head.element;
            
            // Sets the head to head.next, effectively destroying head
            head = head.next;
            
            // Decrements size by 1
            size--;
            
            // Returns the element stored from the node
            return element;
        }
        
        // Initializes a counter at 0 for indexing
        int nodeIndex = 0;
        
        // For loop that runs through the linked list
        for (Node x = head; x != null; x = x.next) {
            
            // If statement that evaluates if the current
            // counter is equal to the desired index - 1
            if (nodeIndex == index - 1) {
                
                // Sets the storage element to the element of the next node
                element = x.next.element;
                
                //Sets the next node to the next next node, deleting the next node
                x.next = x.next.next;
                
                // Breaks from the for loop
                break;
            }
            
            // Increments the node index by 1
            nodeIndex++;
        }
        
        // Decrements size by 1
        size--;
        
        // Returns the element stored
        return element;
    }
    
    /**
     * Tests if this list has no elements.
     * @return  <tt>true</tt> if this list has no elements;
     *          <tt>false</tt> otherwise.
     */
    public boolean isEmpty() {
        
        // Returns whether head is null or not,
        // signifying emptiness
        return head == null;
    }
    
    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param element element whose presence in this List is to be tested.
     * @return  <code>true</code> if the specified element is present;
     *  <code>false</code> otherwise.
     */
    public boolean contains(T element) {
        
        // For loop that runs through the linked list
        for (Node x = head; x != null; x = x.next) {
            
            // If the element at the current node is equal
            // to the element being checked for
            if (x.element.equals(element)) {
                
                // Returns true if element is found
                return true;
            }
        }
        
        // Returns false if the element is not found
        return false;
    }
    
    /** 
     * Returns the index of the specified element
     *
     * @param element the element we're looking for
     * @return the index of the element in the list, 
     * or -1 if it is not contained within the list
     */
    public int indexOf(T element) {
        
        // Initializes an index integer at 0
        int index = 0;
        
        // For loop that runs through the linked list
        for (Node x = head; x != null; x = x.next) {
            
            // If statement that evaluates whether the element in the
            // current node is equal to the element desired
            if (x.element.equals(element)) {
                
                // Returns the current value of index if so
                return index;
            }
            
            // Increments index by 1
            index++;
        }
        
        // Returns -1 if the element is not found
        return -1;
    }
}