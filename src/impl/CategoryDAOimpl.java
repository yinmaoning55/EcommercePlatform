package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDAO;
import pojo.Category;
import util.DBUtil;



public  class CategoryDAOimpl implements CategoryDAO {

	public Connection conn = null;
	private PreparedStatement prepInsert;

	public List<Category> findAll() {
		Connection conn=DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Category> cs = null;
		String sql = "select * from t_category";
		conn = DBUtil.getConnection();
		stmt = DBUtil.getStatement(conn);
		rs = DBUtil.getResultSet(stmt, sql);
		cs = new ArrayList<>();
		try {
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName((rs.getString("name")));
				c.setDescr((rs.getString("descr")));
				c.setPid(rs.getInt("pid"));
				c.setLeaf(rs.getInt("leaf") == 1 ? true : false);
				c.setGrade(rs.getInt("grade"));
				cs.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(conn, stmt, rs);
		}

		return cs;
	}
@Override
	public List<Category> findToTree() {

		List<Category> cs = new ArrayList<>();
		findToTree(cs,0);
		
		return cs;

	}
	/**
	 *树状列表显示 
	 *传入传出参数的方法
	 * @param cs
	 * @param pid
	 * @return
	 */

	private List<Category> findToTree(List<Category> cs, Integer pid) {
		Connection conn = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		// List<Category> cs=null;
		// 先找到pid=pid的所有的孩子
		String selectChildren = "select*from t_category where pid=" + pid;

		try {
			stmt = DBUtil.getStatement(conn);
			rs = DBUtil.getResultSet(stmt, selectChildren);
			// cs=new ArrayList<>();
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName((rs.getString("name")));
				c.setDescr((rs.getString("descr")));
				c.setPid(rs.getInt("pid"));
				c.setLeaf(rs.getInt("leaf") == 1 ? true : false);
				c.setGrade(rs.getInt("grade"));
				//System.out.println(c);
				cs.add(c);
				
				// 直到当前节点是叶子节点为止
				if (!c.isLeaf()) {
					findToTree(cs, rs.getInt("id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*for(Category c:cs){
			System.out.println(c);
		}*/
		return cs;

	}

	// @Override
	public void add(Category c) {
//System.out.println(c);
		conn = DBUtil.getConnection();
		PreparedStatement prep = null;
		String sql = "insert into t_category values(null,?,?,?,?,?)";
		prep = DBUtil.getPreparedStatement(conn, sql);
		try {
			boolean autoCommit = conn.getAutoCommit();
			// 2.将默认提交方式设置为手动提交
			conn.setAutoCommit(false);
			prep.setObject(1, c.getName());
			prep.setObject(2, c.getDescr());
			prep.setObject(3, c.getPid());
			prep.setObject(4, c.isLeaf() ? 1 : 0);
			prep.setObject(5, c.getGrade());
			prep.executeUpdate();
			// 3.手动提交事务
			conn.commit();
			// 将默认提交方式归还
			conn.setAutoCommit(autoCommit);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DBUtil.rollback(conn);
		} finally {
			DBUtil.close(conn, prep);
		}

	}

	private void delete(Connection conn,Integer id ) {
		
		Statement stmt = null;
		ResultSet rsSelectChildren=null;
		String sqlSelect = "select * from t_category where pid="+id;//找孩子（叶子节点）
		String sql = "delete from t_category where id="+id;
		stmt = DBUtil.getPreparedStatement(conn, sql);
		try {
			stmt=DBUtil.getStatement(conn);
			//找到的所有叶子节点
			rsSelectChildren=DBUtil.getResultSet(stmt, sqlSelect);
			
			while(rsSelectChildren.next()){
				delete(conn, rsSelectChildren.getInt("id"));
				
			}
			stmt = DBUtil.getStatement(conn);
			

			stmt.executeUpdate(sql);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void delete (Integer id,Integer pid){
		Connection conn=DBUtil.getConnection();
		ResultSet rsSelectBrothers=null;
		Statement stmt=null;
		String sqlSelectBrothers="select count(*) from t_category where pid="+pid;
		
		String sqlUpdata ="updata t_category set leaf=1 where id="+pid;
		
		try {
			boolean autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			//1.先删除
			delete(conn,id);
			//2.更新
			
			
			
			stmt=DBUtil.getStatement(conn);
			rsSelectBrothers=DBUtil.getResultSet(stmt, sqlSelectBrothers);
			rsSelectBrothers.next();
			int rsCount=rsSelectBrothers.getInt("count(*)");
			
			//没有兄弟接节点
			if(rsCount<=0){
				stmt.executeUpdate(sqlUpdata);
			}
			conn.commit();
			conn.setAutoCommit(autoCommit);
				
				
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, stmt, rsSelectBrothers);
		}
	}
	

	public void update(Category c) {
		conn = DBUtil.getConnection();
		PreparedStatement prep = null;

		String sql = "update t_category set name=?,descr=? where id=?";

		prep = DBUtil.getPreparedStatement(conn, sql);
		try {
			prep.setObject(1, c.getName());
			prep.setObject(2, c.getDescr());
			prep.setObject(3, c.getId());
			prep.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(conn, prep);
		}

	}

	public Category findById(Integer id) {
		conn = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Category c = null;
		String sql = "select * from t_category where id=" + id;

		stmt = DBUtil.getStatement(conn);
		rs = DBUtil.getResultSet(stmt, sql);

		try {
			while (rs.next()) {
				c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescr(rs.getString("descr"));
				c.setPid(rs.getInt("pid"));
				c.setLeaf(rs.getBoolean("leaf"));
				c.setGrade(rs.getInt("grade"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, stmt, rs);
		}
		System.out.println(c);
		return c;
	}

	public void add(String name, String descr) {
		Category c = new Category(name, descr, 0, true, 1);
		add(c);
	}

	public void add(String name, String descr, Integer pid) {
		Connection conn = DBUtil.getConnection();
		Statement StmtSelect = null;
		Statement StmtUpdata = null;
		ResultSet rsSelect = null;
		PreparedStatement prepInsert = null;

		// 1.先找到ID=pid的值所在的记录的grade值
		String selectParentsql = "select*from t_category where id=" + pid;
		// 2.插入数据库数据
		String insertsql = "insert into t_category values(null,?,?,?,?,?)";
		// 3.更新父类别的leaf为0
		String updatasql = "updata t_category set leaf=0 where id=" + pid;
		try {
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);

			StmtSelect = DBUtil.getStatement(conn);
			rsSelect = DBUtil.getResultSet(StmtSelect, selectParentsql);
			// 父级别grade
			rsSelect.next();
			int rsSelectGrade = rsSelect.getInt("grade");

			prepInsert = DBUtil.getPreparedStatement(conn, insertsql);
			prepInsert.setString(1, name);
			prepInsert.setString(2, descr);
			prepInsert.setInt(3, pid);
			prepInsert.setInt(4, 1);
			prepInsert.setInt(5, rsSelectGrade + 1);
			prepInsert.executeUpdate();
			
			conn.commit();
			// 将默认提交方式归还
			conn.setAutoCommit(autoCommit);
/*
			StmtUpdata = DBUtil.getStatement(conn);
			StmtUpdata.executeUpdate(updatasql);
*/
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, StmtSelect, prepInsert, StmtUpdata, rsSelect);
		}

	}
	//查找子类别
	public List<Category> findByPid(Integer id){
		Connection conn=DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Category> cs = null;
		String sql = "select * from t_category where pid="+id;
		conn = DBUtil.getConnection();
		stmt = DBUtil.getStatement(conn);
		rs = DBUtil.getResultSet(stmt, sql);
		cs = new ArrayList<>();
		try {
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName((rs.getString("name")));
				c.setDescr((rs.getString("descr")));
				c.setPid(rs.getInt("pid"));
				c.setLeaf(rs.getInt("leaf") == 1 ? true : false);
				c.setGrade(rs.getInt("grade"));
				cs.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBUtil.close(conn, stmt, rs);
		}

		return cs;
		
	}
	
	
	
	
	
	
	
}
