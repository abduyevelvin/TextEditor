package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size = 0;
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Invalid input element!");
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> prevNode = tail.prev;
		prevNode.next = newNode;
		newNode.prev = prevNode;
		newNode.next = tail;
		tail.prev = newNode;
		this.size++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!");
		}
		
		LLNode<E> target = head;
		
		for(int i = 0; i <= index; i++) {
			target = target.next;
		}
		
		E value = target.data;
		
		return value;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Invalid input element!");
		}
		
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!");
		}
		
		LLNode<E> nodeToAdd = new LLNode<E>(element);
		LLNode<E> nodeAtIndex = head;
		
		for(int i = 0; i <= index; i++) {
			nodeAtIndex = nodeAtIndex.next;
		}
		
		LLNode<E> prevNode = nodeAtIndex.prev;
		prevNode.next = nodeToAdd;
		nodeToAdd.prev = prevNode;
		nodeToAdd.next = nodeAtIndex;
		nodeAtIndex.prev = nodeToAdd;
		
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!");
		}
		
		LLNode<E> nodeToRemove = head;
		
		for(int i = 0; i <= index; i++) {
			nodeToRemove = nodeToRemove.next;
		}
		
		LLNode<E> prevNode = nodeToRemove.prev;
		LLNode<E> nextNode =nodeToRemove.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		
		size--;
		
		E value = nodeToRemove.data;
		
		return value;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Invalid input element!");
		}
		
		if(index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index input!");
		}
		
		LLNode<E> nodeToSet = head;
		
		for(int i = 0; i <= index; i++) {
			nodeToSet = nodeToSet.next;
		}
		
		nodeToSet.data = element;
		
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
