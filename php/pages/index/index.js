// pages/index/index.js
//import qs from 'qs';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgUrls: [
      '/images/2.jpg',
      '/images/3.png',
      '/images/4.jpg',
      '/images/i1.jpg'
     ],
     list:[],
     
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    
    wx.request({
      url: 'http://localhost/php_5_morning/index.php/index/Movie/get_movie_list',
      method:'POST',
      header: {
        "content-type": "application/x-www-form-urlencoded"
      },
      data:{
        movie_status:1
      },
       
      success: function (res){
        console.log(res.data);
        var resData = res.data;
        that.setData({
          list:resData
        })
      }
    })
    

  },
  detail_movie: function(e){
    
    var id=e.currentTarget.id;
    var app=getApp();
    app.requestDetailid=id;
    console.log(app.requestDetailid);
    wx.navigateTo({
      url: '../movie/movie',
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