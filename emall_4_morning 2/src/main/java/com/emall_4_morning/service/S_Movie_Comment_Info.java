package com.emall_4_morning.service;

import com.emall_4_morning.entity.Movie_Comment;
import com.emall_4_morning.mapper.Moivecomment_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_Movie_Comment_Info {
    @Autowired
    private Moivecomment_InfoMapper moivecomment_infoMapper;
    public int insertmoviecomment(int movie_comment_id,String comment_content,int user_id,String comment_time,String user_nickname,int movie_id){
        return moivecomment_infoMapper.insertmoviecomment(movie_comment_id,comment_content,user_id,comment_time,user_nickname,movie_id);
    }
    public int getmoviecommentid(){
        int flag = moivecomment_infoMapper.getmoviecommentid();
        return flag;
    }
    public String getusernickname(int user_id){
        return moivecomment_infoMapper.getusernickname(user_id);
    }

}
