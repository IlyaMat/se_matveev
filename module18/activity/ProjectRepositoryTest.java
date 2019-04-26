package sef.module18.activity;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ProjectRepositoryTest extends TestCase {

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
    public void testFindProjectByID(){
        ProjectRepository repository = new ProjectRepositoryImpl(conn);
        try {
            Project result = repository.findProjectByID(1);

            assertEquals(1,result.getProjectID());
            assertEquals("Online Insurance System".toUpperCase(), result.getProjectName().toUpperCase());
            assertEquals("A web application that automates insurance transactions.".toUpperCase(), result.getProjectDescription().toUpperCase());

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }
    public void testFindProjectByName(){
        ProjectRepositoryImpl repository = new ProjectRepositoryImpl(conn);
        try{
            List<Project> projectList = repository.findProjectByName("Online Insurance System");

            assertEquals(1, projectList.size());

            assertEquals(1, projectList.get(0).getProjectID());
            assertEquals("Online Insurance System".toUpperCase(),projectList.get(0).getProjectName().toUpperCase());
            assertEquals("A web application that automates insurance transactions.".toUpperCase(),projectList.get(0).getProjectDescription().toUpperCase());

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testFindProjectByEmployee(){
        ProjectRepositoryImpl repository = new ProjectRepositoryImpl(conn);
        try {
             List<Project> projectList = repository.findProjectByEmployee(1);

            assertEquals(1, projectList.get(0).getProjectID());
            assertEquals("ONLINE INSURANCE SYSTEM",projectList.get(0).getProjectName().toUpperCase());
            assertEquals("A WEB APPLICATION THAT AUTOMATES INSURANCE TRANSACTIONS.",projectList.get(0).getProjectDescription().toUpperCase());

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }

    }
    public void testInsertProject(){
        ProjectRepositoryImpl repository = new ProjectRepositoryImpl(conn);
        try {
            Project project = new ProjectImpl(7,"Online Systems","Web application");

            int res = repository.insertProject(project);
            assertEquals(7,res);

        }catch(AssertionFailedError e){
            logger.error(sef.module.percentage.Percentage.setFailedCount(1, e.getMessage()));
            fail();
        }
        catch (HRSSystemException e) {
            // TODO Auto-generated catch block
            fail();
        }
    }

    public void testUpdateProject(){
        ProjectRepositoryImpl repository = new ProjectRepositoryImpl(conn);
        try {
            Project project = new ProjectImpl(4,"NewName project","NewDescription");

            boolean result = repository.updateProject(project);

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


}
