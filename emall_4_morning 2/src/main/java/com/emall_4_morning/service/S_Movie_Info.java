package com.emall_4_morning.service;

import com.emall_4_morning.entity.Movie_Comment;
import com.emall_4_morning.entity.Movie_Info;
import com.emall_4_morning.mapper.Movie_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class S_Movie_Info {
    @Autowired
    private Movie_InfoMapper movie_infoMapper;

    public List<Movie_Info> getMovieInfoList(int status){
        return movie_infoMapper.getmovieinfolist(status);
    }
    public List<Movie_Info> getdetailmovie(int movie_id){
        return movie_infoMapper.getdetailmovie(movie_id);
    }
    public List<Movie_Comment> getmoviecomment(int movie_id){
        return movie_infoMapper.getmoviecomment(movie_id);
    }

}
