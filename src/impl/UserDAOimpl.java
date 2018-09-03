package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO ;
import pojo.User;
import util.DBUtil;

public class UserDAOimpl implements UserDAO {
	Connection conn=null;

	// MySQL数据库的数据访问
	@Override
	public List<User> findAll() {
		
		Statement stmt=null;
		ResultSet rs=null;
		List<User> users=null;
		String sql="select * from t_user";
		conn=DBUtil.getConnection();
		stmt=DBUtil.getStatement(conn);
		rs=DBUtil.getResultSet(stmt, sql);
		users=new ArrayList<>();
		try{
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddr(rs.getString("addr"));
				user.setRdate(rs.getTimestamp("rdate"));
				users.add(user);
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			DBUtil.close(conn, stmt,rs);
		}
		
				
				
		return users;
	}

	@Override
	public void add(User user) {
		conn=DBUtil.getConnection();
		PreparedStatement prep=null;
		String sql="insert into t_user values(null,?,md5(?),?,?,now())";
		prep=DBUtil.getPreparedStatement(conn, sql);
		try {
			boolean autoCommit=conn.getAutoCommit();
			prep.setObject(1, user.getUsername());
			prep.setObject(2, user.getPassword());
			prep.setObject(3, user.getPhone());
			prep.setObject(4, user.getAddr());
			
			prep.executeUpdate();
			
			conn.commit();
			conn.setAutoCommit(autoCommit);
			
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			e.printStackTrace();
		}finally{
			DBUtil.close(conn,prep);
		}
		
		
				

	}

	@Override
	public void delete(Integer id) {
		PreparedStatement prep=null;
		String sql="delete from t_user where id=?";
		prep=DBUtil.getPreparedStatement(conn, sql);
		try {
			prep.setObject(1, id);
			
			prep.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.close(conn,prep);
		}
	}

	@Override
	public void delete(String username) {
		PreparedStatement prep=null;
		String sql="delete from t_user where aname=?";
		prep=DBUtil.getPreparedStatement(conn, sql);
		
		try {
			prep.setObject(1, username);
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, prep);
		}

	}

	@Override
	public void update(User user) {
		PreparedStatement prep=null;
		
		
		String sql="update t_user set username=?,password=?,phone=?,addr=? where id=?";
		conn=DBUtil.getConnection();
		prep=DBUtil.getPreparedStatement(conn, sql);
		try{
			prep.setObject(1, user.getUsername());
			prep.setObject(2, user.getPassword());
			prep.setObject(3, user.getPhone());
			prep.setObject(4, user.getAddr());
			prep.setObject(5, user.getId());
			prep.executeUpdate();
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			DBUtil.close(conn,prep);
		}
		
				
				
		
	}

	@Override
	public User findById(Integer id) {
		Statement stmt=null;
		ResultSet rs=null;
		User user=null;
		String sql="select * from t_user where id="+id;
		conn=DBUtil.getConnection();
		stmt=DBUtil.getStatement(conn);
		rs=DBUtil.getResultSet(stmt, sql);
		
		try{
			while(rs.next()){
				 user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddr(rs.getString("addr"));
				user.setRdate(rs.getTimestamp("rdate"));
				
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			DBUtil.close(conn, stmt,rs);
		}
		
				
				
		return user;
	}
	/**
	 * 根据用户名查找user对象
	 * username 传入用户名
	 */
	
	
	
	@Override
	public User findByUsername(String username) {
		Statement stmt=null;
		ResultSet rs=null;
		User user=null;
		String sql="select * from t_user where username='"+username+"'";
		conn=DBUtil.getConnection();
		stmt=DBUtil.getStatement(conn);
		rs=DBUtil.getResultSet(stmt, sql);
		
		try{
			while(rs.next()){
				 user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddr(rs.getString("addr"));
				user.setRdate(rs.getTimestamp("rdate"));
				
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			DBUtil.close(conn, stmt,rs);
		}
		
				
				
		return user;
	}

}
