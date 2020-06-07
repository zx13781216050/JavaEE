package com.emall_4_morning.controller;

import com.emall_4_morning.entity.Movie_Info;
import com.emall_4_morning.service.S_Movie_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class C_Movie_Info {
    @Autowired
    private S_Movie_Info s_movie_info;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setAutoGrowNestedPaths(true);
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);
    }
    @RequestMapping(value="get_movie_list", method = RequestMethod.POST)
    @ResponseBody
    public List<Movie_Info> getMovieInfoList(@RequestBody Movie_Info movie_info){


        List<Movie_Info> movie_infoList = null;
        movie_infoList = s_movie_info.getMovieInfoList(movie_info.getStatus());

        return movie_infoList;
    }
    @RequestMapping(value="get_detail_movie", method = RequestMethod.POST)
    @ResponseBody
    public List<Movie_Info> getDetailMovie(@RequestBody Movie_Info movie_info){


        List<Movie_Info> detail_movie = null;
        detail_movie = s_movie_info.getdetailmovie(movie_info.getMovie_id());

        return detail_movie;
    }
}
