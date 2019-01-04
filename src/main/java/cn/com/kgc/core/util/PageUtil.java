package cn.com.kgc.core.util;

import cn.com.kgc.Dao.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PageUtil extends BaseDao {

    public static int getTotalRecode(String sql,Object []parameter){
        int totalRecode = 0;
        ResultSet rs  = getQuery(sql,parameter);
        try {
            if(rs.next()){
                totalRecode = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return totalRecode;
    }

    public static ResultSet getPageDate(String sql,int pageSize,int pageNumber,Object []parameter){
        int index =  (pageNumber-1)*pageSize;
        sql = sql+" limit "+index+","+pageSize;
        ResultSet rs = getQuery(sql,parameter);
        return  rs;
    }
}
