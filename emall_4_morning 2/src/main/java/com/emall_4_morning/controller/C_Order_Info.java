package com.emall_4_morning.controller;

import com.emall_4_morning.entity.Movie_Info;
import com.emall_4_morning.entity.Order_Info;
import com.emall_4_morning.entity.Seat_Info;
import com.emall_4_morning.service.S_Order_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class C_Order_Info {
    @Autowired
    private S_Order_Info s_order_info;
    @RequestMapping(value="update_seat",method = RequestMethod.GET)
    @ResponseBody
    public void updateseat(HttpServletRequest request){
        int order_id = Integer.parseInt(request.getParameter("order_id"));
       //String[] seat_id =  request.getParameterValues("buy_id");
        int seat_id1 = Integer.parseInt(request.getParameter("buy_id1"));
        int flag1 = s_order_info.updateseat(order_id,seat_id1);
        if(request.getParameter("buy_id3").length()<3) {
            int seat_id2 = Integer.parseInt(request.getParameter("buy_id2"));
            int flag2 = s_order_info.updateseat(order_id,seat_id2);
        }
        if(request.getParameter("buy_id3").length()<3) {
            int seat_id3 = Integer.parseInt(request.getParameter("buy_id3"));
            int flag3 = s_order_info.updateseat(order_id,seat_id3);
        }
//
//       for(int i=0;i<3;i++){
//           if(seat_id[i] != null){
//               int a = Integer.parseInt(seat_id[i]);
//               int flag = s_order_info.updateseat(order_id,a);
//           }
//       }
    }
    @RequestMapping(value="insert_order",method = RequestMethod.POST)
    @ResponseBody
    public void insertorder(@RequestBody Order_Info order_info){

       int flag = s_order_info.insertorderinfo(order_info);
    }
    @RequestMapping(value = "get_order_id",method = RequestMethod.GET)
    @ResponseBody
    public int getorderid(){
        return s_order_info.getorderid();
    }
}
