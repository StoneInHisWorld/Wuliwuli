package com.sf.request;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.entity.*;
import com.sf.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
/*import com.sf.chaxun.TestMain;*/
import com.sf.tool.interceptor.Auth;
import com.sf.service.MessageService;
import com.sf.service.UserListService;
import com.sf.tool.GetUUID;

@Controller
public class OtherRequest {

	@Autowired
	Addserviceimpl addserviceimpl;

	@Autowired
	UserListService userListService;

	@Autowired
	MessageServiceImpl messageServiceImpl;

	@Autowired
	DanmuServiceimpl danmuServiceimpl;

/*	@PostConstruct
    public void init(){
        System.out.println("我只会被调用一次");
       // new JspToHtml().main(null);//这个是静态页面
        TestMain sf = new TestMain();
        sf.main(null);
       //int num = Callingmethod.count;
       
    }*/
	
	
/*	@RequestMapping("index.sf")
	public String test() {
		return "forward:/logoone.sf";

	    //return "redirect:/abc/default.html";  //跳转
	    //return "forward:/abc/default.html";   //前进
	}*/
	
	

/*	// 将数据库里面所有的视频查询出来 发送到首页面
	@RequestMapping("logoone.sf")
	public ModelAndView logoone(HttpServletRequest request,HttpServletResponse response) {

		List<videoEntity> list = userListServiceImpl.videolist("1");// 1 为动画mad
		Map model = new HashMap();
		model.put("list", list);
		List<videoEntity> list2 = userListServiceImpl.videolist("2");// 2
		model.put("list2", list2);
		List<videoEntity> list3 = userListServiceImpl.videolist("3");// 3
		model.put("list3", list3);
		// 随机查6条数据出来
		List<videoEntity> fuck = userListServiceImpl.videolistimit6MAD();
		model.put("fuck", fuck);
		*//*
		 * List<videoEntity> test = userListServiceImpl.videolistimit5();
		 * for(videoEntity ts:test){ System.out.println("测试是否查询出来");
		 * System.out.println(ts.getVideoName());
		 * System.out.println(ts.getVideoTime()); } 可以查询出这么多条记录
		 *//*
		*//* System.out.println("测试"); *//*
*//*
		try {
			request.getRequestDispatcher("/static/adminjs/index.html").forward(request,response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*//*

		return new ModelAndView("index", model);
	}*/

