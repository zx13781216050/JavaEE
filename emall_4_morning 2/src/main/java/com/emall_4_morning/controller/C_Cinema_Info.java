package com.emall_4_morning.controller;

import com.emall_4_morning.entity.Cinema_Info;
import com.emall_4_morning.entity.Movie_Info;
import com.emall_4_morning.entity.Seat_Info;
import com.emall_4_morning.service.S_Cinema_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class C_Cinema_Info {
    @Autowired
    private S_Cinema_Info s_cinema_info;
    @RequestMapping(value = "get_cinema_list",method = RequestMethod.POST)
    @ResponseBody
    public List<Cinema_Info> getMovieInfoList(@RequestBody Cinema_Info cinema_info){


        List<Cinema_Info> cinema_infoList = null;
        cinema_infoList = s_cinema_info.getCinemaInfoList(cinema_info.getCinema_status());

        return cinema_infoList;
    }
    @RequestMapping(value = "get_seat_list",method = RequestMethod.POST)
    @ResponseBody
    public List<Seat_Info> getSeatInfoList(HttpServletRequest request){
        int cinema_id = Integer.parseInt(request.getParameter("cinema_id"));
        int movie_id = Integer.parseInt(request.getParameter("movie_id"));
        int screeningroom_id = s_cinema_info.getscreeningroomid(cinema_id,movie_id);
        String getseatinfo = s_cinema_info.getdataname(screeningroom_id);

        List<Seat_Info> seat_infoList = null;
        seat_infoList = s_cinema_info.getseatinfolist(getseatinfo);
        return seat_infoList;
    }

}
