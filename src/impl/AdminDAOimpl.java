package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDAO;
import pojo.Admin;
import pojo.User;
import util.DBUtil;

public class AdminDAOimpl implements AdminDAO {

	public static Connection conn = DBUtil.getConnection();

	@Override
	public List<Admin> findAll() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Admin> admins = null;
		String sql = "select * from t_admin";
		conn = DBUtil.getConnection();
		stmt = DBUtil.getStatement(conn);
		rs = DBUtil.getResultSet(stmt, sql);
		admins = new ArrayList<>();

		try {
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAname(rs.getString("aname"));
				admin.setApwd(rs.getString("apwd"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, stmt, rs);
		}

		return admins;
	}

	// public void add(Admin admin) {
	// PreparedStatement prep=null;
	// String sql="insert into t_admin values(null,?,?)";
	// prep=DBUtil.getPreparedStatement(conn, sql);
	// try{
	// prep.setObject(1, admin.getAname());
	// prep.setObject(2, admin.getApwd());
	// prep.executeUpdate();
	// }catch (SQLException e){
	// e.printStackTrace();
	// }finally{
	// DBUtil.close(conn, prep);
	// }

	@Override
	public void delete(Integer id) {
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep = null;
		String sql = "delete from t_admin where id=?";
		prep = DBUtil.getPreparedStatement(conn, sql);
		try {
			prep.setObject(1, id);
			prep.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prep);
		}

	}

	@Override
	public void delete(String aname) {
		PreparedStatement prep = null;
		String sql = "delete from t_admin where aname=?";
		prep = DBUtil.getPreparedStatement(conn, sql);

		try {
			prep.setObject(1, aname);
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prep);
		}

	}

	@Override
	public void update(Admin admin) {
		Connection conn = DBUtil.getConnection();

		PreparedStatement prep = null;
		// 添加事务管理Mysql数据库中默认是自动提交的Oracle需手动提交
		// 1.获取事务的属性
		try {
			boolean autoCommit = conn.getAutoCommit();
			// 2.将默认提交方式设置为手动提交
			conn.setAutoCommit(false);
			conn = DBUtil.getConnection();
			String sql = "update t_admin set aname=?,apwd=? where id=?";
			prep = DBUtil.getPreparedStatement(conn, sql);

			prep.setObject(1, admin.getAname());
			prep.setObject(2, admin.getApwd());
			prep.setObject(3, admin.getId());
			prep.executeUpdate();
			// 3.手动提交事务
			conn.commit();
			// 将默认提交方式归还
			conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prep);
		}

	}

	@Override
	public Admin findById(Integer id) {
		Statement stmt = null;
		ResultSet rs = null;
		Admin admin = null;
		String sql = "select * from t_admin where id=" + id;
		conn = DBUtil.getConnection();
		stmt = DBUtil.getStatement(conn);
		rs = DBUtil.getResultSet(stmt, sql);

		try {
			while (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAname(rs.getString("aname"));
				admin.setApwd(rs.getString("apwd"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, stmt, rs);
		}
		return admin;
	}

	@Override
	public void add(Admin admin) {
		conn = DBUtil.getConnection();
		PreparedStatement prep = null;
		String sql = "insert into t_admin values(null,?,?)";
		prep = DBUtil.getPreparedStatement(conn, sql);
		

		try {
			boolean autoCommit = conn.getAutoCommit();
			// 2.将默认提交方式设置为手动提交
			conn.setAutoCommit(false);
			prep.setObject(1,admin.getAname());
			prep.setObject(2,admin.getApwd());
			prep.executeUpdate();
			System.out.println("123556");
			conn.commit();
			conn.setAutoCommit(autoCommit); 
			

		} catch (SQLException e) {
			DBUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prep);
		}

	}
	
	
	public Admin findByAname(String aname) {
		Statement stmt=null;
		ResultSet rs=null;
		Admin admin=null;
		String sql="select * from t_admin where aname='"+aname+"'";
		conn=DBUtil.getConnection();
		stmt=DBUtil.getStatement(conn);
		rs=DBUtil.getResultSet(stmt, sql);
		
		try{
			while(rs.next()){
				 admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAname(rs.getString("aname"));
				admin.setApwd(rs.getString("apwd"));
				
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			DBUtil.close(conn, stmt,rs);
		}
		
				
				
		return admin;
	}

}
	


