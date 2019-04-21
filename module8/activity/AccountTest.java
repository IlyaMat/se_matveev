package sef.module8.activity;

import junit.framework.TestCase;

public class AccountTest extends TestCase {
	
	AccountTest1  runTest = new AccountTest1();
	
	public void testNormalAccountCreation(){
		runTest.testNormalAccountCreation();
	}
	
	public void testInvalidAccountCreation(){
		runTest.testInvalidAccountCreation();		
	}
	
	public void testThrowAccountException(){
		runTest.testThrowAccountException();
	}
	
	public void testAccountExceptionMessageSent(){
		runTest.testAccountExceptionMessageSent();
	}
}
