package sef.module18.activity;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class EmployeeRepositoryTest extends TestCase {
    private Connection conn;
    private String url ;
    private String username;
    private String password;
    Log logger = LogFactory.getLog(this.getClass());

    protected void setUp() throws Exception {
        super.setUp();
        username = "sa";
        password = "";
        Class.forName("org.h2.Driver");
        url = "jdbc:h2:~"; /*   /test   */
        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);
        System.out.println("Connection successfully established!");
    }
    /*********/
    public void testFindEmployeeByID(){
        EmployeeRepository repository = new EmployeeRepositoryImpl(conn);
        try {
             Employee result = repository.findEmployeeByID(1);

            assertEquals( "JOHN", result.getFirstName().toUpperCase());
            assertEquals("DOE",result.getLastName().toUpperCase());
            assertEquals(1,result.getProfLevel());

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testFindEmployeeByName(){
        EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl(conn);
        try {
            List<Employee> result = repository.findEmployeeByName("Joh","Doe");

            assertEquals(1,result.size());

            assertEquals(result.get(0).getEmployeeID(), 1);
            assertEquals(result.get(0).getFirstName().toUpperCase(), "JOHN");
            assertEquals(result.get(0).getLastName().toUpperCase(), "DOE");
            assertEquals(result.get(0).getProfLevel(), 1);

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testFindEmployeeByProfLevel(){
        EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl(conn);
        try {
            List<Employee> result = repository.findEmployeeByProfLevel(3);


            assertEquals(result.get(0).getEmployeeID(), 4);
            assertEquals(result.get(0).getFirstName().toUpperCase(), "JAMES");
            assertEquals(result.get(0).getLastName().toUpperCase(), "DONNELL");
            assertEquals(result.get(0).getProfLevel(), 3);

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testFindEmployeeByProject(){
        EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl(conn);
        try {
            List<Employee> result = repository.findEmployeeByProject(1);
            assertEquals(result.get(0).getEmployeeID(),1);
            assertEquals(result.get(0).getFirstName().toUpperCase(),"JOHN" );
            assertEquals(result.get(0).getLastName().toUpperCase(), "DOE");

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testInsertEmployee(){
        EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl(conn);
        try {
            Employee employee = new EmployeeImpl(7,"Andi","Doun",1);
            int result = repository.insertEmployee(employee);
            /*
            Employee result = repository.findEmployeeByID(6);

            assertEquals( "ANDI", result.getFirstName().toUpperCase());
            assertEquals("DOUN",result.getLastName().toUpperCase());
            assertEquals(1,result.getProfLevel());*/
            assertEquals(7,result);

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void  testUpdateEmployee(){
        EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl(conn);
        try {
            Employee employee = new EmployeeImpl(5,"Aldos","Des",6);

            boolean result = repository.updateEmployee(employee);
            assertTrue(result);
        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    /*********/
}
