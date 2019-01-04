package cn.com.kgc.Servise.Impl;

import cn.com.kgc.Dao.Impl.SuperAdminDaoImpl;
import cn.com.kgc.Pojo.Customer;
import cn.com.kgc.Pojo.Page;
import cn.com.kgc.Pojo.SuperAdmin;
import cn.com.kgc.Servise.SuperAdminServiseDao;

import java.util.List;

public class SuperAdminServiseDaoImpl implements SuperAdminServiseDao {
    private static SuperAdminServiseDaoImpl ourInstance = new SuperAdminServiseDaoImpl();

    public static SuperAdminServiseDaoImpl getInstance() {
        return ourInstance;
    }

    public SuperAdminServiseDaoImpl() {
    }

    //获取StudentImplDao对象
    private SuperAdminDaoImpl supDao = new SuperAdminDaoImpl();

    public SuperAdmin login(String name, String pwd) {
        String sql = "select * from superadmin where AdminName = ? and AdminPwd = ?";
        Object[] parameter = {name, pwd};
        List<SuperAdmin> supList = supDao.login(sql, parameter);
        if (supList != null && supList.size() > 0) {
            return supList.get(0);
        }
        return null;
    }

    public Page<Customer> showUser(int pagesize, int pageNum) {
        return supDao.showUser(pagesize,pageNum);
    }

    public Page<Customer> showUser(int pagesize, int pageNum, String userid, String name, String usersex) {

        return supDao.showUser(pagesize, pageNum, userid, name, usersex);
    }

    public boolean DelUser(long id) {
        return supDao.DelUser(id);
    }

    public boolean AddUser(Customer cust) {
        return supDao.AddUser(cust);
    }

    public boolean UpdataUser(Customer cust) {
        return supDao.UpdataUser(cust);
    }

    public Customer cusQueryById(String Id) {
        String sql = "select * from customer where id = ?";
        Object[] parameter = {Id};
        List<Customer> stuList = supDao.query(sql, parameter);
        if (stuList != null && stuList.size() > 0) {
            return stuList.get(0);
        }
        return null;
    }
}
