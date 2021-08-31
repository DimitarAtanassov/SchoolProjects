// Assignment #: 10
//         Name: Dimitar Atanassov
//    StudentID: 1217419086
//  Lab Lecture: 4:30 - 5:45
//      Section: ? 
//  Description: The LinkedList defines a linked list using its node class
//  object and also defines a iterator class to traverse the linked list.


import java.util.ListIterator;
import java.util.NoSuchElementException;

import javax.lang.model.element.Element;

/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class LinkedList
{
   /**
      Constructs an empty linked list.
   */
   public LinkedList()
   {
      first = null;
   }

   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      return first.data;
   }

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      return element;
   }

   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addFirst(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }


   /*************** Added methods *******************************/

   // 1. The add adds the parameter string into the linked list. The linked list
   //     should contain all strings in alphabetical order
   public void add(String string)
   {
	  //Goal: Add string to LinkedList
	   //Check if iterator has next first if it doesn't we add string at this position
	   //Else while the list hasnext if compareTo equals -1 .next if compareTo equals 1 we go next if it equals 0 input
	   ListIterator iterator = this.listIterator();		//Iterator goes goes through nodes in list
	   Node holdsObj = first;	//Node holds first node
	   if(first == null) {
		   iterator.add(string);
		   return;
	   }
	   else {
		   while(iterator.hasNext()) {
			   String prev =(String) iterator.next();
			   if(string.compareTo(prev) < 0) {
				   iterator.set(string);	//Set sets the element that was last traversed and goes on over
				   iterator.add(prev);		//Puts the varible that is set over one
				   break;
			   }
			   else if(iterator.hasNext() == false) {	//This we reached the end of the list and none of the values came before it alphabetically
				   iterator.add(string);	//add it to the ends
				   
			   }
			   
		   }
	   }
		   
   }


  
   //2. count method counts how many times the parameter object
   //appears in the linked list and return the number. It returns 0
   //if the parameter object does not exist in the linked list.
   public int count(String element) {
	   int count = 0;	//Keeps track fo how many strings there are that match
	   ListIterator iterator = this.listIterator();
	   if(first == null) {
		  count = 0;	//Linkedlist is empty
	   }
	   else {
		   while(iterator.hasNext()) {	//Linkedlist is not empty
			   if(element.equals((String)iterator.next())) {	//Comapres the string w every string in the linked list
				   count++;	//If they do compare add one to the counter
				   //Do i need an iterartor.next here?
			   }
		   }
	   } 
	   return count;
   }
   



   
  //3. search method returns the index of the parameter object
  //in the linked list if it exists. It return -1 if it does not
  //exits. If the index is out of bounds, then it throws an exception.
   public int search(String element) {
	  int index = 0;	//What if its at zero
	  ListIterator iterator = this.listIterator();
	  String StringToFind = element;
	  if(!iterator.hasNext()) {
		  return -1;
	  }
	  else {
		  while(iterator.hasNext()) {
			  if(element.equals(iterator.next())) {
				  return index;
			  }
			  else {
				  index++;
			  }
		  }
		  //Might need to add a negative one if it is not found
		  return -1;
	  }
	   
   }
  




   //4. remove method removes the element at the parameter
   //index in the linked list.
   public String remove (int Index) {
	   ListIterator iterator = this.listIterator();
	   int currIndex = 0;
	   String removed = "";
	   if(!iterator.hasNext() && Index != currIndex) {
		   return null;
	   }
	   else if(Index == 0) {
		   return (String) removeFirst();
	   }
	   else {
		   Node temp = first;
		   while(iterator.hasNext()) {
			   if(currIndex == Index) {
				  //Store data in return var
				   //Move over one
				   //Remove
				   removed = (String) temp.data;
				   iterator.next();
				   iterator.remove();
				   return removed;
			   }
			   else {
				   iterator.next();
				   temp = temp.next;
				   currIndex++;
			   }
			   
		   }
		   return null;
	   }
	   
   }
	   
   



   //5. The method size return the current size of the linked list,
   //that is, the number of elements in it.
   public int size() {
	   ListIterator iterator = this.listIterator();
	   int size = 0;
	   if(!iterator.hasNext()) {
		   size = 0;
	   }
	   else {
		   while(iterator.hasNext()) {
			   size ++;
			   iterator.next();
		   }
	   }
	   return size;
   }

   





   //6. The toString method returns a string containing the content
   //of the linked list. In this assignment, the linked list will
   //contain only string, so it returns a concatenation of all strings
   //in the linked list and a line break
   public String toString() {
	   Node temp = first;
	   String result = "{ ";
	   ListIterator iterator = this.listIterator();
	   if(!iterator.hasNext()) {
		   result = "{ }\n";
		   return result;
	   }
	   else {
		   while(temp != null) {
			   result += temp.data + " ";
			   temp = temp.next;
			   iterator.next();
		   }
		   result += "}\n";
		   return result;
	   }
	   

   }

   



   //7. The removeLastFew method removes the parameter specified number
   //of elements from the end of the linked list.
   //If the parameter integer is larger than the current size of
   //the linked list, then the linked-list will be empty.
   //If the parameter integer is less than 0,
   //nothing should be removed from the linked list.
   public void removeLastFew(int howMany) {
	   int num = howMany;
	   ListIterator iterator = this.listIterator();
	   for(int i = size(); i > 0; i--) {
		   iterator.next();
		   if( i <= howMany) {
			   iterator.remove();
		   }
	   }
   }
     

   /***************************************************************/

   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   private Node first;

   private class Node
   {
      public Object data;
      public Node next;
   }

   private class LinkedListIterator implements ListIterator
   {
      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
         if (!hasNext())
            throw new NoSuchElementException();
         previous = position; // Remember for remove

         if (position == null)
            position = first;
         else
            position = position.next;

         return position.data;
      }

      /**
         Tests if there is an element after the iterator
         position.
         @return true if there is an element after the iterator
         position
      */
      public boolean hasNext()
      {
         if (position == null)
            return first != null;
         else
            return position.next != null;
      }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }
         previous = position;
      }

      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
         if (previous == position)
            throw new IllegalStateException();

         if (position == first)
         {
            removeFirst();
         }
         else
         {
            previous.next = position.next;
         }
         position = previous;
      }

      /**
         Sets the last traversed element to a different
         value.
         @param element the element to set
      */
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }

      private Node position;
      private Node previous;
	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object previous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
   }
}