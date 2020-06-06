package com.emall_4_morning.service;

import com.emall_4_morning.entity.Buyer_Seller_Info;
import com.emall_4_morning.mapper.Buyer_SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Buyer_Seller {
    @Autowired
    private Buyer_SellerMapper buyer_sellerMapper;

    public List<Buyer_Seller_Info> getBuyerList(int status){
        return buyer_sellerMapper.getBuyerList(status);
    }

    public int registerBuyer_Seller(Buyer_Seller_Info buyer_seller_info){
        return buyer_sellerMapper.registerBuyer_Seller(buyer_seller_info);
    }

}
