package sef.module3.activity;

import junit.framework.TestCase;

public class ArrayStackTest extends TestCase {
	
	ArrayStackTest1 test = new ArrayStackTest1();

	
	public void testArrayStackCreateNormal(){
		test.testArrayStackCreateNormal();
	}
	
	public void testArrayStackCreateException() {
		test.testArrayStackCreateException();
	}
	
	public void testPush() {
		test.testPush();
	}
	
	public void testPeek(){
		test.testPeek();
	}
	
	public void testPop(){
		test.testPop();
	}
	
	public void testFindElement(){
		test.testFindElement();
	}
		
}
