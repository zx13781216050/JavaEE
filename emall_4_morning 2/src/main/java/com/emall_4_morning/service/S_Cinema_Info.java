package com.emall_4_morning.service;

import com.emall_4_morning.entity.Cinema_Info;
import com.emall_4_morning.entity.Seat_Info;
import com.emall_4_morning.mapper.Cinema_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Cinema_Info {
    @Autowired
    private Cinema_InfoMapper cinema_infoMapper;

    public List<Cinema_Info> getCinemaInfoList(int cinema_status){
        return cinema_infoMapper.getcinemainfolist(cinema_status);
    }
    public int getscreeningroomid(int cinema_id,int movie_id){
        return cinema_infoMapper.getscreeningroomid(cinema_id,movie_id);
    }
    public String getdataname(int screeningroom_id){

        return cinema_infoMapper.getdataname(screeningroom_id);
    }
    public List<Seat_Info> getseatinfolist(String data_name){
        return cinema_infoMapper.getseatinfolist(data_name);
    }

}
