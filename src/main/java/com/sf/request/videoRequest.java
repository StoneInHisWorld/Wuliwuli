package com.sf.request;

import com.sf.entity.messageEntity;
import com.sf.service.MessageService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class videoRequest {

    @Autowired
    UserListServiceImpl userListServiceImpl;

    @Autowired
    Addserviceimpl addserviceimpl;

    @Autowired
    UserListService userListService;

    @Autowired
    MessageServiceImpl messageServiceImpl;

    @Autowired
    DanmuServiceimpl danmuServiceimpl;

    @Autowired
    MessageService messageService;

    @RequestMapping("video.sf")
    public ModelAndView video(String dizhi, HttpServletRequest request, String shipingID) {
        // 获得地址
        request.setAttribute("dizhi", dizhi);

        Map model = new HashMap();

        request.setAttribute("shipingID", shipingID);
        // 根据视频ID查询出 此视频的所有留言
        List<messageEntity> messagelist = userListService.messagelist(shipingID);

        for (messageEntity message : messagelist) {
            message.getMessageuserName();// 得到用户名
            // 根据每个用户名查询出每个用户对应的头像地址
            model.put("messagelist", messagelist);// userlist是个Arraylist之类的
        }
        return new ModelAndView("Video", model);
    }
}
