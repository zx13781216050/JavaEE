package com.emall_4_morning.mapper;

import com.emall_4_morning.entity.Movie_Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Moivecomment_InfoMapper {
    @Insert("insert into movie_comment (movie_comment_id, comment_content, user_id, comment_time, " +
            " user_nickname, movie_id) values(#{movie_comment_id},#{comment_content},#{user_id}," +
            "#{comment_time},#{user_nickname},#{movie_id})")
    int insertmoviecomment(int movie_comment_id,String comment_content,int user_id,String comment_time,String user_nickname,int movie_id);
    @Select("SELECT MAX(movie_comment_id) FROM movie_comment;")
    int getmoviecommentid();
    @Select("select user_nickname from user_info where user_info.user_id = #{user_id}")
    String getusernickname(int user_id);
}
