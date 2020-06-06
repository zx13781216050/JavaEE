package com.emall_4_morning.mapper;

import com.emall_4_morning.entity.Cinema_Info;
import com.emall_4_morning.entity.Seat_Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Cinema_InfoMapper {
    @Select("select * from cinema_info WHERE cinema_status = #{cinema_status}")
    List<Cinema_Info> getcinemainfolist(int cinema_status);
    @Select("select screeningroom_id from screeningroom_info where cinema_id = #{cinema_id} and movie_id = #{movie_id}")
    int getscreeningroomid(int cinema_id,int movie_id);

    @Select("select data_name from screeningroom_info where  screeningroom_id = #{ screeningroom_id }")
    String  getdataname(int screeningroom_id);

    @Select("select * from ${_data_name}")
    List<Seat_Info> getseatinfolist(String data_name);

}
