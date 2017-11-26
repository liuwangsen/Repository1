package web2017.team8.liuwangsen.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import web2017.team8.liuwangsen.dao.Dao;
import web2017.team8.liuwangsen.entity.User;

@Repository
public class UserDao implements Dao
{
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		@Override
		public int getMatchCount(String userName, String password)
		{
			String sqlStr = "select count(*) from user " + "where userName= ? and password = ?";
			
			return jdbcTemplate.queryForInt(sqlStr, new Object[]{userName,password});
		}
		@Override
		public User findUserByUser_name(final String username)
		{
			String sqlStr = "select userId,userName,age,tel,sex" + " from user where userName = ?";
			
			final User user = new User();
			
			jdbcTemplate.query(sqlStr, new Object[]{username}, 
					new RowCallbackHandler()
					{
						@Override
						public void processRow(ResultSet arg0) throws SQLException
						{
							user.setUserId(arg0.getInt("userId"));
							user.setUserName(username);
							user.setAge(arg0.getInt("age"));
							user.setTel(arg0.getString("tel"));
							user.setSex(arg0.getString("sex"));
						}
					});
			return user;
		}
		@Override
		public List<User> findUserList()
		{
			List<User> userList = new ArrayList<User>();
			
			String sql = "select * from user";
			
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
			
			for(Map<String, Object> map : list)
			{
				User user = (User)mapToUser(map);
				if(user != null)
				{
					userList.add(user);
				}
//				System.out.println(map.keySet());
//				System.out.println(map.values());
			}
			return userList;
		}
		@Override
		public void updateTel(String tel,String userName)
		{
			String sqlStr = "update user set tel =?" + "where userName=?";
			
			jdbcTemplate.update(sqlStr, new Object[]{tel,userName});
			
		}
		@Override
		public void insert(String userName,String password,int age, String tel,String sex)
		{
			String sqlStr = "insert into  user(userName,password,age,tel,sex)"+"values(?,?,?,?,?)";
			
			jdbcTemplate.update(sqlStr, new Object[]{userName,password,age,tel,sex});
		}
		@Override
		public void delete(String userName)
		{
			String sqlStr = "delete from user where userName = ?";
			
			jdbcTemplate.update(sqlStr, new Object[]{userName});
		}
		private User mapToUser(Map<String, Object> map)
		{
			User user = new User();
			
			user.setUserId((int)map.get("userId"));
			user.setUserName((String)map.get("userName"));
			user.setAge((int)map.get("age"));
			user.setTel((String)map.get("tel"));
			user.setSex((String)map.get("sex"));
			
			return user;
		}
		
}
