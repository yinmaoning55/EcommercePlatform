package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.CartItemDAO;
import pojo.CartItem;
import pojo.Product;
import util.DBUtil;

public class CartItemDAOimpl implements CartItemDAO {

	public void add(CartItem ci) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep = null;
		String sql = "insert into t_salesitem values(null,?,?,?,?)";
		prep = DBUtil.getPreparedStatement(conn, sql);
		

		try {
			boolean autoCommit = conn.getAutoCommit();
			// 2.将默认提交方式设置为手动提交
			conn.setAutoCommit(false);
			prep.setObject(1,ci.getProduct().getId());
			prep.setObject(2,ci.getProduct().getNormalprice());
			prep.setObject(3,ci.getPcount());
			
			prep.setObject(4,0);
			
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
	
	
	public List<CartItem> findAll(){
		Statement stmt = null;
		ResultSet rs = null;
		List<CartItem> CartItem = null;
		String sql = "select p.id, p.name ,p.descr,p.normalprice,p.memberprice ,p.categoryid,p.pdata ,"+"c.id,c.productid ,c.unitprice,c.pcount,c.orderid from t_salesitem c JOIN t_product p on p.id = c.productid";
		Connection conn = DBUtil.getConnection();
		stmt = DBUtil.getStatement(conn);
		rs = DBUtil.getResultSet(stmt, sql);
		CartItem = new ArrayList<>();

		try {
			while (rs.next()) {
				CartItem c = new CartItem();
				c.setId(rs.getInt("c.id"));			
				c.setPcount(rs.getInt("c.pcount"));
				c.setOrderid(rs.getInt("c.orderid"));
				c.setUnitprice(rs.getInt("c.unitprice"));
				
				Product p=new Product();
				p.setId(rs.getInt("p.id"));
				p.setName(rs.getString("p.name"));
				p.setDescr(rs.getString("p.descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
				p.setPdata(rs.getTimestamp("pdata"));
				c.setProduct(p);
			
				
				CartItem.add(c);
				
				
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, stmt, rs);
		}

		return  CartItem;
	}


	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	public void delete(Integer id) {
		Connection conn=DBUtil.getConnection();
		PreparedStatement prep = null;
		String sql = "delete from t_salesitem where id=?";
		prep = DBUtil.getPreparedStatement(conn, sql);
		try {
			prep.setObject(1, id);
			prep.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, prep);
		}

	}
}
