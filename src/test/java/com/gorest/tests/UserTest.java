package com.gorest.tests;

import org.testng.annotations.Test;

import com.gorest.base.BaseTest;
import com.gorest.pojo.User;
import com.gorest.utils.StringUtil;

import io.restassured.response.Response;

public class UserTest extends BaseTest {

	private StringUtil stringUtil;

	@Test
	public void createUserTest() {
		stringUtil = new StringUtil();
		User createUserResource = User.builder().name("MathewHad").email(stringUtil.getRandomMail()).gender("male")
				.status("active").build();
		Response response = restClient.post(GOREST_ENDPOINT, "json", createUserResource, true, true);
		response.then().log().all()
			.assertThat()
				.statusCode(201);

	}

}
