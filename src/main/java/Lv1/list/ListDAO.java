package Lv1.list;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ListDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public ListDAO() {
		
		try {
			Context ctx =new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory= (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public List list() {
		List list = new ArrayList();
		
		try {
			con = dataFactory.getConnection();
			
			StringBuffer sb = new StringBuffer();
			sb.append("select * from emp");
			sb.append(" order by empno");
			
			System.out.println(sb);
			
			pstmt = con.prepareStatement(sb.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ListVO listvo = new ListVO();
				listvo.setEmpno(rs.getInt("empno"));
				listvo.setEname(rs.getString("ename"));
				listvo.setJob(rs.getString("job"));
				listvo.setMgr(rs.getInt("mgr"));
				listvo.setHiredate(rs.getDate("hiredate"));
				listvo.setSal(rs.getInt("sal"));
				listvo.setComm(rs.getInt("comm"));
				listvo.setDeptno(rs.getInt("deptno"));
				
				list.add(listvo);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
