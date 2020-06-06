package com.emall_4_morning.controller;

import com.emall_4_morning.entity.Buyer_Seller_Info;
import com.emall_4_morning.service.S_Buyer_Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller //web
//@RestController  //json
public class C_Buyer_Seller {
    @Autowired
    private S_Buyer_Seller s_buyer_seller;

    @RequestMapping("get_buyer_list")
    @ResponseBody
    public List<Buyer_Seller_Info> getBuyerList(HttpServletRequest request){
        int status = Integer.parseInt(request.getParameter("status"));
        return s_buyer_seller.getBuyerList(status);
    }
}
