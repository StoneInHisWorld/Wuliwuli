package com.sf.request;

import com.google.gson.Gson;
import com.sf.entity.videoTopEntity;
import com.sf.service.MessageService;
import com.sf.service.UserListService;
import com.sf.service.impl.Addserviceimpl;
import com.sf.service.impl.DanmuServiceimpl;
import com.sf.service.impl.MessageServiceImpl;
import com.sf.service.impl.UserListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class videoUploadRequest {

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

    /************************ 文件上传 ****************************************/
    @RequestMapping("videoFileTop")
    public String videoFileTop(HttpServletRequest request) {

        return "videoFileTop";

    }

    /***
     * 保存文件
     *
     * @param file
     * @return
     */
    private boolean saveFile(MultipartFile file) {

        return false;
    }

    @RequestMapping("videoFileTop.sf")
    public String videoFileTop(@RequestParam("files") MultipartFile[] files, HttpServletRequest request, String biaoti,
                               String Fruit) {
        System.out.println("用户输入的标题为:" + biaoti + Fruit);
        if (files != null && files.length > 0) {
            // 循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                // 保存文件
                System.out.println("正在调用保存方法");
                // saveFile(file);
                // 判断文件是否为空
                if (!file.isEmpty()) {
                    try {

                        // new 出一个实体
                        videoTopEntity video = new videoTopEntity();
                        // 放入session中
                        request.getSession().setAttribute("video", video);// 放入到session中

                        System.out.println("文件总大小" + file.getSize());
                        // 文件保存路径
                        String filePath = "C:/Users/LXH/Desktop/TEST/videohome/" + file.getOriginalFilename();
                        System.out.println(filePath);
                        /******************** 测试 **************************/
                        File storeFile = new File(filePath);
                        // 得到输入流
                        InputStream in = file.getInputStream();
                        // 得到文件的输出流
                        OutputStream out = new FileOutputStream(storeFile);
                        // 文件总大小
                        long max = file.getSize();
                        video.setFileSize(max);
                        video.setFilename(file.getOriginalFilename());
                        // 剩余大小
                        long other = max;
                        int len = 0;// 读取写入长度
                        // 读写缓冲
                        byte[] b = new byte[300];
                        // 循环从输入流写入到输出流,结束循环是len==-1
                        while ((len = in.read(b)) != -1) {
                            out.write(b, 0, len);
                            other -= len;
                            video.setFileSY(other);
                            // System.out.println("剩余大小:"+other);
                            // 给DTO设置other
                            // dto.setOther(other);
                            // System.out.println("总大小="+max+"剩余大小="+other);
                            // z总 max
                            // 剩余 other
                            // 传了 max-other
                            float zong = (float) (Integer.parseInt(String.valueOf(max)));
                            int shengxia = Integer.parseInt(String.valueOf(other));
                            float ii3 = (float) zong - shengxia;// 传了多少
                            if (shengxia != 0) {
                                int baifenbi = (int) ((ii3 / zong) * 100);
                                video.setBaifenbi(baifenbi);
                                // request.getSession().setAttribute("baifenbi",
                                // baifenbi);
                                // sSystem.out.println(baifenbi);
                            }
                        }
                        out.flush();// 刷新
                        out.close();// 关闭
                        in.close();// 关闭
                        video.setTag(1);// 标记为1的时候表示上传成功
                        System.out.println("上传成功");
                        // 开始存储数据库 - - 这个好像好麻烦的说

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    /*************************
                     * 我尼玛!这里
                     *********************************/

                }
            }
        }
        System.out.println("上传结束");

        return "videoFileTop";

    }

    /************************* 这里写个百分比的AJAX *******************************/
    @RequestMapping(value = "baifenbiAJAX", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    void baifenbiAJAX(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (request.getSession().getAttribute("video") == null) {
            // new 出一个实体
            videoTopEntity video = new videoTopEntity();
            video.setBaifenbi(0);
            video.setFilename("请稍后..");
            video.setFileSize(0);
            video.setFileSY(0);
            video.setTag(0);
            // 放入session中
            request.getSession().setAttribute("video", video);// 放入到session中

            // - -想不到办法....就先让线程休息3秒在往下跑吧
            /*
             * try { Thread.sleep(3000); } catch (InterruptedException e) {
             * System.out.println("线程休息出错"); e.printStackTrace(); }
             */
        } else {
            videoTopEntity video = (videoTopEntity) request.getSession().getAttribute("video");
            // 设置编码
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String sbb = gson.toJson(video);
            out.write(sbb);
        }

    }
}
