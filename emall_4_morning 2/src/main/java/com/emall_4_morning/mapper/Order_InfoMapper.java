package com.emall_4_morning.mapper;

import com.emall_4_morning.entity.Order_Info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Order_InfoMapper {
    @Update("update seat_info_1_1 set seat_status = 2, order_id = #{order_id} where seat_id=#{seat_id}")
    int updateseat(int order_id,int seat_id);
    @Insert("insert into order_info(order_id, order_money, " +
            "use_id, order_status, movie_id, screeningroom_id," +
            " cinema_id) values(#{order_id}, " +
            "#{order_money}, #{use_id}, #{order_status}, " +
            "#{movie_id}, #{screeningroom_id}, #{cinema_id})")
    List<Order_Info> insertorderinfo(int order_id, int use_id, int cinema_id,
                                     int screeningroom_id, int movie_id, int order_status);
}
