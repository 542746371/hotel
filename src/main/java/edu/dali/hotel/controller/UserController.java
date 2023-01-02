package edu.dali.hotel.controller;

import edu.dali.hotel.dao.UserMapper;
import edu.dali.hotel.model.Room;
import edu.dali.hotel.model.User;
import edu.dali.hotel.service.RoomService;
import edu.dali.hotel.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping("/user/*")
public class UserController {   // extends HttpServlet


    @Autowired
    UserService userService;

    /**
     * 首页index跳转login
     * @return
     */
    @RequestMapping("/index")
    public  String getLogin(){
        return "login";
    }

    /**
     * 首页跳转注册
     * @return
     */
    @RequestMapping("/register")
    public  String getRegister(){
        return "register";
    }

    /**
     * 在数据库中添加一个新的用户，并跳转login
     * @param user
     * @return
     */
    @RequestMapping("/registerAfter")
    public  String getRegisterAfter(User user){
       userService.userInsert(user);

       return "redirect:/user/index";
    }

    /**
     * 判断是否登录正确，不正确则跳转回login，正确跳转room/list
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public  String ifLogin(HttpServletRequest request){

        String userid = request.getParameter("id");
        String password = request.getParameter("password");
        User user = userService.selectUserByid(userid, password);
        if(user==null)return "login";
        else{
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/room/list";

        }
    }




//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("User控制");
//        String url = req.getRequestURI().toString();
//        req.setCharacterEncoding("UTF-8");
//        System.out.println(url);
//
//
//
//        if (url.equals("/hotel/User/login")) { //有这字符串,是登录
////            req.getRequestDispatcher("/room/getAll").forward(req, resp);
//            String user = req.getParameter("id");
//            String password = req.getParameter("password");
//            System.out.println(user + "   " + password);
//            //查看登录信息
//            try {

//                User user1 = userDao.selectUserByid(user, password);
//                if (user1 == null) {//跳转原来要求的界面
//                    System.out.println("失败，跳转回登录页面");
//                    req.getRequestDispatcher("/login.html").forward(req, resp);
//                } else {
//
//                    HttpSession session =     req.getSession();
//                    session.setAttribute("id", user);
//                    session.setAttribute("username",user1.getName());
//                    session.setAttribute("password", password);
//                    System.out.println(session.getId());
//                    resp.sendRedirect("../room/getAll");
//                }
//            } catch (SQLException e) {
//                System.out.println("登录失败");
//
//            }
//        }else if(url.equals("/hotel/User/register")){
//            req.getRequestDispatcher("/register.html").forward(req, resp);
//        }
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req,resp);
//    }
}
