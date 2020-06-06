package com.emall_4_morning.controller;

import com.emall_4_morning.entity.Address_Info;
import com.emall_4_morning.service.S_Address_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class C_Address_Info {
    @Autowired
    private S_Address_Info s_address_info;//通过spring的autowired注解自动new一个对象

    @RequestMapping("get_address_list")
    public String getAddressList(HttpServletRequest request, Model model) {
        //进来之前要判断session是否过期。
        HttpSession session = request.getSession();
        //此方法废码太多。不建议。直接做拦截器或过滤器中处理session是否过期的问题。
        //if (session.getAttribute("b_s_id") == null)
        //    return "redirect:login";
        //走到这里的时候session是肯定不过期的,目前还没写session的代码。先给固定值
        //int b_s_id = Integer.parseInt(session.getAttribute("b_s_id").toString());
        int b_s_id = 1;
        List<Address_Info> address_infoList = null;
        address_infoList = s_address_info.getAddressList(b_s_id);
        model.addAttribute("address_list", address_infoList);
        return "address_info";
    }
    /* 添加的业务逻辑
     * 1：前端输入的合法性校验（尽量前端验证）
     * 2：进入拦截器判断session的有效性
     * 3: 进入控制器，接受数据，初始化后转给service层处理。
     * 4: service层的业务逻辑中：判断记录是否超过10条。
     * （邹桥东说要后台判断一下。前端判断优先，后台判断效率低了，
     * 1:前端可以绕过.2:前端容易写死了。中间层相对灵活，但效率低下。
     * 先假定用后端验证。属于业务逻辑的一部分。刘子煜说：如果后台超过10条
     * 提醒删一条的同时要暂时保存当前的数据）--业务过于复杂。给程序员增加负担。好处：客户体验感好。
     * 5：要判断是否设置成默认：1：不设置。直接做单表插入。
     * 2:设置了。则应该先修改原来数据库默认记录为不默认。然后再插入新的记录。（需要事务设置）
     * 6：成功则返回到控制层。控制层调用重定向请求返回页面。
     * */
    @RequestMapping("insert_address")
    public String insertAddress(HttpServletRequest request){
        /*
            1:用自动绑定，传递对象的方式去实现web方式。互联网时代
            2：用ajax的时候使用json对象自动转换成类的对象的方式 移动互联网时代
            老师在这里用最笨的方式初始化。相当大明朝时代。
         */
        Address_Info address_info = new Address_Info();
        address_info.setAddress(request.getParameter("address"));
        address_info.setAddress_detail(request.getParameter("address_detail"));
        address_info.setAddresssee(request.getParameter("addresssee"));
        address_info.setTelephone(request.getParameter("telephone"));
        address_info.setPostcode(request.getParameter("postcode"));
        if (request.getParameter(("default_status")) == null)
            address_info.setDefault_status(0);
        else
            address_info.setDefault_status(1);
        //从session中获取b_s_id,目前没有session，先注释,session是否过期拦截器处理
        //address_info.setB_s_id(Integer.parseInt(request.getSession().getAttribute("b_s_id").toString()));
        address_info.setB_s_id(1);
        int flag = s_address_info.insertAddress(address_info);
        if (flag == 0)
            return "redirect:error_request";
        else if (flag == -1)
            return "";
        else
            return "redirect:get_address_list";//请同学们去思考如何完成重定向中的参数传递。
    }

}
