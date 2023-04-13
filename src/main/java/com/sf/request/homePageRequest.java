package com.sf.request;

import com.sf.entity.videoEntity;
import com.sf.service.UserListService;
import com.sf.service.impl.Addserviceimpl;
import com.sf.service.impl.DanmuServiceimpl;
import com.sf.service.impl.MessageServiceImpl;
import com.sf.service.impl.UserListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class homePageRequest {

    @Autowired
    Addserviceimpl addserviceimpl;

    @Autowired
    UserListService userListService;

    @Autowired
    MessageServiceImpl messageServiceImpl;

    @Autowired
    DanmuServiceimpl danmuServiceimpl;

    @Autowired
    UserListServiceImpl userListServiceImpl;

    @RequestMapping("index.sf")
    public String test() {
        return "forward:/logoone.sf";
    }

    // 将数据库里面所有的视频查询出来 发送到首页面
    @RequestMapping("logoone.sf")
    public ModelAndView logoone(HttpServletRequest request, HttpServletResponse response) {

        List<videoEntity> list = userListServiceImpl.videolist("1");// 1 为动画mad
        Map model = new HashMap();
        model.put("list", list);
        List<videoEntity> list2 = userListServiceImpl.videolist("2");// 2
        model.put("list2", list2);
        List<videoEntity> list3 = userListServiceImpl.videolist("3");// 3
        model.put("list3", list3);
        // 随机查6条数据出来
        List<videoEntity> list4 = userListServiceImpl.videolistimit6MAD();
        model.put("list4", list4);
        /*
         * List<videoEntity> test = userListServiceImpl.videolistimit5();
         * for(videoEntity ts:test){ System.out.println("测试是否查询出来");
         * System.out.println(ts.getVideoName());
         * System.out.println(ts.getVideoTime()); } 可以查询出这么多条记录
         */
        /* System.out.println("测试"); */
/*
		try {
			request.getRequestDispatcher("/static/adminjs/index.html").forward(request,response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

        return new ModelAndView("index", model);
    }
}
