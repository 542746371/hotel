package edu.dali.hotel.controller;
import edu.dali.hotel.dao.OrderMapper;
import edu.dali.hotel.model.Order;
import edu.dali.hotel.model.Room;
import edu.dali.hotel.service.OrderService;
import edu.dali.hotel.service.RoomService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/order/*")
public class OrderController {
    @Autowired
    OrderService orderService ;
    @Autowired
    RoomService roomService;


    /**
     * 1.判断登录情况:通过session查看
     * 2.获取请求的房型ids：通过request 获取
     * 3.roomids->rooms：通过roomService 获取
     * 4.
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("/info")
    public String getOrderInfo(ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){return "login";}
        List<Room> roomList;
        Order order = new Order();
        //获取请求的房型ids
        roomList = new ArrayList<>();
        String[] roomArray=request.getParameterValues("rooms");
        if(roomArray == null){      //空则返回
            return "redirect:/room/list";
        }

        //roomids->rooms

        for (int i = 0 ; i <roomArray.length;i++) {
            int rid = Integer.valueOf(roomArray[i]);
                 Room r = roomService.getRoomById(rid);//查找room
            roomList.add(r);
        }

        //添加跳转信息并返回
        modelMap.addAttribute("ordRoomList", roomList);
        session.setAttribute("ordRoomList", roomList);
        return "orderinfo";
    }

    @RequestMapping("/su")
    public String getOrdersu(ModelMap modelMap, HttpServletRequest request) {

        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){return "login";}


        //联系人

        //查找未使用过的id
        int id =orderService.MaxOrderId() + 1;

        Order order = new Order();
        //添加
        order.setId(id);
        order.setName(request.getParameter("xingming"));
        order.setbTime(request.getParameter("daoda"));
        order.setaTime(request.getParameter("lidian"));
        order.setPhone(request.getParameter("shouji"));
        order.setOldPhone(request.getParameter("guhua"));
        order.setEmail(request.getParameter("mail"));
        //添加到order表
        orderService.orderInsert(order.getId(), order.getName(), order.getbTime(), order.getaTime(),
                order.getPhone(), order.getOldPhone(), order.getEmail());
        int sum = 0;        //金额

        String[] roomnums = request.getParameterValues("roomnum");//数量
        List<Room> roomList = (List<Room>) session.getAttribute("ordRoomList");
        List<String> nums = new ArrayList<>();
        HashMap<String, Room> hashMap = new HashMap<>();

        for (int i = 0; i < roomList.size(); i++) {
            sum += (roomList.get(i).getSubprice() * Integer.valueOf(roomnums[i]));
            nums.add(roomnums[i]);
            //添加订单-房间到数据库
            orderService.orderRoomInsert(order.getId(), String.valueOf(roomList.get(i).getId()), roomnums[i]);

        }
        //添加rodrooms
        order.setOrdnums(nums);         //数量
        order.setOrdrooms(roomList);    //对应房间
        request.setAttribute("sum", sum);
        request.setAttribute("order", order);
        return "order-success";
    }
}

//        @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("Order控制");
//        String url = request.getRequestURI().toString();
//        request.setCharacterEncoding("UTF-8");
//        HttpSession session = request.getSession();
//        String userId= (String) session.getAttribute("id");
////        System.out.println(session.getId());
////        System.out.println(userId);
//        //查看登录信息
//        if(userId==null||userId.equals("")){
//            request.getRequestDispatcher("/login.html").forward(request,response);
//        }
//
//
//        //判断跳转页面
//        if(url.indexOf("info")>0){
//
//            //获取请求的房型ids
//            roomList = new ArrayList<>();
//            String[] roomArray=request.getParameterValues("rooms");
//            if(roomArray == null){      //空则返回
//                request.getRequestDispatcher("../RoomList.jsp").forward(request,response);
//            }
//
//            //roomids->rooms
//
//            for (int i = 0 ; i <roomArray.length;i++) {
//                int rid = Integer.valueOf(roomArray[i]);
//           //     Room r = roomService.getRoomById(rid);//查找room
//                roomList.add(r);
//            }
//            session.setAttribute("ordRoomList", roomList);
//            request.getRequestDispatcher("../orderinfo.jsp").forward(request,response);
//        }
//        else if(url.indexOf("su")>0){
//            System.out.println("su-servlet");
//            //联系人
//            OrderService orderService = new OrderService();
//            int id = Integer.parseInt(orderService.MaxOrderId())+1;
//
//
//            //添加
//            order.setId(String.valueOf(id));
//            order.setName(request.getParameter("xingming"));
//            order.setbTime(request.getParameter("daoda"));
//            order.setaTime(request.getParameter("lidian"));
//            order.setPhone(request.getParameter("shouji"));
//            order.setOldPhone(request.getParameter("guhua"));
//            order.setEmail(request.getParameter("mail"));
//            //添加到order表
//            orderService.orderInsert(Integer.parseInt(order.getId()),order.getName(),order.getbTime(),order.getaTime(),
//                    order.getPhone(),order.getOldPhone(),order.getEmail());
//            int sum = 0;        //金额
//            String[] roomnums = request.getParameterValues("roomnum");//数量
//            List<Room> roomList = (List<Room>) session.getAttribute("ordRoomList");
//            List<String> nums = new ArrayList<>();
//            HashMap<String,Room> hashMap = new HashMap<>();
//
//            System.out.println("roomList.size()"+roomnums.length+"  "+roomList.size());
//            for (int i = 0 ; i <roomList.size();i++) {
//                sum+=(roomList.get(i).getSubprice()*Integer.valueOf(roomnums[i]));
//                nums.add(roomnums[i]);
//                //添加到数据库
//                orderService.orderRoomInsert(order.getId(), String.valueOf(roomList.get(i).getId()), roomnums[i]);
//
//            }
//            //添加rodrooms
//            order.setOrdnums(nums);         //数量
//            order.setOrdrooms(roomList);    //对应房间
//            request.setAttribute("sum", sum);
//            request.setAttribute("order", order);
//            request.getRequestDispatcher("../order-success.jsp").forward(request,response);
//
//        }else
//        {
//            request.getRequestDispatcher("../order-failure.jsp").forward(request,response);
//        }


//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }

