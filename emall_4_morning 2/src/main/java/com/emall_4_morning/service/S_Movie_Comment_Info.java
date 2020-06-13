package com.emall_4_morning.service;

import com.emall_4_morning.entity.Movie_Comment;
import com.emall_4_morning.mapper.Moivecomment_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_Movie_Comment_Info {
    @Autowired
    private Moivecomment_InfoMapper moivecomment_infoMapper;
    public int insertmoviecomment(Movie_Comment movie_comment){
        return moivecomment_infoMapper.insertmoviecomment(movie_comment);
    }
    
}
