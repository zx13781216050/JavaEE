package com.emall_4_morning.mapper;

import com.emall_4_morning.entity.Cinema_Info;
import com.emall_4_morning.entity.Movie_Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Movie_InfoMapper {
    @Select("select * from  movie_info where movie_info.movie_status = #{status}")
    List<Movie_Info> getmovieinfolist(int status);
    @Select("select * from movie_info where movie_info.movie_id= #{movie_id}")
    List<Movie_Info> getdetailmovie(int movie_id);
}

