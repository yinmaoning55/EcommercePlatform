package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dao.ProductDAO;
import pojo.Admin;
import pojo.Category;
import pojo.Product;
import pojo.User;
import util.DBUtil;

public class ProductDAOimpl implements ProductDAO {
	public Connection conn=null;
	@Override
	public List<Product> findAll() {
		
		Statement stmt = null;
		ResultSet rs = null;
		List<Product> products = null;
		String sql = "select p.id, p.name ,p.descr,p.normalprice,p.memberprice ,p.categoryid,p.pdata ,"+"c.id,c.name ,c.descr,c.pid,c.leaf,c.grade from t_product p JOIN t_category c on p.categoryid = c.id";
		conn = DBUtil.getConnection();
		stmt = DBUtil.getStatement(conn);
		rs = DBUtil.getResultSet(stmt, sql);
		products = new ArrayList<>();

		try {
			while (rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt("p.id"));
				p.setName(rs.getString("p.name"));
				p.setDescr(rs.getString("p.descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
			    p.setPdata(rs.getTimestamp("pdata"));
			    
			    Category c=new Category(); 
			    c.setId(rs.getInt("c.id"));	    
				c.setName((rs.getString("c.name")));
				c.setDescr((rs.getString("c.descr")));
				c.setPid(rs.getInt("pid"));
				c.setLeaf(rs.getInt("leaf") == 1 ? true : false);
				c.setGrade(rs.getInt("grade"));
			    p.setCategory(c);
				
				
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, stmt, rs);
		}

		return products;
	}

	@Override
	public void add(Product p) {
		
			conn = DBUtil.getConnection();
			PreparedStatement prep = null;
			String sql = "insert into t_product values(null,?,?,?,?,now(),?)";
			prep = DBUtil.getPreparedStatement(conn, sql);
			

			try {
				boolean autoCommit = conn.getAutoCommit();
				// 2.将默认提交方式设置为手动提交
				conn.setAutoCommit(false);
				prep.setObject(1,p.getName());
				prep.setObject(2,p.getDescr());
				prep.setObject(3,p.getNormalprice());
				
				prep.setObject(4,p.getMemberprice());
				prep.setObject(5,p.getCategory().getId());
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
	

	@Override
	public Product findById(Integer id) {
		Statement stmt=null;
		ResultSet rs=null;
		Product p=null;
		String sql="select p.id, p.name ,p.descr,p.normalprice,p.memberprice ,p.categoryid,p.pdata ,"
		+"c.id,c.name ,c.descr,c.pid,c.leaf,c.grade "
		+ "from t_product p "
		+ "JOIN t_category c "
		+ "on p.categoryid = c.id "
		+"where p.id="+id;
		conn=DBUtil.getConnection();
		stmt=DBUtil.getStatement(conn);
		rs=DBUtil.getResultSet(stmt, sql);
		
		try{
			if(rs.next()){
				 p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
				p.setPdata(rs.getTimestamp("pdata"));
				
				Category c=new Category(); 
			    c.setId(rs.getInt("c.id"));	    
				c.setName((rs.getString("c.name")));
				c.setDescr((rs.getString("c.descr")));
				c.setPid(rs.getInt("pid"));
				c.setLeaf(rs.getInt("leaf") == 1 ? true : false);
				c.setGrade(rs.getInt("grade"));
			    p.setCategory(c);
				
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			DBUtil.close(conn, stmt,rs);
		}
		
				
				
		return p;
	}

	@Override
	public void updata(Product p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 最新商品显示
	 */
	public List<Product> lastProduct(int pageNo){
		Statement stmt = null;
		ResultSet rs = null;
		List<Product> products = null;
		String sql="select p.id,p.name,p.descr,p.normalprice,p.memberprice,p.pdata,p.categoryid,"
				+"c.id,c.name,c.descr,c.pid,c.leaf,c.grade from t_product p join "+
				"t_category c on p.categoryid=c.id  "
				+"order by p.pdata desc limit "+(pageNo-1)*4+",4";
		conn = DBUtil.getConnection();
		stmt = DBUtil.getStatement(conn);
		rs = DBUtil.getResultSet(stmt, sql);
		products = new ArrayList<>();

		try {
			while (rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
				p.setPdata(rs.getTimestamp("pdata"));
				Category c=new Category();
				c.setId(rs.getInt("c.id"));
				c.setName((rs.getString("c.name")));
				c.setDescr((rs.getString("c.descr")));
				c.setPid(rs.getInt("pid"));
				c.setLeaf(rs.getInt("leaf") == 1 ? true : false);
				c.setGrade(rs.getInt("grade"));
				p.setCategory(c);
				
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, stmt,rs);
		}

		return products;
		
	}
	

}
