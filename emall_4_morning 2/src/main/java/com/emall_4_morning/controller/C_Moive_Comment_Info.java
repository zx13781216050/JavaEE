package com.emall_4_morning.controller;

import com.emall_4_morning.entity.Movie_Comment;
import com.emall_4_morning.service.S_Movie_Comment_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class C_Moive_Comment_Info {
    @Autowired
    private S_Movie_Comment_Info s_movie_comment_info;
    @RequestMapping(value = "insert_movie_comment",method = RequestMethod.POST)
    @ResponseBody
    public void insertmoviecomment(@RequestBody Movie_Comment movie_comment){
        int movie_comment_id = movie_comment.getMovie_comment_id();
        String comment_content = movie_comment.getComment_content();
        int user_id = movie_comment.getUser_id();
        String comment_time = movie_comment.getComment_time();
        int movie_id = movie_comment.getMovie_id();
        String user_nickname = s_movie_comment_info.getusernickname(user_id);
        int flag = s_movie_comment_info.insertmoviecomment(movie_comment_id,comment_content,user_id,comment_time,user_nickname,movie_id);

    }
    @RequestMapping(value = "get_movie_comment_id",method = RequestMethod.POST)
    @ResponseBody
    public void getmoviecommentid(){
        int flag = s_movie_comment_info.getmoviecommentid();
    }
}
