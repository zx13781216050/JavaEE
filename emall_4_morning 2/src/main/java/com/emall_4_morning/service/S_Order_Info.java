package com.emall_4_morning.service;

import com.emall_4_morning.entity.Order_Info;
import com.emall_4_morning.mapper.Order_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class S_Order_Info {
    @Autowired
    private Order_InfoMapper order_infoMapper;
    public int updateseat(int order_id,int seat_id){
        int flag = order_infoMapper.updateseat(order_id,seat_id);
        return flag;
    }
    public int insertorderinfo(Order_Info order_info){
        int flag = order_infoMapper.insertorderinfo(order_info);

        return flag;
    }
    public int getorderid(){
        int flag = order_infoMapper.getorderid();
        return flag;
    }
}
