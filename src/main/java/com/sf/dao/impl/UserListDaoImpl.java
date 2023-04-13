package com.sf.dao.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sf.dao.UserListDao;
import com.sf.tool.Data_jdbcTemplate;
import com.sf.entity.messageEntity;
import com.sf.entity.userEntity;
import com.sf.entity.videoEntity;
import com.sf.tool.RowMapperEntity;
import com.sf.tool.RowMapperVideoEntity;
import com.sf.tool.VideoRowMapperEntity;


@Component
public class UserListDaoImpl implements UserListDao {
	
	@Autowired
	Data_jdbcTemplate jdbcTemplate;
	
	public userEntity userlist(String userName) {
		//根据名字查询出用户对象. - - 
		String sql="select * from user where userName=?";
		userEntity user=jdbcTemplate.getJdbcTemplate().
				queryForObject(sql,new Object[]{userName},new RowMapperEntity());
		return user;
	}

	
	public List<videoEntity> videolist(String videocAtegory) {
		//将全部视频查询出来
		String sql="select * from video where videocAtegory=? order by rand() limit 8";//将视频标记为1的正常视频全部查询出
		List<videoEntity> list=jdbcTemplate.getJdbcTemplate().
				query(sql,new Object[]{videocAtegory} ,new VideoRowMapperEntity());
				
		return list;
	}


	//SELECT * from video ORDER BY RAND() LIMIT 5;随机在数据库里面查询出5条记录
	
	public List<videoEntity> videolistimit7() {
		String sql="select * from video order by rand() limit 7";
		List<videoEntity> list=jdbcTemplate.getJdbcTemplate().
				query(sql,new Object[]{} ,new VideoRowMapperEntity());
		
		return list;
	}


	@Override
	public List<videoEntity> videolistimit5MAD() {
		String sql="select * from video order by rand() limit 5 ";
		List<videoEntity> list=jdbcTemplate.getJdbcTemplate().query(sql,new Object[]{} ,new VideoRowMapperEntity());		
		
		return list;
	}


	@Override
	public List<messageEntity> messagelist(String videoID) {
		 List<messageEntity> list=null;
		//根据用户传过来的ID 查询出当前视频的所有留言
		//根据名字查询出用户对象. - - 
		String sql="select * from message WHERE messagevideoID=? order by STR_TO_DATE(messageTime,'%m/%d/%Y %h:%i:%s %p') desc";
		list=jdbcTemplate.getJdbcTemplate().query(sql,new Object[]{videoID},new RowMapperVideoEntity());		
		//将查询出来的所有结果全部放入到list集合当中
		return list;
		
	}


	@Override
	public List<userEntity> userlistpage(int pageInt) {
		List<userEntity> user=null;
		String sql="SELECT * FROM user LIMIT ?,15";
		 user=jdbcTemplate.getJdbcTemplate().query(sql,new Object[]{pageInt},new RowMapperEntity());		
		return user;
	}


	@Override
	public List<userEntity> listmohu(String usermohu) {

		//模糊查询 根据输入的名字查询
		String sql="select * from user where userMingzi LIKE ?";
		List<userEntity> list = jdbcTemplate.getJdbcTemplate().query(sql,new Object[]{usermohu},new RowMapperEntity());
		return list;
	}


	@Override
	public List<userEntity> userPhone(String userPhone) {
		//模糊查询 根据输入的名字查询
				String sql="select * from user where userPhone LIKE ? order by rand() limit 3";
				List<userEntity> list = jdbcTemplate.getJdbcTemplate().query(sql,new Object[]{userPhone},new RowMapperEntity());
				return list;
	}


	@Override
	public List<userEntity> userID(String userID) {
		String sql="select * from user where userID=?";
		List<userEntity> list = jdbcTemplate.getJdbcTemplate().query(sql,new Object[]{userID},new RowMapperEntity());
		return list;
	}


	@Override
	public List<videoEntity> Pagevideolist(String State, int dangqianye,int meiyexianshiduoshaoge) {
		//SELECT * FROM video WHERE videoID<=5 LIMIT 0,6
		String sql="SELECT * FROM video WHERE videocAtegory = ? LIMIT ?,?";
		List<videoEntity> list=jdbcTemplate.getJdbcTemplate().query(sql,new Object[]{State,dangqianye,meiyexianshiduoshaoge} ,new VideoRowMapperEntity());		
		return list;
	}


	@Override
	public int videocoun(String countvideo) {
		//根据标记查询出对应的条数
		String sql="select count(*) from video";// where videocAtegory = ? 
		int num = jdbcTemplate.getJdbcTemplate().queryForObject(sql, new Object[]{},Integer.class);
		return num;
	}




	@Override
	public List<userEntity> userlistUserName(String userName) {
		//根据名字查询出用户对象. - - 
		String sql="select * from user where userName=?";
		List<userEntity> user=jdbcTemplate.getJdbcTemplate().query(sql,new Object[]{userName},new RowMapperEntity());	
		return user;
	}



	@Override
	public List<videoEntity> videolistimit6MAD() {
		String sql="select * from video order by rand() limit 6";
		List<videoEntity> list=jdbcTemplate.getJdbcTemplate().query(sql,new Object[]{} ,new VideoRowMapperEntity());		
		
		return list;
	}




	@Override
	public int counttable(String tableName) {
		String sql = "SELECT count(*) FROM user";
		int num = jdbcTemplate.getJdbcTemplate().queryForObject(sql, new Object[]{},Integer.class);
		return num;
	}


	
	


}
