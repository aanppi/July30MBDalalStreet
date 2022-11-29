package com.ds.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ds.testBase.TestBase;

public class LoginTestCase extends TestBase {
      String expected_url="https://apps.dalalstreet.ai/dashboard";
	
	@Test
	public void verifyLoginText() throws InterruptedException {
		
		String actual_url=login.getUrl();
		Assert.assertEquals(actual_url, expected_url);
	}
}
