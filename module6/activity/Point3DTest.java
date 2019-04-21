package sef.module6.activity;

import junit.framework.TestCase;

public class Point3DTest extends TestCase {

	Point3DTest1 runTest = new Point3DTest1();
	
	public void testPoint3DDefaultCreate(){
		runTest.testPoint3DDefaultCreate();
	}
	
	public void testPoint3DCreate(){
		runTest.testPoint3DCreate();
	}
	
	public void testMove(){
		runTest.testMove();
	}
	
	
	public void testTranslate(){
		runTest.testTranslate();
	}
	
	public void testEquals(){
		runTest.testEquals();	
	}
	
	public void testGetDistance(){
		runTest.testGetDistance();
	}
}
