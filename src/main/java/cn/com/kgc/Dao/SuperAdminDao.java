package cn.com.kgc.Dao;

import cn.com.kgc.Pojo.Customer;
import cn.com.kgc.Pojo.Page;
import cn.com.kgc.Pojo.SuperAdmin;

import java.util.List;

public interface SuperAdminDao {
    //登录
    List<SuperAdmin> login(String sql, Object[] parameter);

    //查询用户
    Page<Customer> showUser(int pagesize, int pageNum);

    //模糊查询用户
    Page<Customer> showUser(int pagesize, int pageNum, String userid, String name, String usersex);

    //删除
    boolean DelUser(long id);

    //添加
    boolean AddUser(Customer cust);

    //更新用户数据
    boolean UpdataUser(Customer cust);

    List<Customer> query(String sql, Object[] parameter);
}
