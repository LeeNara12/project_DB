package Lv2.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Lv1.list.ListVO;

public class loginDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public loginDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}
	
	public HashMap login(ListVO vo) {
		HashMap login_map = new HashMap(); 
		boolean result = false;
		String str1 = "";
		try {
			con = dataFactory.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append(" select * from emp");
			sb.append(" where ename = ? and empno = ?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getEname());
			pstmt.setInt(2, vo.getEmpno());
			
			ResultSet rs = pstmt.executeQuery();
		
			if(rs.next()) {
				vo.setEname(rs.getString("ename"));
				vo.setEmpno(rs.getInt("empno"));
				result = true;
				str1 = "환영합니다"+ rs.getString("ename") +"님";
				login_map.put("result", result);
				login_map.put("str1", str1);
				
			}else {
				result = false;
				str1 = "사원명과 사원번호가 존재하지 않습니다.";
				login_map.put("result", result);
				login_map.put("str1", str1);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return login_map;
	}
	
	
}
