package com.sf.service;

import java.util.List;


import com.sf.entity.messageEntity;

import com.sf.entity.userEntity;
import com.sf.entity.videoEntity;

public interface UserListService {
	
	/**
	 *  根据用户的名字 查询出用户的所有信息
	 * @return
	 */
	public userEntity userlist(String  userName);
	/**
	 *  将video 全部信息全部查询出来
	 * 
	 */
	public List<userEntity> userlistUserName(String userName);
	
	/**
	 *  将video 全部信息全部查询出来
	 * 
	 */
	public List<videoEntity> videolist(String videocAtegory);

	
	/**
	 * 随机在video 里面查询出5条记录
	 * @return
	 */
	public List<videoEntity> videolistimit7();
	
	/**
	 * 随机在video 里面查询出6条记录
	 * @return
	 */
	public List<videoEntity> videolistimit6MAD();
	
	
	/**
	 * 随机在video 里面查询出5条记录
	 * @return
	 */
	public List<videoEntity> videolistimit5MAD();
	
	
	/**
	 * 根据ID查询出当前视频的所有留言
	 * @return
	 */
	public List<messageEntity> messagelist(String videoID);
	
	
	
	/**
	 * 将用户表里面所有的用户只查询出15条. 到时候方便分页
	 * @return
	 */
	public List<userEntity> userlistpage(int pageInt);

	
	/**
	 * 根据用户输入的内容 进行模糊查询出所得
	 * @return
	 * 
	 */
	public List<userEntity> listmohu(String usermohu);
	
	
	/**
	 * 根据用户输入的手机号 进行模糊查询出所得
	 * @return
	 * 
	 */
	public List<userEntity> userPhone(String userPhone);
	
	
	/**
	 * 根据ID查询出用户的所有信息
	 * @return
	 * 
	 */
	public List<userEntity> userID(String userID);

	
	/**
	 * 根据当前页查询出6条记录
	 * @param dangqianye  页面传过来的当前页
	 * @param State			需要查询的视频列别
	 * @param meiyexianshiduoshaoge 每页显示多少个视频
	 * @return
	 */
	public List<videoEntity> Pagevideolist(String State,int dangqianye,int meiyexianshiduoshaoge);
	
	
	/**
	 * 根据标记 查询出一共有多少条记录
	 * @param countvideo
	 * @return
	 */
	public int videocoun(String countvideo);


	/**
	 * 根据表名查询出有多少记录
	 * @param tableName
	 * @return
	 */
	public int counttable(String tableName);
}
