package edu.dali.hotel.controller;

import edu.dali.hotel.model.Room;
import edu.dali.hotel.service.RoomService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/room/*")
public class RoomController  {

    @Autowired
    RoomService roomService;

    /**
     * 对登录信息进行验证，并查找房间列表
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String getAllRoomList(ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){return "login";}
        List<Room> roomList = roomService.getAllRoomList();
        modelMap.addAttribute("roomList",roomList);
        return "roomList";
    }

    /**
     * 跳转至相应的修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updateRoom/roomId={id}")
    public String ToUpdateRoomPage(@PathVariable("id")int id, Model model){
        Room room = roomService.getRoomById(id);
        model.addAttribute("room",room);
        return "updateRoom";
    }

    /**
     * 根据修改的页面内容完成修改，并跳转回roomlist页面
     * @param room
     * @return
     */
    @RequestMapping("/updateAfterRoom")
    public String updateRoom(Room room){
        System.out.println("准备跳转roomlist");
        int i = roomService.updateRoom(room);
        return "redirect:/room/list";
    }

    /**
     * 跳转添加房间页面
     * @return
     */
    @RequestMapping("/addRoom")
    public String addRoom(){
        return "addRoom";

    }
    /**
     * 添加房间，并跳转回到/room/list
     * @param room
     * @return
     */
    @RequestMapping("/addRoomAfter")
    public String addRoomAfter(Room room){
        int i = roomService.addRoom(room);
        return "redirect:/room/list";

    }


    /**
     * 删除房间，并跳转回到/room/list
     * @param id
     * @return
     */
    @RequestMapping("/deleteRoom/roomId={id}")
    public String delectRoom(@PathVariable("id")int id){
        System.out.println("准备删除");
        int i = roomService.deleteRoomById(id);
        return "redirect:/room/list";

    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("room控制");
//        String url = request.getRequestURI().toString();
//        request.setCharacterEncoding("UTF-8");
//        HttpSession session = request.getSession();
//        String userId= (String) session.getAttribute("id");
////        System.out.println(session.getId());
////        System.out.println(userId);
//        //查看登录信息
//        if(userId==null||userId.equals("")){
//            request.getRequestDispatcher("/login.html").forward(request,response);}
//        //判断跳转页面
//        if(url.indexOf("getAll")>0){
//            RoomService roomService = new RoomService();
//            List<Room> roomList = roomService.getAllRoomList();
//            request.setAttribute("roomList",roomList);
//            System.out.println("跳转RoomList.jsp");
//            request.getRequestDispatcher("../RoomList.jsp").forward(request,response);
//
//        }
//        else if(url.indexOf("orderinfo")>0){
//            request.getRequestDispatcher("../orderinfo.jsp").forward(request,response);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }
}
