package com.ANT.Library.Implment;

import java.util.List;

import com.ANT.Library.DAOFactory.DAOFactory;
import com.ANT.Library.Interface.IAuthorService;
import com.ANT.Library.util.DatabaseConnection;

public class AuthorServiceImpl implements IAuthorService {
    private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean insert(Author ao) throws Exception {
		try{
            // 表示mid数据不存在
            if(DAOFactory.getIAuthorDAOInstance(this.dbc.getConn()).findById(ao.getAid()) == null){
                return DAOFactory.getIAuthorDAOInstance(this.dbc.getConn()).doCreate(ao);
            }
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return false;
	}

	@Override
	public List<Author> list() throws Exception {
		try
		{
			return DAOFactory.getIAuthorDAOInstance(this.dbc.getConn()).findAll();
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
	public boolean remove(Author ao) throws Exception {
		return false;
	}

	@Override
	public boolean change(Author ao) throws Exception {
		return false;
	}

	@Override
	public Author findAuthorInfoByAuthorId(String aid) throws Exception {
		try
		{
			return DAOFactory.getIAuthorDAOInstance(this.dbc.getConn()).findByAid(aid);
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
	public String name2Id(String name) throws Exception {
		try
		{
			System.out.println(name);
			return DAOFactory.getIAuthorDAOInstance(this.dbc.getConn()).name2Id(name);
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
}


