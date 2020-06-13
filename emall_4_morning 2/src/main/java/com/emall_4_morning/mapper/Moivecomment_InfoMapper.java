package com.emall_4_morning.mapper;

import com.emall_4_morning.entity.Movie_Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Moivecomment_InfoMapper {
    @Insert("insert into movie_comment (movie_comment_id, comment_content, use_id, comment_time, " +
            " score, user_nickname, movie_id) values(#{movie_comment_id},#{comment_content},#{use_id}," +
            "#{comment_time},#{score},#{user_nickname},#{movie_id})")
    int insertmoviecomment(Movie_Comment movie_comment);
    @Select("SELECT MAX(movie_comment_id) FROM movie_comment;")
    int getmoviecommentid();
}
