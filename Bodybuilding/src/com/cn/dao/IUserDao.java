package com.cn.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cn.pojo.Admin;
import com.cn.pojo.CompetitionRecord;
import com.cn.pojo.Page;
import com.cn.pojo.Teach;
import com.cn.pojo.User;

public interface IUserDao
{

	User userLogin(@Param("account") String account, @Param("pwd") String pwd);

	List<Map<String, Object>> findUserByAccount(String account);

	List<Map<String, Object>> findRecord();

	List<Map<String, Object>> findClass();

	List<Map<String, Object>> findSeTeach(Integer id);

	void chooseTeach(Integer id, Integer cid, Integer uid);

	void updateUserInfo(@Param("id") Integer id,
			@Param("account") String account, @Param("sex") Integer sex,
			@Param("age") Integer age, @Param("name") String name,
			@Param("pwd") String pwd, @Param("tel") String tel,
			@Param("address") String address);

	Admin adminLogin(@Param("name") String name, @Param("pwd") String pwd);

	void setTime(String format);

	List<Map<String, Object>> countUser();

	List<Map<String, Object>> countTeach();

	List<Map<String, Object>> countApparatus();

	List<User> getSex();

	List<Map<String, Object>> findUser();

	List<Map<String, Object>> teachTable();

	List<Map<String, Object>> apparatusTable();

	/**
	 * 查询所有比赛记录
	 * 
	 * @return
	 */
	List<Map<String, Object>> recordsTable();

	List<User> findAccount(String account);

	void registerUser(User user);

	void delUser(Integer id);

	void addTeachInfo(Teach teach);

	void delTeach(Integer id);

	void upTeach(@Param("id") Integer id, @Param("tname") String tname,
			@Param("cid") Integer cid, @Param("ttel") String ttel,
			@Param("taddress") String taddress);

	void addAppInfo(String aname);

	void delApp(Integer id);

	/**
	 * 添加比赛记录
	 * 
	 * @param competitionRecord
	 */
	void addRecord(CompetitionRecord competitionRecord);

	/**
	 * 查询比赛记录总条数
	 * 
	 * @return 总条数
	 */
	List<Map<String, Object>> getRecordCount();

	/**
	 * 
	 * @param offset 偏移量：从这条记录开始查询
	 * @param limit  限制量：查到被要求的记录条数
	 * @return
	 */
	List<Map<String, Object>> findByPage(@Param("offset") Integer offset,
			@Param("limit") Integer limit);
}
