// pages/order/order.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      flag:true,
      movie_list:[],
      seat_list:[],
      buy_id:[],
     isShow:false,
     index:0,
     flag:true,
     order_money:0,
     //order_id:0,
     use_id:1
  },  
  close_tap:function(e){ 
    var id = e.currentTarget.dataset.id;   
    // let app=getApp();
    // app.getid=id;
    var that = this;
    let rowId=e.currentTarget.dataset.row
    this.data.seat_list[rowId-1].list.forEach(element => {
      if(element.seat_id==id && this.data.index<=2 ){
        element.seat_status=0;
            
        var string = 'buy_id[' + this.data.index + ']'
        this.setData({ 
          [string]:id,
          index: this.data.index + 1,
          order_money:this.data.order_money + 30
        });
      }else if(this.data.index==3){
        wx.showModal({  
          title: '提示', 
          showCancel: false, 
          content: '每次最多购买三张',  
          success: function(res) {  
           if (res.confirm) {
　　　　　　　　//点击取消,默认隐藏弹框
　　　　　　} else {
  　　　　　　　//that.onLoad()
            } 
        },
        fail: function (res) { },//接口调用失败的回调函数
　　　　　　complete: function (res) { },//接口调用结束的回调函数（调用成功、失败都会执行）  
      })  
      }
      this.setData({
               seat_list:this.data.seat_list,
             })  
    });
    
    // console.log(this.data.seat_list)        
    },
    buy:function(){
      let that=this;
      let order_id = getApp().getorderid;
      let cinemaid=getApp().getcinemaid;
    let movieid=getApp().requestDetailid;
    let useid = this.data.use_id;
    let screeningroomid=this.data.seat_list[1].list[1].screeningroom_id;
    //let orderid = this.data.order_id+1;
    let ordermoney = this.data.order_money;
    let buy_id1 = this.data.buy_id[0];
    let buy_id2 = this.data.buy_id[1];
    let buy_id3 = this.data.buy_id[2];   
    //var seat_id = JSON.stringify(this.data.buy_id);
     console.log(this.data.buy_id)

        wx.showModal({  
            title: '提示',  
            content: '是否确认购买',  
            success: function(res) {  
                if (res.confirm) {  
                console.log('用户点击确定')
                wx.showToast({
                  title: '购票成功',
                  icon: 'success',
                  duration: 2000,
                })
                
                
                wx.request({
                  url: 'http://localhost:8080/insert_order',
                  method:'POST',
                  data:{
                    movie_id:movieid,
                    cinema_id:cinemaid,
                    order_money:ordermoney,
                    screeningroom_id:screeningroomid,
                    order_id:order_id+1,
                    use_id:useid,
                    order_status:1,
                  },
                })
                wx.request({
                  url: 'http://localhost:8080/update_seat',
                  method:'GET',
                  data:{
                    movie_id:movieid,
                    cinema_id:cinemaid,
                    order_id:order_id+1,
                   buy_id1:buy_id1,
                   buy_id2:buy_id2,
                   buy_id3:buy_id3,
                  },
                })
                wx.redirectTo({
                  url: '../movie/movie',
                })

                
                } else if (res.cancel) {  
                console.log('用户点击取消')  
                }  
            }  
        })
       
      
    },    
    
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let order_id = getApp().getorderid;
    console.log(order_id)
    var that=this;
  /**全局变量传cinemaid，movieid */ 
    var cinemaid=getApp().getcinemaid;
    var movieid=getApp().requestDetailid;    
    wx.request({
      url:'http://localhost:8080/get_order_id',
      method:'GET',
      success:function(res){
        console.log(res.data);
        var resData = res.data;
        
        var app=getApp();
        app.getorderid=resData;
 
      }          
    })
    wx.request({
      url: 'http://localhost:8080/get_detail_movie',
      method:'POST',
      data:{
        movie_id:movieid,
        
      },
      
      success: function (res){
        console.log(res.data);
        var resData = res.data;
        that.setData({
          movie_list:resData
        })
      }
    })
    wx.request({
      url: 'http://localhost:8080/get_seat_list?movie_id='+movieid+'&cinema_id='+cinemaid,
      method:'POST',
      data:{
        movie_id:movieid,
        cinema_id:cinemaid
      },
       
      success: function (res){
        console.log(res.data);
    
        var list1=[],list2=[],list3=[],list4=[],list5=[],list6=[];
        var i = -1,j = -1,a = -1,b = -1,c = -1,d = -1;
        for (var index = 0; index < res.data.length; ++index) {
         
          if(res.data[index].seat_row==1){
            i=i+1;
            list1[i]=res.data[index];
            
          }
          if(res.data[index].seat_row==2){
            j=j+1
            list2[j]=res.data[index];
          }
          if(res.data[index].seat_row==3){
            a=a+1
            list3[a]=res.data[index];
          }
          if(res.data[index].seat_row==4){
            b=b+1
            list4[b]=res.data[index];
          }
          if(res.data[index].seat_row==5){
            c=c+1
            list5[c]=res.data[index];
          }
          if(res.data[index].seat_row==6){
            d=d+1
            list6[d]=res.data[index];
          }
        }
      var seat_list=[
          {
            row:1,
            list:list1
          },
          {
            row:2,
            list:list2
          },
          {
            row:3,
            list:list3
          },
          {
            row:4,
            list:list4
          },
          {
            row:5,
            list:list5
          },
          {
            row:6,
            list:list6
          },
          // wx.setStorage({  
          //   key: 'seat_list',  
          //   data: res.data,  
          // })
        ]
        console.log(seat_list)
        that.setData({
          seat_list:seat_list
        })
      }
    })
    
 
  },
  
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },
  showPopup() {
    this.popup.showPopup();
  },
 
  //取消事件
  _error() {
    console.log('你点击了取消');
    this.popup.hidePopup();
  },
  //确认事件
  _success() {
    console.log('你点击了确定');
    this.popup.hidePopup();
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