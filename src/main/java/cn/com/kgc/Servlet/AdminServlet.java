package cn.com.kgc.Servlet;

import cn.com.kgc.Pojo.Customer;
import cn.com.kgc.Pojo.Page;
import cn.com.kgc.Pojo.SuperAdmin;
import cn.com.kgc.Servise.Impl.SuperAdminServiseDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "AdminServlet", urlPatterns = "/doadmin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码方式统一操作
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取输入流对象
        PrintWriter out = response.getWriter();
        //获取path路径
        String path = request.getContextPath();
        //获取session对象
        HttpSession session = request.getSession();
        //获取参数action的值
        String action = request.getParameter("action");
        //创建管理员服务对象
        SuperAdminServiseDaoImpl sasd = new SuperAdminServiseDaoImpl();
        /*
         * 管理员登录
         * */
        if (action != null && action.equals("UserLogin")) {
            String name = request.getParameter("AdminName");
            String pwd = request.getParameter("AdminPwd");
            SuperAdmin admin = sasd.login(name, pwd);
            if (admin != null) {
                session.setAttribute("SuperAdmin", admin);
                response.sendRedirect(path + "page/index.jsp");
            } else {
                response.sendRedirect(path + "Login.jsp");
            }
        }
        //获取所有用户数据并返回
        if (action != null && action.equals("unionQuery")) {
            //定义每页显示的页数
            int pagesize = 6;
            //页码
            int pagenum = Integer.parseInt(request.getParameter("pageNumber"));
            Page<Customer> page = sasd.showUser(pagesize, pagenum);
            session.setAttribute("page", page);
            request.getRequestDispatcher("/page/showCustomer.jsp").forward(request, response);
        }

        /*
        * 模糊查询
        * */
        if (action != null && action.equals("FuzzyQuery")) {
            //定义每页显示的页数z'z'z'z'z'z'z'z'z'z'z'z'z'z'z'z'z'z'z
            int pagesize = 6;
            //页码
            int pagenum = Integer.parseInt(request.getParameter("pageNumber"));
            //获取查询信息
            String userName = request.getParameter("username").trim();
            String userid=request.getParameter("userid").trim();
            String usersex=request.getParameter("usersex");
            System.out.println(userName+":"+userid+":"+usersex);
            Page<Customer> page = sasd.showUser(pagesize, pagenum,userid,userName,usersex);
            session.setAttribute("page", page);
            request.setAttribute("userid",userid);
            request.setAttribute("userName",userName);
            request.setAttribute("usersex",usersex);
            request.getRequestDispatcher("/page/showCustomer.jsp").forward(request, response);
        }

        //删除用户
        if (action != null && action.equals("delUser")) {
            Long id = Long.parseLong(request.getParameter("id"));
            if (sasd.DelUser(id)) {
                System.out.println("删除成功");
                response.sendRedirect("doadmin?action=unionQuery&pageNumber=1");
            } else {
                System.out.println("删除失败");
                response.sendRedirect("doadmin?action=unionQuery&pageNumber=1");
            }
        }
        //根据ID查询用户
        if (action != null && action.equals("queryById")) {
            String stuId = request.getParameter("id");
            Customer cus = sasd.cusQueryById(stuId);
            if (cus != null) {
                session.setAttribute("Customer", cus);
                response.sendRedirect(path + "page/ShowUpdateUser.jsp");
            }
        }
        //修改用户
        if (action != null && action.equals("updataUser")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("name");
            String logiNname = request.getParameter("loginName");
            String pwd = request.getParameter("pwd");
            String email = request.getParameter("email");
            String sex = request.getParameter("sex");
            String hobby = request.getParameter("hobby");
            String code = request.getParameter("code");
            String birth = request.getParameter("birth");
            Customer cus = new Customer(id, name, logiNname, pwd, email, sex, null, hobby, code, Date.valueOf(birth));
            if (sasd.UpdataUser(cus)) {
                System.out.println("修改成功");
                response.sendRedirect("doadmin?action=unionQuery&pageNumber=1");
            } else {
                System.out.println("修改失败");
                response.sendRedirect("doadmin?action=unionQuery&pageNumber=1");
            }
        }
        //添加用户
        if (action != null && action.equals("adduser")) {
            response.sendRedirect("page/AddCoutomer.jsp");
        }
        if (action != null && action.equals("addCustomer")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("name");
            String logiNname = request.getParameter("loginName");
            String pwd = request.getParameter("pwd");
            String email = request.getParameter("email");
            String sex = request.getParameter("sex");
            String hobby = request.getParameter("hobby");
            String code = request.getParameter("code");
            String birth = request.getParameter("birth");
            Customer cus = new Customer(id, name, logiNname, pwd, email, sex, null, hobby, code, Date.valueOf(birth));
            if (sasd.AddUser(cus)) {
                System.out.println("添加成功");
                response.sendRedirect("doadmin?action=unionQuery&pageNumber=1");
            } else {
                System.out.println("添加失败");
                response.sendRedirect("doadmin?action=unionQuery&pageNumber=1");
            }
        }

    }
}
