package com.emall_4_morning.service;

import com.emall_4_morning.entity.Address_Info;
import com.emall_4_morning.mapper.Address_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //注解用来new一个 S_Address_Info的对象。实例化
public class S_Address_Info {
    @Autowired
    private Address_InfoMapper address_infoMapper;

    public List<Address_Info> getAddressList(int b_s_id){
        return address_infoMapper.getAddressList(b_s_id);
    }
    //必须加入spring事务，保证业务逻辑要么都成功，要么都失败。此处不是mybatis的事务。
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int insertAddress(Address_Info address_info){
        int flag = 0;
        //1:判断是否已经满10条
        if (address_infoMapper.getAddressNums(address_info.getB_s_id()) >= 10)
            return -1;//前端根据-1的代码显示相应的提示文字
        //2:先update默认值
        flag = address_infoMapper.updateDefaultStatus(address_info.getB_s_id());
        //3:insert地址
        flag = address_infoMapper.insertAddress(address_info);

        return flag;
    }
}
