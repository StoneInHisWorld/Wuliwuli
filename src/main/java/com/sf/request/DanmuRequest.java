package com.sf.request;

import com.sf.entity.Danmu;
import com.sf.entity.JsonDanmu;
import com.sf.service.MessageService;
import com.sf.service.UserListService;
import com.sf.service.impl.Addserviceimpl;
import com.sf.service.impl.DanmuServiceimpl;
import com.sf.service.impl.MessageServiceImpl;
import com.sf.service.impl.UserListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DanmuRequest {

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

    // 将数据库里面所有的视频查询出来 发送到首页面
    @RequestMapping(value="insertdanmu/v3",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertDanmu(@RequestBody JsonDanmu jsonDanmu) {
        System.out.println("接收到请求");

/*        System.out.println(jsonDanmu.getText());
        System.out.println(jsonDanmu.getColor());
        System.out.println(jsonDanmu.getTime());*/
        Danmu danmu=new Danmu();
        danmu.setDsize(0);
        danmu.setPosition(jsonDanmu.getType());
        danmu.setDtime(jsonDanmu.getTime());
        danmu.setColor(jsonDanmu.getColor());
        danmu.setVid(Integer.parseInt(jsonDanmu.getId()));
        danmu.setContent(jsonDanmu.getText());
        Map<String, Object> map = new HashMap<>();

        if(danmuServiceimpl.sendDanmu(danmu)){

            map.put("code",0);
            return  map;
        }

        map.put("code",1);
        return  map;

    }


    @RequestMapping(value={"insertdanmu/v3","insertdanmu"},method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDanmu(HttpServletRequest request, HttpServletResponse response){
        String id=request.getParameter("id");
        if(id==null){
            return "{\"code\":0 ,\"data\":[] }";
        }
        int vid=Integer.parseInt(request.getParameter("id"));
        List<Danmu> danmuList=danmuServiceimpl.readDanmuByVid(vid);
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        String pre="{\"code\":0 ,\"data\":";
        String  s="{\"data\": [[0, 0, 16777215, \"用户\", \"ddd\"], [7, 0, 16777215, \"用户\", \"ewwqweew\"]], \"code\": 0}";

        //List<>
        String last="[";

        int i=0;
        do{
            if(i==0) {
                last = last + "[" + "" + danmuList.get(i).getDtime() + ", " + danmuList.get(i).getPosition() + ", " + danmuList.get(i).getColor() + ", \"用户\", \"" + danmuList.get(i).getContent() + "\"]";
            }else {
                last = last + ", [" + "" + danmuList.get(i).getDtime() + ", " + danmuList.get(i).getPosition() + ", " + danmuList.get(i).getColor() + ", \"用户\", \"" + danmuList.get(i).getContent() + "\"]";

            }

            i++;
        }while (i<danmuList.size());

        last=last+"]}";
        System.out.println(pre+last);

        return  pre+last;
    }
}
