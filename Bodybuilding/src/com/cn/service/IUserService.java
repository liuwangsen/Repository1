package com.cn.service;

import java.util.List;
import java.util.Map;

import com.cn.pojo.Admin;
import com.cn.pojo.CompetitionRecord;
import com.cn.pojo.Page;
import com.cn.pojo.Teach;
import com.cn.pojo.User;

public interface IUserService
{

	public User userLogin(String account, String pwd);

	public List<Map<String, Object>> findUserByAccount(String account);

	public List<Map<String, Object>> findRecord();

	public List<Map<String, Object>> findClass();

	public List<Map<String, Object>> findSeTeach(Integer id);

	public void chooseTeach(Integer id, Integer cid, Integer uid);

	public void updateUserInfo(Integer id, String account, Integer sex,
			Integer age, String name, String pwd, String tel, String address);

	public Admin adminLogin(String name, String pwd);

	public void setTime(String format);

	public List<Map<String, Object>> countUser();

	public List<Map<String, Object>> countTeach();

	public List<Map<String, Object>> countApparatus();

	public List<User> getSex();

	public List<Map<String, Object>> findUser();

	public List<Map<String, Object>> teachTable();

	public List<Map<String, Object>> apparatusTable();

	public List<Map<String, Object>> recordsTable();

	public List<User> findAccount(String account);

	public void registerUser(User user);

	public void delUser(Integer id);

	public void addTeachInfo(Teach teach);

	public void delTeach(Integer id);

	public void upTeach(Integer id, String tname, Integer cid, String ttel,
			String taddress);

	public void addAppInfo(String aname);

	public void delApp(Integer id);

	public void addRecord(CompetitionRecord competitionRecord);
	
	/**
	 * 取得比赛记录总条数
	 * @return 比赛记录总条数
	 */
	public List<Map<String, Object>>  getRecordCount();
	
	/**
	 * 查询每一页的记录
	 * @param page  传入一个分页信息实体类，包含了每一页的信息
	 * @return
	 */
	public List<Map<String, Object>> findByPage(Page page);

}