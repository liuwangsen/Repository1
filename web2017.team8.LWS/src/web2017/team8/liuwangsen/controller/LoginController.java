package web2017.team8.liuwangsen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web2017.team8.liuwangsen.entity.User;
import web2017.team8.liuwangsen.service.UserService;

@Controller
public class LoginController
{
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.html")
	public String loginPage()
	{
		return "login";
	}
	/**
	 * 负责处理loginCheck.html的请求
	 * @param request
	 * @param loginCommand
	 * @return
	 */
	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,
			LoginCommand loginCommand)
	{
		boolean isValidUser = userService.hasMatchUser(
				loginCommand.getUserName(), loginCommand.getPassword());
		if (!isValidUser)
		{
			return new ModelAndView("login", "error", "用户名或密码错误。");
		} else
		{
			User user = userService.findUserByUsername(loginCommand
					.getUserName());
			request.getSession().setAttribute("user", user);
			request.setAttribute("userName", loginCommand.getUserName());
			
			List<User> userList = userService.findUserList();
			request.setAttribute("userList", userList);
			
			return new ModelAndView("main");
		}
	}
	@RequestMapping(value = "/update.html")
	public String update(HttpServletRequest request)
	{
		String userName = (String)request.getParameter("userName");
		
		System.out.println(userName);
		
		userService.updateTel(request.getParameter("tel"), userName);
		return "login";
	}
	@RequestMapping(value = "/register.html")
	public String register(HttpServletRequest request)
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String ageString = request.getParameter("age");
		int age = Integer.parseInt(ageString);
		String tel = request.getParameter("tel");
		String sex = request.getParameter("sex");
		
		userService.insert(userName, password, age, tel, sex);
		return "login";
	}
	@RequestMapping(value = "/delete.html")
	public String delete(HttpServletRequest request)
	{
		String userName = (String)request.getParameter("userName");
		System.out.println(userName);
		userService.delete(userName);
		return "login";
	}
	

}
