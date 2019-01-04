package cn.com.kgc.Dao.Impl;

import cn.com.kgc.Dao.BaseDao;
import cn.com.kgc.Dao.SuperAdminDao;
import cn.com.kgc.Pojo.Customer;
import cn.com.kgc.Pojo.Page;
import cn.com.kgc.Pojo.SuperAdmin;
import cn.com.kgc.core.util.PageUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperAdminDaoImpl extends BaseDao implements SuperAdminDao {
    /*
     * 管理员登录
     * */
    public List<SuperAdmin> login(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql, parameter);
        List<SuperAdmin> list = new ArrayList<SuperAdmin>();
        try {
            if (rs.next()) {
                SuperAdmin sa = new SuperAdmin();
                sa.setAdmin(rs.getInt("Admin"));
                sa.setAdminName(rs.getString("AdminName"));
                sa.setAdminPwd(rs.getString("AdminPwd"));
                list.add(sa);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return null;
    }

    /*
     *查询所有用户名
     * */
    public Page<Customer> showUser(int pagesize, int pageNum) {
        Page<Customer> page = new Page<Customer>();
        page.setPageNumber(pageNum);
        page.setPageSize(pagesize);
        String sql = "select count(1) from customer";
        page.setTotalRecod(PageUtil.getTotalRecode(sql, null));

        List<Customer> clist = new ArrayList<Customer>();
        String sql2 = "select * from customer";
        ResultSet res = PageUtil.getPageDate(sql2, pagesize, pageNum, null);
        Customer cus = null;
        try {
            while (res.next()) {
                cus = new Customer(res.getLong(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getString(6),
                        res.getString(7), res.getString(8), res.getString(9),
                        res.getDate(10));
                clist.add(cus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.dbClose();
        }
        page.setPageData(clist);
        return page;

    }

    /*
     * 模糊查询用户
     * */
    public Page<Customer> showUser(int pagesize, int pageNum, String userid, String name, String usersex) {
        Page<Customer> page = new Page<Customer>();
        page.setPageNumber(pageNum);
        page.setPageSize(pagesize);
        ResultSet res = null;
        List<Customer> list = new ArrayList<Customer>();
        //查询共有多少数据
        if (userid != null && usersex != null && name != null) {
            int idsize = userid.length();
            int sexsize = usersex.length();
            int namesize = name.length();
            //都为空查全部
            if (idsize == 0 && sexsize == 0 && namesize == 0) {
                String sql = "select count(1) from customer";
                page.setTotalRecod(PageUtil.getTotalRecode(sql, null));
                String sql2 = "select * from customer";
                res = PageUtil.getPageDate(sql2, pagesize, pageNum, null);
                //查id id为详细查询与名称无关 所以即使填了名字和不会有事
            } else if (idsize > 0 && sexsize == 0) {
                String sql = "select count(1) from customer where id=?";
                Object[] parameter = {userid};
                page.setTotalRecod(PageUtil.getTotalRecode(sql, parameter));
                String sql2 = "select * from customer where id=?";
                res = PageUtil.getPageDate(sql2, pagesize, pageNum, parameter);
                //id 和性别
            } else if (idsize > 0 && sexsize > 0 && namesize == 0) {
                String sql = "select count(1) from customer where id=? and cussex=?";
                Object[] parameter = {userid, usersex};
                page.setTotalRecod(PageUtil.getTotalRecode(sql, parameter));
                String sql2 = "select * from customer where id=? and cussex=?";
                res = PageUtil.getPageDate(sql2, pagesize, pageNum, parameter);
                //id性别和姓名
            } else if (idsize > 0 && sexsize > 0 && namesize > 0) {
                String sql = "select count(1) from customer where id=? and cussex=? and cusname like ?";
                Object[] parameter = {userid, usersex, "%" + name + "%"};
                page.setTotalRecod(PageUtil.getTotalRecode(sql, parameter));
                String sql2 = "select * from customer where id=? and cussex=? and cusname like ?";
                res = PageUtil.getPageDate(sql2, pagesize, pageNum, parameter);
                //性别和姓名
            } else if (idsize == 0 && sexsize > 0 && namesize > 0) {
                String sql = "select count(1) from customer where  cussex=? and cusname like ?";
                Object[] parameter = {usersex, "%" + name + "%"};
                page.setTotalRecod(PageUtil.getTotalRecode(sql, parameter));
                String sql2 = "select * from customer where cussex=? and cusname like ?";
                res = PageUtil.getPageDate(sql2, pagesize, pageNum, parameter);
                //性别
            } else if (idsize == 0 && sexsize > 0 && namesize == 0) {
                String sql = "select count(1) from customer where cussex=?";
                Object[] parameter = {usersex};
                page.setTotalRecod(PageUtil.getTotalRecode(sql, parameter));
                String sql2 = "select * from customer where cussex=?";
                res = PageUtil.getPageDate(sql2, pagesize, pageNum, parameter);
                //姓名
            } else if (idsize == 0 && sexsize == 0 && namesize > 0) {
                String sql = "select count(1) from customer where cusname like ?";
                Object[] parameter = {"%" + name + "%"};
                page.setTotalRecod(PageUtil.getTotalRecode(sql, parameter));
                String sql2 = "select *  from customer where cusname like ?";
                res = PageUtil.getPageDate(sql2, pagesize, pageNum, parameter);
                //性别和姓名
            } else if (idsize == 0 && sexsize > 0 && namesize > 0) {
                String sql = "select count(1) from customer where cussex=? cusname like ?";
                Object[] parameter = {usersex, "%" + name + "%"};
                page.setTotalRecod(PageUtil.getTotalRecode(sql, parameter));
                String sql2 = "select *  from customer where cussex=? cusname like ?";
                res = PageUtil.getPageDate(sql2, pagesize, pageNum, parameter);
            }
        }
        Customer cus = null;try {
            while (res.next()) {
                cus = new Customer(res.getLong(1), res.getString(2), res.getString(3),
                        res.getString(4), res.getString(5), res.getString(6),
                        res.getString(7), res.getString(8), res.getString(9),
                        res.getDate(10));
                list.add(cus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.dbClose();
        }
        page.setPageData(list);
        return page;
    }
    /*
     * 删除用户
     * */
    public boolean DelUser(long id) {
        String sql = "delete from customer where id=?";
        Object[] parameter = {id};
        int i = -1;
        i = BaseDao.getUpdate(sql, parameter);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * 添加用户
     * */
    public boolean AddUser(Customer cust) {

        String sql = "insert into Customer values(null,?,?,?,?,?,?,?,?,?)";
        Object[] parameter = {cust.getCusName(), cust.getCusLoginName(), cust.getCusPassword(), cust.getCusEmail(), cust.getCusSex(), cust.getCusPhoto(), cust.getCusHobby(), cust.getCusCode(), cust.getCusBirthday(), cust.getId()
        };
        int i = -1;
        i = BaseDao.getUpdate(sql, parameter);
        if (i > 0) {
            return true;
        }
        return false;
    }

    /*
     * 更新用户
     * */
    public boolean UpdataUser(Customer cust) {
        String sql = "updata  Customer set cusName=?,cusloginname=?,cusPassword=?,cusEmail=?,cusSex=?,cusPhoto=?,cusHobby=?,cusCode=?,cusBirthday=?   where id=?";
        Object[] parameter = {cust.getId(),cust.getCusName(), cust.getCusLoginName(), cust.getCusPassword(), cust.getCusEmail(), cust.getCusSex(), cust.getCusPhoto(), cust.getCusHobby(), cust.getCusCode(), cust.getCusBirthday()};
        int i = -1;
        i = BaseDao.getUpdate(sql, parameter);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public List<Customer> query(String sql, Object[] parameter) {
        ResultSet rs = getQuery(sql, parameter);
        List<Customer> stuList = new ArrayList<Customer>();
        try {
            while (rs.next()) {
                Customer cus = new Customer();
                cus.setId(rs.getLong("Id"));
                cus.setCusName(rs.getString("CusName"));
                cus.setCusLoginName(rs.getString("CusLoginName"));
                cus.setCusSex(rs.getString("CusSex"));
                cus.setCusBirthday(rs.getDate("CusBirthday"));
                cus.setCusCode(rs.getString("CusCode"));
                cus.setCusEmail(rs.getString("CusEmail"));
                cus.setCusHobby(rs.getString("CusHobby"));
                cus.setCusPassword(rs.getString("CusPassword"));
                stuList.add(cus);
            }
            return stuList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return null;
    }
}
