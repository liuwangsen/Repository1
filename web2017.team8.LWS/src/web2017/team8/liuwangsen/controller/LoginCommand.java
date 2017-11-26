package web2017.team8.liuwangsen.controller;

/**
 * 该类的创建即为了对应用户输入框中输入的用户名和密码
 * @author liuwangsen
 *
 */
public class LoginCommand
{
	private String userName;
	private String password;
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

}
