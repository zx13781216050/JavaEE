package com.emall_4_morning.controller;

import com.emall_4_morning.entity.Movie_Info;
import com.emall_4_morning.entity.Order_Info;
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

    @RequestMapping(value="insert_order",method = RequestMethod.POST)
    @ResponseBody
    public List<Order_Info> insertorder(@RequestBody Order_Info order_info){
//        int movie_id = Integer.parseInt(request.getParameter("movie_id"));
//        int cinema_id = Integer.parseInt(request.getParameter("cinema_id"));
//        int screeningroom_id = Integer.parseInt(request.getParameter("screeningroom_id"));
//        int order_id = Integer.parseInt(request.getParameter("order_id"));
//        int user_id = Integer.parseInt(request.getParameter("user_id"));
//        int order_status = Integer.parseInt(request.getParameter("order_status"));
//        System.out.println(movie_id+cinema_id+screeningroom_id+order_id+user_id);
//        int flag = s_order_info.insertorderinfo(order_id,user_id,cinema_id,screeningroom_id,movie_id,order_status);
        List<Order_Info> orderInfoList = null;
        System.out.println(order_info.getOrder_id()+order_info.getUse_id()+order_info.getCinema_id()+
                order_info.getScreeningroom_id()+order_info.getMovie_id()+order_info.getOrder_status());
        orderInfoList = s_order_info.insertorderinfo(order_info.getOrder_id(),order_info.getUse_id(),order_info.getCinema_id(),
                order_info.getScreeningroom_id(),order_info.getMovie_id(),order_info.getOrder_status());
        return orderInfoList;
    }
}
