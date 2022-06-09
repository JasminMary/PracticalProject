package com.qa.tests;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.JobPage;

public class JobPageTest {
	
	private static WebDriver driver;
	private JobPage page;
	
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		driver = new ChromeDriver(); 
	}
	
	@Before
	public void setup() {
		driver.get(JobPage.getUrl());
		this.page = PageFactory.initElements(driver, JobPage.class);
	}
	
	@Test
	public void createJobTest() {
		page.createJob();
		
		page.readAll();
		
		assertEquals("1", page.getTdId().getText());
		assertEquals("Paladin", page.getTdJob().getText());
		assertEquals("90", page.getTdLevel().getText());
		assertEquals("1", page.getTdId().getText());
		
	}
	
	@Test
	public void readByIdTest() {
		page.createJob();
		
		page.readById();
		
		assertEquals("1", page.getReadbyIdtdid().getText());
		assertEquals("Paladin", page.getReadbyIdtdJob().getText());
		assertEquals("90", page.getReadbyIdtdlevel().getText());
		assertEquals("{\"id\":1,\"name\":\"Name\",\"race\":\"Elezen\",\"grandCompany\":\"The Maelstrom\",\"freeCompany\":\"guild\",\"datacentre\":\"Elemental\"}", page.getReadbyIdtdChara().getText());
	}
	
	@Test
	public void readAll() {
		page.createJob();
		page.createJob2();
		
		page.readAll();
		
		assertEquals("1", page.getTdId().getText());
		assertEquals("2", page.getTdId2().getText());
	}
	@Test
	public void updateTest() {
		page.createJob2();
		
		page.update();
		
		page.readById2();
		
		assertEquals("2", page.getReadbyIdtdid().getText());
		assertEquals("90", page.getReadbyIdtdlevel().getText());
	}
	
	
	
	@AfterClass
	public static void end() {
		driver.close();
		driver.quit();
	}

}
