package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 关于工具类，一般情况下定义的方法全是静态方法
 * 不用创建对象，只加载一次，大大提高了效率
 * 直接使用类名.静态方法名
 * @author leishao
 *
 */
public class DBUtil {
	public static Properties prop=new Properties();
	static{
		try {
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String CLASS_NAME=prop.getProperty("class_name");
	public static String URL=prop.getProperty("url");
	public static String USERNAME=prop.getProperty("username");
	public static String PASSWORD=prop.getProperty("password");
	/**
	 * 连接数据库的方法
	 * @return Connection
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(CLASS_NAME);
			// 2.通过驱动管理器加载驱动
			 conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 封装获取Statement 对象的方法
	 */
	public static Statement getStatement(Connection conn){
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	/**
	 * 封装获取ResultSet对象的方法
	 */
	public static ResultSet getResultSet(Statement stmt,String sql){
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	/**
	 * 关闭三个资源的方法
	 */
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		close(conn, stmt);
		try {
			if(rs!=null)
			rs.close();
			rs=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,Statement stmt){
		try {
			if(conn!=null)
			conn.close();
			conn=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(stmt!=null)
			stmt.close();
			stmt=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * DML 操作的静态方法（insert/update/delete）
	 * @param args
	 */
	public static int executeUpdate(Statement stmt,String sql){
		int recordsCount=0;
		try {
			recordsCount=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recordsCount;
	}
	/**
	 * 获取PreparedStatement 对象
	 * @param args
	 */
	public static PreparedStatement getPreparedStatement(Connection conn,String sql){
		PreparedStatement prep=null;
		try {
			 prep=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prep;
		
		
	}
	/**
	 * 封装一个回滚的方法
	 * 
	 */
	public static void rollback(Connection conn){
		try {
			
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,Statement stmt1,Statement stmt2,Statement stmt3,ResultSet rs){
		try {
			if(stmt2!=null)
			stmt2.close();
			stmt2=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(stmt3!=null)
			stmt3.close();
			stmt3=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}

}

