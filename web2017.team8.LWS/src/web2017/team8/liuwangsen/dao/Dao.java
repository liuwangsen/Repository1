package web2017.team8.liuwangsen.dao;

import java.util.List;

import web2017.team8.liuwangsen.entity.User;

/**
 * 使用接口实现  便于扩展
 * @author liuwangsen
 *
 */
public interface Dao
{
	public int getMatchCount(String userName, String password);
	
	public User findUserByUser_name(final String username);
	
	public List<User> findUserList();
	
	public void updateTel(String tel,String userName);
	
	public void insert(String userName,String password,int age, String tel,String sex);
	
	public void delete(String userName);

}
