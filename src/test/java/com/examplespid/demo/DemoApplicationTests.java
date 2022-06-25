package com.examplespid.demo;

import com.examplespid.demo.entities.Spid;
import com.examplespid.demo.entities.User;
import com.examplespid.demo.entities.Status;
import com.examplespid.demo.entities.Type;
import com.examplespid.demo.service.SpidS;
import com.examplespid.demo.service.UserS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DemoApplicationTests.class})
class DemoApplicationTests {

	@Autowired
	private UserS userS;

	@Autowired
	private SpidS spidS;

	@Test
	void test() {
		try{
			System.out.println(userS.getUserById(1L));
			User user = userS.updateUser(new User(),1L);
			System.out.println(userS.getUserById(1L));
			Spid spid = spidS.createSpid(new Spid());
			System.out.println(spidS.findSpidById(user.getId()));
		}
		catch (Exception err){
			System.out.println(err.getMessage());
		}
	}

}
