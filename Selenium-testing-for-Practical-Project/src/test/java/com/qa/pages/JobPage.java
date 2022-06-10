package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobPage {
	
	private static final String URL = "http://localhost:8080/job.html";
	private WebDriver driver;
	
	public static String getUrl() {
		return URL;
	}
	
	//create section
	@FindBy(xpath = "/html/body/div[1]/form/input[1]")
	private WebElement createId; //1
	
	@FindBy(xpath = "/html/body/div[1]/form/select")
	private WebElement createJob;
	
	@FindBy(xpath ="/html/body/div[1]/form/select/option[2]")
	private WebElement createJobSelect;
	
	@FindBy(xpath ="/html/body/div[1]/form/select/option[3]")
	private WebElement createJobSelect2;
	
	@FindBy(xpath = "/html/body/div[1]/form/input[2]")
	private WebElement createJobLevel;
	
	@FindBy(xpath = "/html/body/div[1]/form/input[3]")
	private WebElement createCharaId;
	
	@FindBy(id ="createJobButton")
	private WebElement createJobButton;
		
	//read
	@FindBy (id = "showAllJobButton")
	private WebElement readAllButton;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr/td[1]")
	private WebElement tdId;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr[2]/td[1]")
	private WebElement tdId2;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr/td[2]")
	private WebElement tdJob;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr/td[3]")
	private WebElement tdLevel;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr/td[4]")
	private WebElement tdChara;
	
	//read by id 
	@FindBy(id = "readId")
	private WebElement readByIdInput;
	
	@FindBy(id = "readByIdButton")
	private WebElement readByIdButton;
	
	@FindBy(xpath ="/html/body/div[3]/div/table/tr/td[1]")
	private WebElement readbyIdtdid;
	
	@FindBy(xpath ="/html/body/div[3]/div/table/tr/td[2]")
	private WebElement readbyIdtdJob;
	
	@FindBy(xpath ="/html/body/div[3]/div/table/tr/td[3]")
	private WebElement readbyIdtdlevel;
	
	@FindBy(xpath ="/html/body/div[3]/div/table/tr/td[4]")
	private WebElement readbyIdtdChara;
	
	//update
	@FindBy(xpath="/html/body/div[4]/form/input[1]")
	private WebElement updateId;
	
	@FindBy(xpath ="/html/body/div[4]/form/input[2]")
	private WebElement updateLevel;
	
	@FindBy(xpath ="/html/body/div[4]/form/button")
	private WebElement updateButton;
	
	//methods
	
	public void createJob() {
		createId.sendKeys("1");
		createJob.click();
		createJobSelect.click();
		createJobLevel.sendKeys("90");
		createCharaId.sendKeys("1");
		createJobButton.click();
	}
	
	public void createJob2() {
		createId.sendKeys("2");
		createJob.click();
		createJobSelect2.click();
		createJobLevel.sendKeys("70");
		createCharaId.sendKeys("1");
		createJobButton.click();
	}
	
	public void readAll() {
		readAllButton.sendKeys(Keys.ENTER);
	}
	
	public void readById() {
		readByIdInput.sendKeys("1");
		readByIdButton.sendKeys(Keys.ENTER);
	}
	
	public void readById2() {
		readByIdInput.sendKeys("2");
		readByIdButton.sendKeys(Keys.ENTER);
	}
	
	public void update() {
		updateId.sendKeys("2");
		updateLevel.sendKeys("90");
		updateButton.sendKeys(Keys.ENTER);
		
	}
	
	//getters

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateId() {
		return createId;
	}

	public WebElement getCreateJob() {
		return createJob;
	}

	public WebElement getCreateJobSelect() {
		return createJobSelect;
	}

	public WebElement getCreateJobLevel() {
		return createJobLevel;
	}

	public WebElement getCreateCharaId() {
		return createCharaId;
	}

	public WebElement getCreateJobButton() {
		return createJobButton;
	}

	public WebElement getReadAllButton() {
		return readAllButton;
	}

	public WebElement getTdId() {
		return tdId;
	}

	public WebElement getTdJob() {
		return tdJob;
	}

	public WebElement getTdLevel() {
		return tdLevel;
	}

	public WebElement getTdChara() {
		return tdChara;
	}

	public WebElement getCreateJobSelect2() {
		return createJobSelect2;
	}

	public WebElement getReadByIdInput() {
		return readByIdInput;
	}

	public WebElement getReadByIdButton() {
		return readByIdButton;
	}

	public WebElement getReadbyIdtdid() {
		return readbyIdtdid;
	}

	public WebElement getReadbyIdtdJob() {
		return readbyIdtdJob;
	}

	public WebElement getReadbyIdtdlevel() {
		return readbyIdtdlevel;
	}

	public WebElement getReadbyIdtdChara() {
		return readbyIdtdChara;
	}

	public WebElement getTdId2() {
		return tdId2;
	}

	public WebElement getUpdateId() {
		return updateId;
	}

	public WebElement getUpdateLevel() {
		return updateLevel;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}
	
	
	
	
}
