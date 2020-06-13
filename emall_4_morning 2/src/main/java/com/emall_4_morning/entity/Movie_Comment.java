package com.emall_4_morning.entity;

public class Movie_Comment {
    private int movie_comment_id;
    private String comment_content;
    private int user_id;
    private String  comment_time;
    private int score;
    private String user_nickname;
    private int movie_id;

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getMovie_comment_id() {
        return movie_comment_id;
    }

    public void setMovie_comment_id(int movie_comment_id) {
        this.movie_comment_id = movie_comment_id;
    }


    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String use_nickname) {
        this.user_nickname = use_nickname;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
