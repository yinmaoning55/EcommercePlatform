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
 * ���ڹ����࣬һ������¶���ķ���ȫ�Ǿ�̬����
 * ���ô�������ֻ����һ�Σ���������Ч��
 * ֱ��ʹ������.��̬������
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
	 * �������ݿ�ķ���
	 * @return Connection
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(CLASS_NAME);
			// 2.ͨ��������������������
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
	 * ��װ��ȡStatement ����ķ���
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
	 * ��װ��ȡResultSet����ķ���
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
	 * �ر�������Դ�ķ���
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
	 * DML �����ľ�̬������insert/update/delete��
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
	 * ��ȡPreparedStatement ����
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
	 * ��װһ���ع��ķ���
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

