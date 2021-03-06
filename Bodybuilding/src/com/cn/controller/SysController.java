package com.cn.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.pojo.Admin;
import com.cn.pojo.CompetitionRecord;
import com.cn.pojo.Page;
import com.cn.pojo.PageUtil;
import com.cn.pojo.Teach;
import com.cn.pojo.User;
import com.cn.service.IUserService;

@Controller
@RequestMapping("/sys")
public class SysController
{
	@Resource
	private IUserService userService;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@ResponseBody
	@RequestMapping("/loginAdmin")
	public String toIndex(Admin admin, HttpSession session)
	{
		admin = userService.adminLogin(admin.getName(), admin.getPwd());
		if (admin != null)
		{
			session.setAttribute("lastLoginTime", admin.getLastlogintime());
			session.setAttribute("account", "123");
			userService.setTime(df.format(new Date()));
			return "true";
		} else
		{
			return "false";
		}
	}

	@RequestMapping("/ForwardAdmin")
	public String loginForward(HttpSession session)
	{
		List<Map<String, Object>> countUserList = userService.countUser();
		session.setAttribute("countUser", countUserList);
		List<Map<String, Object>> countTeachList = userService.countTeach();
		session.setAttribute("countTeach", countTeachList);
		List<Map<String, Object>> countApparatusList = userService
				.countApparatus();
		session.setAttribute("countApparatus", countApparatusList);
		return "sys/main";
	}

	@RequestMapping("/userTable")
	public String userTable(HttpSession session)
	{
		List<Map<String, Object>> findUserList = userService.findUser();
		session.setAttribute("findUserList", findUserList);
		return "sys/userTable";
	}

	@RequestMapping("/teachTable")
	public String teachTable(HttpSession session)
	{
		List<Map<String, Object>> findUserList = userService.teachTable();
		session.setAttribute("findTeachList", findUserList);
		return "sys/teachTable";
	}

	@RequestMapping("/apparatusTable")
	public String apparatusTable(HttpSession session)
	{
		List<Map<String, Object>> findUserList = userService.apparatusTable();
		session.setAttribute("findApparatusList", findUserList);
		return "sys/apparatusTable";
	}
/**
 *  分页信息显示
 * @param session
 * @param request
 * @return
 */
	@RequestMapping("/recordsTable")
	public String recordsTable(HttpSession session, HttpServletRequest request)
	{
		// List<Map<String, Object>> findRecordsList =
		// userService.recordsTable();
		// session.setAttribute("findRecordsList", findRecordsList);
		// return "sys/competitionRecord";

		int everyPage = 8;// 每页记录数
		
		List<Map<String, Object>> listCountRecord = userService.getRecordCount();
		Map<String, Object> mapCountRecord = listCountRecord.get(0);
		Long LongCountRecord = (Long)mapCountRecord.get("countRecord");
		int countRecord = LongCountRecord.intValue(); // 获取总记录数
		
		// 点击链接重新获取当前页
		String scurrentPage = (String)request.getParameter("currentPage");
		int currentPage = 1; // 当前页，默认1
		if (scurrentPage == null)
		{
			currentPage = 1;// 从第一页开始访问
		} else
		{
			currentPage = Integer.parseInt(scurrentPage);
		}
		//分页信息
        Page page = PageUtil.createPage(everyPage, countRecord, currentPage);
        //分页数据信息
        List<Map<String, Object>>  listPageRecords = userService.findByPage(page);
        
        session.setAttribute("page", page);
        session.setAttribute("listPageRecords", listPageRecords);
		
        return "sys/competitionRecord";
	}

	@RequestMapping("/exit")
	public String exit(HttpSession session)
	{
		session.invalidate();
		return "login";
	}

	@ResponseBody
	@RequestMapping("/getSex")
	public List<User> getSex()
	{
		List<User> list = userService.getSex();
		return list;
	}

	@ResponseBody
	@RequestMapping("/delUser")
	public String delUser(Integer id)
	{
		userService.delUser(id);
		return "true";
	}

	@ResponseBody
	@RequestMapping("/delTeach")
	public String delTeach(Integer id)
	{
		userService.delTeach(id);
		return "true";
	}

	@ResponseBody
	@RequestMapping("/delApp")
	public String delApp(Integer id)
	{
		userService.delApp(id);
		return "true";
	}

	@ResponseBody
	@RequestMapping("/loginForwardAdmin")
	public String loginForwardAdmin()
	{
		// TODO
		/**
		 * 需要做更新
		 */
		return "true";
	}

	@RequestMapping("/upUser")
	public String upUser(Integer id, String account, Integer sex, Integer age,
			String name, String pwd, String tel, String address,
			HttpSession session)
	{

		List<Object> list = new ArrayList<Object>();
		list.add(id);
		list.add(account);
		list.add(sex);
		list.add(age);
		list.add(name);
		list.add(pwd);
		list.add(tel);
		list.add(address);
		session.setAttribute("upList", list);
		return "sys/upUser";
	}

	@RequestMapping("/upTeach")
	public String upTeach(Integer id, String tname, Integer cid, String ttel,
			String taddress, HttpSession session)
	{

		List<Object> list = new ArrayList<Object>();
		list.add(id);
		list.add(tname);
		list.add(cid);
		list.add(ttel);
		list.add(taddress);
		session.setAttribute("upTeachList", list);
		return "sys/upTeach";
	}

	@ResponseBody
	@RequestMapping("/registerUser")
	public String registerUser(User user)
	{
		List<User> id = userService.findAccount(user.getAccount());
		if (id.size() != 0)
		{
			return "false";
		}
		userService.registerUser(user);
		return "true";
	}

	@RequestMapping("/addUser")
	public String addUser()
	{
		return "sys/addUser";
	}

	@RequestMapping("/addTeach")
	public String addTeach()
	{
		return "sys/addTeach";
	}

	@RequestMapping("/addApp")
	public String addApp()
	{
		return "sys/addApp";
	}

	@RequestMapping("/addRecord")
	public String addRecord()
	{
		return "sys/addRecord";
	}

	@ResponseBody
	@RequestMapping("/addCompetitionRecord")
	public String addCompetitionRecord(CompetitionRecord competitionRecord)
	{
		userService.addRecord(competitionRecord);
		return "true";
	}

	@ResponseBody
	@RequestMapping("/upUserInfo")
	public String upUserInfo(Integer id, String account, Integer sex,
			Integer age, String name, String pwd, String tel, String address)
	{
		userService.updateUserInfo(id, account, sex, age, name, pwd, tel,
				address);
		return "true";
	}

	@ResponseBody
	@RequestMapping(value = "/upTeachInfo", method = RequestMethod.POST)
	public String upTeach(Integer id, String tname, Integer cid, String ttel,
			String taddress)
	{
		userService.upTeach(id, tname, cid, ttel, taddress);
		return "true";
	}

	@ResponseBody
	@RequestMapping("/addTeachInfo")
	public String addTeachInfo(Teach teach)
	{
		userService.addTeachInfo(teach);
		return "true";
	}

	@ResponseBody
	@RequestMapping("/addAppInfo")
	public String addAppInfo(String aname)
	{
		userService.addAppInfo(aname);
		return "true";
	}

}
