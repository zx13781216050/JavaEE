package com.emall_4_morning.entity;

public class Seat_Info {
    private int seat_id;
    private int seat_row;
    private int seat_col;
    private int seat_status;
    private int order_id;
    private int screeningroom_id;
    private int cinema_id;
    private int movie_id;

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getSeat_row() {
        return seat_row;
    }

    public void setSeat_row(int seat_row) {
        this.seat_row = seat_row;
    }

    public int getSeat_col() {
        return seat_col;
    }

    public void setSeat_col(int seat_col) {
        this.seat_col = seat_col;
    }

    public int getSeat_status() {
        return seat_status;
    }

    public void setSeat_status(int seat_status) {
        this.seat_status = seat_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getScreeningroom_id() {
        return screeningroom_id;
    }

    public void setScreeningroom_id(int screeningroom_id) {
        this.screeningroom_id = screeningroom_id;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int moview_id) {
        this.movie_id = moview_id;
    }
}
