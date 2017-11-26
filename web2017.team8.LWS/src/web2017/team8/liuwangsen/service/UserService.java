package web2017.team8.liuwangsen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web2017.team8.liuwangsen.dao.Dao;
import web2017.team8.liuwangsen.entity.User;

@Service
public class UserService
{
	@Autowired
	private Dao userDao;
	
	public boolean hasMatchUser(String username, String password)
	{
		int matchCount = userDao.getMatchCount(username, password);
		return matchCount > 0;
	}
	public User findUserByUsername(String username)
	{
		return userDao.findUserByUser_name(username);
	}
	public List<User> findUserList()
	{
		List<User> userList = userDao.findUserList();
		
		return userList;
	}
	public void updateTel(String tel,String userName)
	{
		userDao.updateTel(tel, userName);
	}
	public void insert(String userName,String password,int age, String tel,String sex)
	{
		userDao.insert(userName, password, age, tel, sex);
	}
	public void delete(String userName)
	{
		userDao.delete(userName);
	}

}
