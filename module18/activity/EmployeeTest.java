package sef.module18.activity;

import junit.framework.TestCase;

public class EmployeeTest extends TestCase {
    public void testEmployeeSetAndGet(){
      EmployeeImpl employee = new EmployeeImpl(1, "Jim", "Brown", 3);

      int id =4;
      String firstName = "Elizabeth";
      String lastName = "Smith";
      int profLevel = 5;

      employee.setEmployeeID(id);
      employee.setFirstName(firstName);
      employee.setLastName(lastName);
      employee.setProfLevel(profLevel);

      assertEquals(id, employee.getEmployeeID());
      assertEquals(firstName, employee.getFirstName());
      assertEquals(lastName, employee.getLastName());
      assertEquals(profLevel, employee.getProfLevel());

    }

}
