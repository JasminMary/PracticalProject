package com.qa.tests;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.qa.pages.CharacterPage;

public class CharacterPageTests {
	
	private static WebDriver driver;
	private CharacterPage page;
	
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		driver = new ChromeDriver(); 
	}
	
	@Before
	public void setup() {
		driver.get(CharacterPage.getUrl());
		this.page = PageFactory.initElements(driver, CharacterPage.class);
	}
	
	@Test
	public void createCharacterTest() {
		page.createCharacter();

		page.readAll();
		
		assertEquals("1", page.getTdId().getText());
		assertEquals("Name", page.getTrName().getText());
		assertEquals("Elezen", page.getTdRace().getText());
		assertEquals("The Maelstrom", page.getTdGC().getText());
		assertEquals("guild", page.getTdFC().getText());
		assertEquals("Elemental", page.getTdDC().getText());
		
	}
	@Test
	public void readAllTest() {
		page.createCharacter();
		page.createCharacter2();
		
		page.readAll();
		
		assertEquals("1", page.getTdId().getText());
		assertEquals("2", page.getTdId2().getText());
		
	}
	
	@Test 
	public void readByIdTest() {
		
		page.createCharacter();
		
		page.readById();
		
		assertEquals("1", page.getReadbyIdtdid().getText());
		assertEquals("Name", page.getReadbyIdtdName().getText());
		assertEquals("Elezen", page.getReadbyIdtdRace().getText());
		assertEquals("The Maelstrom", page.getReadbyIdtdGC().getText());
		assertEquals("guild", page.getReadbyIdtdFC().getText());
		assertEquals("Elemental", page.getReadbyIdtdDC().getText());
		
	}
	
	@Test
	public void updateTest() {
		
		page.createCharacter2();
		
		page.update();
		
		page.readById2();
		
		//if time add the rest
		assertEquals("2", page.getReadbyIdtdid().getText());
		assertEquals("New name", page.getReadbyIdtdName().getText());
		
	}
	
//	@Test
//	public void deleteTest() {
//		page.delete();
//		
//		page.readAll();
//		
//		assertElementNOTPresent(
//	}
//	
	
	@AfterClass
	public static void end() {
		driver.close();
		driver.quit();
	}
	

}
