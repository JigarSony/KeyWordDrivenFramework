package com.qa.app.tests;

import org.testng.annotations.Test;

import com.qa.app.keyword.engine.KeyWordEngine;

public class LoginTest {

	public KeyWordEngine keywordengine;
	@Test
	public void LoginTestScenario() {
		keywordengine = new KeyWordEngine();
		keywordengine.startExecution("login");
	}
}
