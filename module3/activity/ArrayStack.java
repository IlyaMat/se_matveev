package sef.module3.activity;


/**
 * @author John Doe
 * 
 * This class represents a stack structure (Last-In, First-Out) implemented using
 * an array
 */
public class ArrayStack{
	
	//IMPORTANT:
	//In each of the TODOs below, the array of Objects called 'stack' will be available and
	//already initialized. The integer 'count' is also available and is meant to track how
	//many objects there are in the array
	
	private Object stack[];
	int count;
	
	/**
	 * Create an instance of an ArrayStack.  A negative number specified in the constructor
	 * will default the maximum to 1
	 * 
	 * @param maximum number of elements the stack can hold
	 */
	public ArrayStack(int maximum){
		//TODO #1: Write a decision making code such that if the value
		//of the integer parameter variable 'maximum' is less than 0 
		//If true, then then the variable 'maximum' should be set to 1
		if(maximum < 0){
			maximum = 1;
		}
		//END TODO #1
		
		
		
		//TODO #2: Write code that will initialize the array 'stack' as an 
		//array of objects with a maximum length specified by the parameter 'maximum'
		stack = new Object[maximum];
		//END TODO #2
	
		
		
		//TODO #3: Write code that will initialize the value of the 
		//integer variable 'count' to 0
		count = 0;
		//END TODO #3
	}
	
	/**
	 * Returns the last element added to the stack
	 * 
	 * @return the last element added or null if the stack is empty
	 */
	public Object peek(){
		
		Object temp = null;
		
		//TODO #4: Write decision making code to see if the value of 'count' is 0.  
		//If true, set the value of 'temp' to null
		if(count == 0){
			temp = null;
		}
		//END TODO #4
		
		
		//TODO #5: Write code that will assign to temp, the 
		//last element pushed into this array
		temp = stack[count-1];
		//END TODO #5
		
		return temp;
	}
	
	/**
	 * Pushes the specified element into the top of the stack
	 * 
	 * @param element the element to be pushed
	 * @return true if successful, false otherwise (due to stack being full)
	 */
	public boolean push(Object  element){
		
		//TODO #6: Write decision making code that checks if there is enough 
		//space in the array to store one more 'element'.  If there is no more space, 
		//return false
		if(getMaximum() == count){
			return false;
		}
		//END TODO #6
		
		
		
		//TODO #7: Write code that will add the Object parameter 'element' to the next
		//available index of the array. The integer variable 'count' should be increased
		//by 1 to indicate this addition to the array
		stack[count] = element;
		count++;
		//END TODO #7
		
		return true;
	}
	
	/**
	 * Removes and returns the last element added to the stack
	 * 
	 * @return the last element added or null if the stack is empty
	 */
	public Object pop(){
		
		Object temp=null;
		
		//TODO #8: Write code that will check if there are any elements contained in
		//the 'stack' array.  If there array is empty, return null
		if(count == 0){
			return null;
		}
		//END TODO #8
		
		
		//TODO #9: Write code that will subtract 1 from the variable 'count' to represent an
		//element being 'removed' from the array
		count--;

		//END TODO 9
		
		
		//TODO #10: Write code that will get the last element added in the array and assign it
		//to the variable 'temp'
		temp = stack[count];
		//END TODO #10
	
		return temp;
	}
	
	
	/**
	 * Returns the position of the first element found in the stack (using the == criterion) relative
	 * to the top of the stack.  The top of the stack will be position 0
	 * 
	 * @param element The element to find
	 * @return The position of the element
	 */
	public int findElement(Object element){
		//TODO #11: 
		//Create code that will search the stack array for the Object element that
		//is specified in the parameter and return its position relative to the end
		//of the array. 
		//Ex: An element found at the top of the stack will be at position 0

		for(int i = stack.length-1, j=0; i >= 0; i--, j++){
			if(stack[i] == element){
				return j;
			}
		}

		//END TODO #11:
		
		return -1;
	}
	
	/**
	 * Returns the number of elements currently contained in the stack
	 * 
	 * @return current number of elements in the stack
	 */
	public int getCount(){
		return count;
	}
	
	/**
	 * Returns the number of elements the stack can hold
	 * 
	 * @return maximum number of elements
	 */
	public int getMaximum(){
		return stack.length;
	}
}
	

