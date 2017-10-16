package com.ANT.Library.Implment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ANT.Library.Interface.AbstractDAOImpl;
import com.ANT.Library.Interface.IAuthorDAO;

public class AuthorDAOImpl extends AbstractDAOImpl implements IAuthorDAO {
    public AuthorDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public Author findAuthorInfoByName(Author vo) throws SQLException {
        Author ao = null;
        String sql = "SELECT aid,name,age,country FROM author WHERE name=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getName());
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
        	ao = new Author();
        	ao.setAid(rs.getString(1));
        	ao.setName(rs.getString(2));
        	ao.setAge(rs.getString(3));
        	ao.setCountry(rs.getString(4));
        	
        }
        return ao;
    }
    @Override
    public boolean doCreate(Author vo) throws SQLException {
        String sql = "INSERT INTO author(aid,name,age,country) VALUES(?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getAid());
        super.pstmt.setString(2,vo.getName());
        super.pstmt.setString(3,vo.getAge());
        super.pstmt.setString(4,vo.getCountry());
        return super.pstmt.executeUpdate() > 0;		
    }

	@Override
	public boolean doUpdate(Author vo) throws SQLException {
		return false;
	}

	@Override
	public boolean doRemove(Set<?> ids) throws SQLException {
		return false;
	}

	@Override
	public boolean doDelete(Author ao) throws SQLException {
		String sql = "DELETE FROM author WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,ao.getAid());
        return super.pstmt.executeUpdate() > 0;	
	}

	@Override
	public Author findById(String id) throws SQLException {
		Author ao = null;
        String sql  = "SELECT aid,name,age,country FROM author WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
        	ao = new Author();
            ao.setAid(rs.getString(1));
            ao.setName(rs.getString(2));
            ao.setAge(rs.getString(3));
            ao.setCountry(rs.getString(4));
        }
        return ao;
	}

	@Override
	public List<Author> findAll() throws SQLException 
	{
		Author ao = null;
		List<Author> all = new ArrayList<Author>();
		String sql  = "SELECT name FROM author";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next())
        {
        	ao = new Author();
        	ao.setName(rs.getString(1));
        	all.add(ao);
        }
        return all;
	}

	@Override
	public List<Author> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return null;
	}

	@Override
	public boolean doChange(Author ao) throws SQLException {
		String sql = "UPDATE author SET name=?,age=?,country=? WHERE aid=? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,ao.getName());
        super.pstmt.setString(2,ao.getAge());
        super.pstmt.setString(3,ao.getCountry());
        super.pstmt.setString(4,ao.getAid());
        return super.pstmt.executeUpdate() > 0;	
	}

	@Override
	public String name2Id(String name) throws SQLException {
		String sql = "SELECT aid FROM author WHERE name = ? ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1,name);
		ResultSet rs = super.pstmt.executeQuery();
		if(rs.next())
		{
			return rs.getString(1);
		}
		return null;
	}

	@Override
	public Author findByAid(String aid) throws SQLException {
		Author ao = null;
        String sql = "SELECT aid,name,age,country FROM author WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,aid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
        	ao = new Author();
        	ao.setAid(rs.getString(1));
        	ao.setName(rs.getString(2));
        	ao.setAge(rs.getString(3));
        	ao.setCountry(rs.getString(4));      	
        }
        return ao;
	}

}

