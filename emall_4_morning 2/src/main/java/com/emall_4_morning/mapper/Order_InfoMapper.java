package com.emall_4_morning.mapper;

import com.emall_4_morning.entity.Order_Info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Order_InfoMapper {
    @Update("update ${data_name} set seat_status = 2, order_id = #{order_id} where seat_id=#{seat_id}")
    int updateseat(String data_name,int order_id,int seat_id);

    @Insert("insert into order_info (order_id, order_money, use_id, cinema_id, " +
            " screeningroom_id, movie_id, order_status) values(#{order_id},#{order_money},#{use_id}," +
            "#{cinema_id},#{screeningroom_id},#{movie_id},#{order_status})")
    int insertorderinfo(Order_Info order_info);
    @Select("SELECT MAX(order_id) FROM order_info;")
    int getorderid();
    @Select("select screeningroom_id,cinema_id from order_info where user_id = 1")
    int getscid();

}
