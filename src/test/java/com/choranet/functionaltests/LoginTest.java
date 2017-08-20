/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.choranet.functionaltests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome /opt/firefox21/firefox", "http://localhost:9999/choraerp/");
		selenium.start();
	}

	@Test
	public void testLogin() throws Exception {
		selenium.open("/choraerp/");
		assertTrue(selenium.isTextPresent("Veillez changer le mot de passe par défaut de l'administrateur"));
		selenium.type("id=zk_comp_8", "test");
		selenium.type("id=zk_comp_11", "test");
		selenium.click("id=zk_comp_14");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Login et/ou mot de passe incorrect(s)"));
		selenium.type("id=zk_comp_8", "admin");
		selenium.click("id=zk_comp_14");
		selenium.waitForPageToLoad("30000");
		assertEquals("CHORA ERP", selenium.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
