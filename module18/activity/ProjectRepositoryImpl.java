package sef.module18.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {

	private Connection conn;
	
	public ProjectRepositoryImpl(Connection conn) {
		this.conn = conn;
	}
	
	/* (non-Javadoc)
	 * @see sef.module18.activity.ProjectRepository#findProjectByID(int)
	 */
	@Override
	public Project findProjectByID(int id) throws HRSSystemException {
		Project result = null;
		try {
			PreparedStatement pStmt = conn
					.prepareStatement("select * from Project where ID = ?");
			pStmt.setInt(1, id);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				result = new ProjectImpl(rs.getInt("ID"), 
							rs.getString("NAME"),
							rs.getString("DESCRIPTION"));
				
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			throw new HRSSystemException(HRSSystemException.ERROR_FIND_PROJECT_ID,
					e);
		}
		return result;	
	}

	/* (non-Javadoc)
	 * @see sef.module18.activity.ProjectRepository#findProjectByName(java.lang.String)
	 */
	@Override
	public List<Project> findProjectByName(String name) throws HRSSystemException {
		List<Project> results = new ArrayList<Project>();
		try {
			PreparedStatement pStmt = conn
					.prepareStatement("select * from Project where upper(NAME) like ? " +
							          "order by ID ASC");
			pStmt.setString(1, "%" + name.toUpperCase() + "%");

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				results.add(new ProjectImpl(rs.getInt("ID"), 
							rs.getString("NAME"),
							rs.getString("DESCRIPTION")));
			}
			rs.close();
			pStmt.close();

		} catch (SQLException e) {
			throw new HRSSystemException(HRSSystemException.ERROR_FIND_PROJECT_NAME,
					e);
		}
		return results;
	}
	
	/* (non-Javadoc)
	 * @see sef.module18.activity.ProjectRepository#findProjectByEmployee(int)
	 */
	@Override
	public List<Project> findProjectByEmployee(int employeeID) throws HRSSystemException {
		List<Project> results = new ArrayList<Project>();
		try {
			PreparedStatement pStmt = conn
					.prepareStatement("select p.* from Project p join Employee_Project_Map epm on " + 
									  "p.ID = epm.PROJECT_ID where epm.EMPLOYEE_ID = ? order by p.ID ASC");
			pStmt.setInt(1, employeeID);

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				results.add(new ProjectImpl(rs.getInt("ID"), 
							rs.getString("NAME"),
							rs.getString("DESCRIPTION")));
			}
			rs.close();
			pStmt.close();

		} catch (SQLException e) {
			throw new HRSSystemException(HRSSystemException.ERROR_FIND_PROJECT_EMPLOYEEID,
					e);
		}
		return results;
	}
	
	/* (non-Javadoc)
	 * @see sef.module18.activity.ProjectRepository#insertProject(sef.module18.activity.Project)
	 */
	@Override
	public int insertProject(Project project) throws HRSSystemException {
		int projectID = 0;
		
		try {
			PreparedStatement pStmt = conn
					.prepareStatement("insert into project (ID, NAME, DESCRIPTION) VALUES (PROJECT_SEQ.NEXTVAL,?,?)");

			pStmt.setString(1, project.getProjectName());
			pStmt.setString(2, project.getProjectDescription());

			int rows = pStmt.executeUpdate();
			
			conn.commit();
			if (rows == 1) {
				pStmt = conn
					.prepareStatement("select LAST_INSERT_ID()");

				ResultSet rs = pStmt.executeQuery();
				if (rs.next()){
					projectID = rs.getInt(1);
				}
				
				rs.close();
			}
			
			pStmt.close();

		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				throw new HRSSystemException(
						HRSSystemException.ERROR_INSERT_PROJECT, e);

			}
			throw new HRSSystemException(
					HRSSystemException.ERROR_INSERT_PROJECT, ex);
		}

		return projectID;
	}

	/* (non-Javadoc)
	 * @see sef.module18.activity.ProjectRepository#updateProject(sef.module18.activity.Project)
	 */
	@Override
	public boolean updateProject(Project project) throws HRSSystemException {
		try {
			PreparedStatement pStmt = conn
					.prepareStatement("update Project set NAME = ?, DESCRIPTION = ? " +
							"where ID = ?");

			pStmt.setString(1, project.getProjectName());
			pStmt.setString(2, project.getProjectDescription());
			pStmt.setInt(3, project.getProjectID());

			int rows = pStmt.executeUpdate();
			
			conn.commit();
			pStmt.close();
			
			if (rows == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				throw new HRSSystemException(
						HRSSystemException.ERROR_UPDATE_PROJECT, e);

			}
			throw new HRSSystemException(
					HRSSystemException.ERROR_UPDATE_PROJECT, ex);
		}
	}

}
