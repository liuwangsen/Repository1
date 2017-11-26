package web2017.team8.liuwangsen.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import web2017.team8.liuwangsen.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestUserService
{
	@Autowired
	private UserService userService;
	
	@Test
	public void testUpdateTel()
	{
		userService.updateTel("15803400120", "admin");
	}

}
