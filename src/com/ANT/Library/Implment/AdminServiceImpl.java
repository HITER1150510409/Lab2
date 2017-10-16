package com.ANT.Library.Implment;

import com.ANT.Library.DAOFactory.DAOFactory;
import com.ANT.Library.Interface.IAdminService;
import com.ANT.Library.util.DatabaseConnection;

public class AdminServiceImpl implements IAdminService {
    private DatabaseConnection dbc = new DatabaseConnection();
    @Override
    public boolean login(Admin vo) throws Exception {
        try{
            if(DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).findLogin(vo)){
                return DAOFactory.getIAdminDAOInstance(this.dbc.getConn()).doUpdateByLastDate(vo.getAid());
            }
           return false;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }
}


