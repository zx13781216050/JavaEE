package com.emall_4_morning.service;

import com.emall_4_morning.entity.Order_Info;
import com.emall_4_morning.mapper.Order_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Order_Info {
    @Autowired
    private Order_InfoMapper order_infoMapper;
    public List<Order_Info> insertorderinfo(int order_id, int user_id, int cinema_id, int screeningroom_id, int movie_id, int order_status){
        return order_infoMapper.insertorderinfo(order_id,user_id,cinema_id,screeningroom_id,movie_id,order_status);
    }
}