	// AJAX 提交
	@RequestMapping(value = "ajaxTuiJian", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody void ajaxTuiJian(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<videoEntity> list = userListServiceImpl.videolistimit7();
		// 设置编码
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String sbb = gson.toJson(list);
		out.write(sbb);
	}

	// AJAX 提交
	@RequestMapping(value = "ajaxTuiJian2", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody void webajax2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<videoEntity> list = userListServiceImpl.videolistimit5MAD();

		// 设置编码
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String sbb = gson.toJson(list);
		out.write(sbb);
	}
	// querendingdan.sf

	@RequestMapping(value = "querendingdan1.sf", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody void querendingdan(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String userName = (String) request.getSession().getAttribute("userName");
		List<userEntity> user = userListServiceImpl.userlistUserName(userName);
		// user.getUserID();
		// 设置编码
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String sbb = gson.toJson(user);
		out.write(sbb);
	}

	@RequestMapping(value = "testsf.sf", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String testsf(HttpServletResponse res) {
		boolean bl = addserviceimpl.login();
		if (bl) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}

		return "shouye";

	}



	@Auth(validate = false)
	@RequestMapping("login.sf")
	public String login() {
		return "loginnew";

	}

	// 修改支付密码界面
	@RequestMapping("Tiaozhuanshouye.sf")
	public String Tiaozhuanshouye() {

		return "shouye";

	}

	// 信息修改界面
	@RequestMapping("User_full_information.sf")
	public ModelAndView User_full_information(HttpServletRequest request) {

		// 得到登录用户的名字
		String userName = (String) request.getSession().getAttribute("userName");
		userEntity user = userListServiceImpl.userlist(userName);
		Map model = new HashMap();

		model.put("user", user);// userlist是个Arraylist之类的
		// System.out.println(user.getUserRMB());

		// return "User_full_information";
		return new ModelAndView("User_full_information", model);

	}

	@Autowired
	Update_login_password_Service_Impl update_login_password_Service_Impl;

	// 修改登录密码界面
	@RequestMapping("Update_login_password.sf")
	public String Update_login_password(String passWord, String newpassWord, String newpassWord2,
			HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("userName");
		if (passWord != null || newpassWord != null || newpassWord2 != null) {
			if (newpassWord.equals(newpassWord2)) {
				boolean bl = update_login_password_Service_Impl.Update_login_password(userName, passWord, newpassWord);
				if (bl) {
//					return "User_full_information";
					return "Information";
				} else {
					request.setAttribute("PassWordErro", "对不起,旧密码输入有误!");
				}
			} else {
				request.setAttribute("PassWordErro", "两次密码输入有误!");
			}
		}
		return "Update_login_password";

	}

	@Autowired
	UserListServiceImpl userListServiceImpl;

	// 用户查看所有信息界面
	@RequestMapping("Information.sf")
	public ModelAndView Information(HttpServletRequest request) {
		// 得到登录用户的名字
		String userName = (String) request.getSession().getAttribute("userName");
		userEntity user = userListServiceImpl.userlist(userName);
		Map model = new HashMap();

		model.put("user", user);// userlist是个Arraylist之类的

		return new ModelAndView("Information", model);

	}


/*	@RequestMapping("video.sf")
	public ModelAndView video(String dizhi, HttpServletRequest request, String shipingID) {
		*//*
		 * System.out.println(dizhi);
		 * System.out.println("===============================");
		 *//*
		// 获得地址
		request.setAttribute("dizhi", dizhi);

		// System.out.println("===============================");
		Map model = new HashMap();

		// System.out.println(shipingID);//拿到视频地址
		request.setAttribute("shipingID", shipingID);
		// 根据视频ID查询出 此视频的所有留言
		List<messageEntity> messagelist = userListService.messagelist(shipingID);

		for (messageEntity message : messagelist) {
			message.getMessageuserName();// 得到用户名
			// 根据每个用户名查询出每个用户对应的头像地址
			model.put("messagelist", messagelist);// userlist是个Arraylist之类的
		}
		return new ModelAndView("Video", model);

		// return "Video";

	}*/

	@Autowired
	MessageService messageService;

	// 留言- - 测试
	@RequestMapping("test.sf")
	public String Test() {

		messageEntity user = new messageEntity();
		user.setMessage("1");
		user.setMessageID("1");
		user.setMessageTime("1");
		user.setMessageuserID("1");
		user.setMessageuserName("1");
		user.setMessagevideoID("1");
		boolean bl = messageService.message(user);
		if (bl) {
			System.out.println("可以使用评论");
		} else {
			System.out.println("不可以使用评论");
		}
		return "";

	}


	// 切换账号
	@RequestMapping("exect.sf")
	public String exect(HttpServletRequest request) {


		// 将session里面的用户信息全部清空
		request.getSession().removeAttribute("userName");
		return "loginnew";

	}

	@RequestMapping("Houtai.sf")
	public ModelAndView Houtai(HttpServletRequest request) {
		// 设置一个默认从第一条开始查询 只查询出15条记录
		String pageInt = "0";
		int test = Integer.valueOf(pageInt).intValue();
		List<userEntity> list = userListServiceImpl.userlistpage(test);
		Map model = new HashMap();
		model.put("list", list);

		return new ModelAndView("Houtai", model);

	}

	// AJAX 提交 根据用户名查询
	@RequestMapping(value = "userchaxunmessage1", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody void userchaxunmessage1(HttpServletRequest request, HttpServletResponse response,
			String message) throws IOException {
		String shuaige = message;
		// 得到内容 ajax提交进来
		List<userEntity> list = userListServiceImpl.listmohu("%" + shuaige + "%");

		// 设置编码
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String sbb = gson.toJson(list);
		if (list.size() == 0) {
			sbb = "0";
		}
		out.write(sbb);
	}

	// AJAX 提交 根据用户名查询
	@RequestMapping(value = "userchaxunmessage2", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody void userchaxunmessage2(HttpServletRequest request, HttpServletResponse response,
			String message) throws IOException {
		String shuaige = message;
		// 得到内容 ajax提交进来
		List<userEntity> list = userListServiceImpl.userPhone("%" + shuaige + "%");

		// 设置编码
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String sbb = gson.toJson(list);
		if (list.size() == 0) {
			sbb = "0";
		}
		out.write(sbb);
	}

	// AJAX 提交 根据ID查询
	@RequestMapping(value = "userID.sf", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody void userID(HttpServletRequest request, HttpServletResponse response, String userID)
			throws IOException {
		// 得到内容 ajax提交进来
		List<userEntity> list = userListServiceImpl.userID(userID);

		// 设置编码
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String sbb = gson.toJson(list);
		if (list.size() == 0) {
			sbb = "0";
		}
		out.write(sbb);
	}
	// AJAX 提交 修改用户数据

	@RequestMapping("updateuser.sf")
	public String updateuser(String userID, String userName, String userzhenshiName, String userSex, String passWord,
			String addr, String userPhone, String userQQ, String userEmial, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String echo = "";


		userEntity user = new userEntity();
		// 设置编码
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setUserID(userID);
		boolean bl = update_login_password_Service_Impl.Update_user(user);
		if (bl) {
			echo = "修改成功";
			System.out.println("成功");
		} else {
			echo = "修改失败,请联系管理员";
		}
		request.setAttribute("echo", echo);
		return "forward:/Houtai.sf";

	}



	// 将数据库里面所有的视频查询出来 发送到首页面
	@RequestMapping("testshabi.sf")
	public String testshabi(HttpServletRequest request) {


		int tag1 = userListServiceImpl.videocoun("1");
		request.setAttribute("tag1", tag1);

		int tag4 = 12;
		// 每页显示多少
		request.setAttribute("tag4", tag4);

		return "DisplayVideo";

	}

	// AJAX 提交
	@RequestMapping(value = "ajaxtijiao1.sf", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody void ajaxtijiao(HttpServletRequest request, HttpServletResponse response, String State,
			String dangqianye, int meiyexianshiduoshaoge) throws IOException {
		/* List<videoEntity> list = userListServiceImpl.videolistimit5(); */
		int dangqianye2 = Integer.parseInt(dangqianye);
		List<videoEntity> list = userListServiceImpl.Pagevideolist(State, dangqianye2, meiyexianshiduoshaoge);// State
																												// 标记

		// 设置编码
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String sbb = gson.toJson(list);
		out.write(sbb);
	}



	@RequestMapping("AdminBL")
	public String AdminBL(HttpServletRequest request) {

		return "AdminBL";

	}


/*	*//************************ 文件上传 ****************************************//*
	@RequestMapping("videoFileTop")
	public String videoFileTop(HttpServletRequest request) {

		return "videoFileTop";

	}

	*//***
	 * 保存文件
	 * 
	 * @param file
	 * @return
	 *//*
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
						*//******************** 测试 **************************//*
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
					*//*************************
					 * 我尼玛!这里
					 *********************************//*

				}
			}
		}
		System.out.println("上传结束");

		return "videoFileTop";

	}

	*//************************* 这里写个百分比的AJAX *******************************//*
	@RequestMapping(value = "baifenbiAJAX", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public @ResponseBody void baifenbiAJAX(HttpServletRequest request, HttpServletResponse response)
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
			*//*
			 * try { Thread.sleep(3000); } catch (InterruptedException e) {
			 * System.out.println("线程休息出错"); e.printStackTrace(); }
			 *//*
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

	}*/

	



/*	// 将数据库里面所有的视频查询出来 发送到首页面
	@RequestMapping(value="insertdanmu/v3",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insertDanmu(@RequestBody JsonDanmu jsonDanmu) {
		System.out.println("接收到请求");

		System.out.println(jsonDanmu.getText());
		System.out.println(jsonDanmu.getColor());
		System.out.println(jsonDanmu.getTime());
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
    public String getDanmu(HttpServletRequest request,HttpServletResponse response){
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
	}*/





}
