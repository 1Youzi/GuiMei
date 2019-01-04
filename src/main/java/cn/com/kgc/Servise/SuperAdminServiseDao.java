package cn.com.kgc.Servise;

import cn.com.kgc.Pojo.Customer;
import cn.com.kgc.Pojo.Page;
import cn.com.kgc.Pojo.SuperAdmin;

public interface SuperAdminServiseDao {
    //登录
    SuperAdmin login(String name, String pwd);

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

    //根据id查询
    Customer cusQueryById(String Id);
}
