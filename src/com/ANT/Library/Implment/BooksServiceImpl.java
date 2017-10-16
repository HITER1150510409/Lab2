package com.ANT.Library.Implment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ANT.Library.DAOFactory.DAOFactory;
import com.ANT.Library.Interface.IBooksService;
import com.ANT.Library.util.DatabaseConnection;

public class BooksServiceImpl implements  IBooksService {
    private DatabaseConnection dbc  =new DatabaseConnection();
    @Override
    public boolean insert(Books vo) throws Exception {
        try{
            return DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).doCreate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Books> list() throws Exception 
    {
        List<Books> all;
        try
        {
        	all = DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).findAll();
        	return all;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally 
        {
            this.dbc.close();
        }
        return null;
    }
	@Override
	public List<Books> findAllBooksByAuthorName(String name) throws Exception {
		try
		{
			String aid = DAOFactory.getIAuthorDAOInstance(this.dbc.getConn()).name2Id(name);
			return DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).findAllBooksByAid(aid);
		}catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
	}
	@Override
	public Books findInfoByBookName(String name) throws Exception {
		try
		{
			Books bo = DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).show(name);
			String aid = bo.getAuthor().getAid();
			Author ao = DAOFactory.getIAuthorDAOInstance(this.dbc.getConn()).findByAid(aid);
			bo.setAuthor(ao);
			return bo;
		}
		catch (Exception e)
		{
            throw e;
        }
		finally 
		{
            this.dbc.close();
        }
	}
	@Override
	public String findAidByBookName(String name) throws Exception {
		try
		{
			String aid = DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).findAidByBookName(name);
			return aid;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
            this.dbc.close();
        }
		return null;
	}

	@Override
	public boolean deleteByBookName(String name) throws Exception {
		try
		{
			return DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).deleteByBookName(name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
            this.dbc.close();
        }
		return false;
	}

	@Override
	public boolean update(Books bo) throws Exception {
		try
		{
			return DAOFactory.getIBooksDAOInstance(this.dbc.getConn()).update(bo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.dbc.close();
		}
		return false;
	}
    
}

