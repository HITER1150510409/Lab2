package com.ANT.Library.Implment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ANT.Library.Interface.AbstractDAOImpl;
import com.ANT.Library.Interface.IBooksDAO;

public class BooksDAOImpl extends AbstractDAOImpl implements IBooksDAO {
    public BooksDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Books vo) throws SQLException {
        String sql = "INSERT INTO books(isbn,aid,name,credate,status,note,publisher,price)VALUES(?,?,?,?,?,?,?,?)";
        System.out.println(vo.getIsbn()+" "+vo.getAuthor().getAid()+" "+vo.getName()+" "+vo.getCredate()+" "+vo.getStatus()+" "+vo.getNote()+
        		" "+vo.getPublisher()+" "+vo.getPrice());
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getIsbn());
        super.pstmt.setString(2,vo.getAuthor().getAid());
        super.pstmt.setString(3,vo.getName());
        super.pstmt.setString(4, vo.getCredate());
        super.pstmt.setInt(5,vo.getStatus());
        super.pstmt.setString(6,vo.getNote());
        super.pstmt.setString(7,vo.getPublisher());
        super.pstmt.setString(8,vo.getPrice());
        return super.pstmt.executeUpdate() > 0;
    }
    @Override
    public boolean doUpdate(Books vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Books findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Books> findAll() throws SQLException 
    {
        List<Books> all = new ArrayList<Books>();
    	String sql = "SELECT isbn,name,credate,status,note,publisher,price FROM books";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while(rs.next())
        {
        	Books bo = new Books();
        	bo.setIsbn(rs.getString(1));
        	bo.setName(rs.getString(2));
        	bo.setCredate(rs.getString(3));
        	bo.setStatus(rs.getInt(4));
        	bo.setNote(rs.getString(5));
        	bo.setPublisher(rs.getString(6));
        	bo.setPrice(rs.getString(7));
        	all.add(bo);
        }
        return all;
    }

    //根据书的名字查找某本书的信息。
    public Books show(String name) throws SQLException
    {
    	String sql =" SELECT isbn,aid,name,credate,status,publisher,price " + " FROM books " + " WHERE name = ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,name);
        ResultSet rs = super.pstmt.executeQuery();
        Books bo = new Books();
        if (rs.next()){
        	bo.setIsbn(rs.getString(1));
        	bo.setName(rs.getString(3));
        	bo.setCredate(rs.getString(4));
        	bo.setStatus(rs.getInt(5));
        	bo.setPublisher(rs.getString(6));
        	bo.setPrice(rs.getString(7));
        	Author author = new Author();
        	author.setAid(rs.getString(2));
        	bo.setAuthor(author);
        }
        return bo;
    }
    
    @Override
    public List<Books> findAllBooksByAid(String aid) throws SQLException
    {
    	List<Books> all = new ArrayList<Books>();
    	String sql =" SELECT isbn,name,credate,publisher,price FROM books WHERE aid = ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, aid);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
        	Books bo = new Books();
        	bo.setIsbn(rs.getString(1));
        	bo.setName(rs.getString(2));
        	bo.setCredate(rs.getString(3));
        	bo.setPublisher(rs.getString(4));
        	bo.setPrice(rs.getString(5));
        	all.add(bo);
        }
    	return all;
    }

	@Override
	public String findAidByBookName(String name) throws SQLException {
		String sql =" SELECT aid FROM books WHERE name = ?";
		super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, name);
        ResultSet rs = super.pstmt.executeQuery();
        String aid;
        if(rs.next())
        {
        	aid = rs.getString(1);
        	return aid;
        }
        return null;
	}

	@Override
	public List<Books> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		return null;
	}

	@Override
	public boolean deleteByBookName(String name) throws SQLException {
		String sql = "DELETE from books where name = ?";
		super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, name);
        return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean update(Books bo) throws SQLException {
		String sql = "UPDATE books SET aid=?,publisher=?,credate=?,price=? WHERE name=?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, bo.getAuthor().getAid());
		super.pstmt.setString(2, bo.getPublisher());
		super.pstmt.setString(3, bo.getCredate());
		super.pstmt.setString(4, bo.getPrice());
		super.pstmt.setString(5, bo.getName());
		return super.pstmt.executeUpdate() > 0;
	}
}

