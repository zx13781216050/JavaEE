package com.emall_4_morning.entity;

public class Screeningroom_Info {
    private int screeningroom_id;
    private String screeningroom_name;
    private int cinema_id;
    private int screeningroom_status;
    private int movie_id;
    private String data_name;

    public int getScreeningroom_id() {
        return screeningroom_id;
    }

    public void setScreeningroom_id(int screeningroom_id) {
        this.screeningroom_id = screeningroom_id;
    }

    public String getScreeningroom_name() {
        return screeningroom_name;
    }

    public void setScreeningroom_name(String screeningroom_name) {
        this.screeningroom_name = screeningroom_name;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public int getScreeningroom_status() {
        return screeningroom_status;
    }

    public void setScreeningroom_status(int screeningroom_status) {
        this.screeningroom_status = screeningroom_status;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getData_name() {
        return data_name;
    }

    public void setData_name(String data_name) {
        this.data_name = data_name;
    }
}
