// pages/movie/movie.js

Page({

  /**
   * 页面的初始数据
   */
  data: {
    list:[],
    isShow: false,
    comment_list:[],
    hiddenmodalput: true,
    comment_content:''
  },
  modalinput: function () {
    this.setData({
      //注意到模态框的取消按钮也是绑定的这个函数，
      //所以这里直接取反hiddenmodalput，也是没有毛病
      hiddenmodalput: !this.data.hiddenmodalput
    })
  },
  bindinput:function(e){
    this.setData({
      comment_content:e.detail.value
    })
    
  },
  confirm:function(e){
    var app=getApp();
    var movieid=app.getmovieid;
    wx.request({
      url: 'http://localhost:8080/insert_movie_comment',
      method:'POST',
      data:{
        mocie_id:movieid,
        user_id:1,
        comment_content:this.data.comment_content
      }
    })
  },
  tobuy: function(e){
    var id=e.currentTarget.id;
    var app=getApp();
    app.getmovieid=id;
    console.log(app.getmovieid);
    wx.navigateTo({
      url: '../chioce_cinema/chioce_cinema',
    })
  },
  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var movieid=getApp().requestDetailid;
    console.log(movieid);

    wx.request({
      url: 'http://localhost:8080/get_detail_movie',
      method:'POST',
      data:{
        movie_id:movieid
      },
       header: {
         'content-type': 'application/json',
       },
      success: function (res){
        console.log(res.data);
        var resData = res.data;
        that.setData({
          list:resData
        })
      }
    })
    wx.request({
      url: 'http://localhost:8080/get_movie_comment',
      method:'POST',
      data:{
        movie_id:movieid
      },
      header: {
        'content-type': 'application/json',
      },
      success: function (res){
        console.log(res.data);
        var resData = res.data;
        that.setData({
          comment_list:resData
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
   
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})