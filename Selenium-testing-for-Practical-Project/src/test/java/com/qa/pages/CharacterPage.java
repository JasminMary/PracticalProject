package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CharacterPage {
	
	private static final String URL = "http://localhost:8080/character.html";
	private WebDriver driver;
	
	public static String getUrl() {
		return URL;
	}
	
	//create section
	@FindBy(xpath = "/html/body/div[1]/form/input[1]")
	private WebElement createId; //1
	
	@FindBy(xpath = "/html/body/div[1]/form/input[2]")
	private WebElement createName; //Name
	
	@FindBy (xpath = "/html/body/div[1]/form/select[1]")
	private WebElement createRace;
	
	@FindBy (xpath = "/html/body/div[1]/form/select[1]/option[3]")
	private WebElement selectCreateRace; //Elezen
	
	@FindBy (xpath = "/html/body/div[1]/form/select[2]")
	private WebElement createGC; 
	
	@FindBy (xpath = "/html/body/div[1]/form/select[2]/option[2]")
	private WebElement selectCreateGC; //The Maelstrom
	
	@FindBy (xpath = "/html/body/div[1]/form/input[3]")
	private WebElement createFC; //guild
	
	@FindBy (xpath = "/html/body/div[1]/form/select[3]")
	private WebElement createDC;
	
	@FindBy (xpath = "/html/body/div[1]/form/select[3]/option[2]")
	private WebElement selectCreateDC; //Elemental
	
	@FindBy (id = "createCharacterButton")
	private WebElement submitCreate;
	
	//read all section
	@FindBy (id = "showAllCharactersButton")
	private WebElement readAllButton;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr/td[1]")
	private WebElement tdId;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr[2]/td[1]")
	private WebElement tdId2;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr/td[2]")
	private WebElement trName;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr/td[3]")
	private WebElement tdRace;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr/td[4]")
	private WebElement tdGC;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr/td[5]")
	private WebElement tdFC;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr/td[6]")
	private WebElement tdDC;

	//read by id
	@FindBy(id = "readId")
	private WebElement readByIdInput;
	
	@FindBy(id = "readByIdButton")
	private WebElement readByIdButton;
	
	@FindBy(xpath ="/html/body/div[3]/div/table/tr/td[1]")
	private WebElement readbyIdtdid;
	
	@FindBy(xpath ="/html/body/div[3]/div/table/tr/td[2]")
	private WebElement readbyIdtdName;
	
	@FindBy(xpath ="/html/body/div[3]/div/table/tr/td[3]")
	private WebElement readbyIdtdRace;
	
	@FindBy(xpath ="/html/body/div[3]/div/table/tr/td[4]")
	private WebElement readbyIdtdGC;
	
	@FindBy(xpath ="/html/body/div[3]/div/table/tr/td[5]")
	private WebElement readbyIdtdFC;
	
	@FindBy(xpath ="/html/body/div[3]/div/table/tr/td[6]")
	private WebElement readbyIdtdDC;
	
	//update
	@FindBy(xpath ="/html/body/div[4]/form/input[1]")
	private WebElement updateId;
	
	@FindBy(xpath ="/html/body/div[4]/form/input[2]")
	private WebElement updateName;
	
	@FindBy(xpath ="/html/body/div[4]/form/button")
	private WebElement updateButton;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr[2]/td[1]")
	private WebElement tdUpdateId;
	
	@FindBy(xpath ="/html/body/div[2]/div/table/tr[2]/td[2]")
	private WebElement tdUpdateName;
	
	@FindBy(xpath = "/html/body/div[5]/form/input")
	private WebElement deleteId;
	
	@FindBy(xpath = "/html/body/div[5]/form/button")
	private WebElement deleteIdButton;
	


	public void createCharacter() {
		
		createId.sendKeys("1");
		createName.sendKeys("Name");
		createRace.click();
		selectCreateRace.click();
		createGC.click();
		selectCreateGC.click();
		createFC.sendKeys("guild");
		createDC.click();
		selectCreateDC.click();
		submitCreate.click();
			
	}
	
	public void createCharacter2() {
		
		createId.sendKeys("2");
		createName.sendKeys("Name");
		createRace.click();
		selectCreateRace.click();
		createGC.click();
		selectCreateGC.click();
		createFC.sendKeys("guild");
		createDC.click();
		selectCreateDC.click();
		submitCreate.click();
			
	}
	
	public void readAll() {
		readAllButton.sendKeys(Keys.ENTER);
	}
	
	public void readById() {
		
		readByIdInput.sendKeys("1");
		readByIdButton.sendKeys(Keys.ENTER);
		
	}
	
	public void update() {
		
		updateId.sendKeys("2");
		updateName.sendKeys("New name");
		updateButton.sendKeys(Keys.ENTER);
		
	}
	public void readById2() {
		
		readByIdInput.sendKeys("2");
		readByIdButton.sendKeys(Keys.ENTER);
		
	}
	
	public void delete() {
		deleteId.sendKeys("2");
		deleteIdButton.sendKeys(Keys.ENTER);
	}
	
	//getters

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateId() {
		return createId;
	}

	public WebElement getCreateName() {
		return createName;
	}

	public WebElement getCreateRace() {
		return createRace;
	}

	public WebElement getSelectCreateRace() {
		return selectCreateRace;
	}

	public WebElement getCreateGC() {
		return createGC;
	}

	public WebElement getSelectCreateGC() {
		return selectCreateGC;
	}

	public WebElement getCreateFC() {
		return createFC;
	}

	public WebElement getCreateDC() {
		return createDC;
	}

	public WebElement getSelectCreateDC() {
		return selectCreateDC;
	}

	public WebElement getSubmitCreate() {
		return submitCreate;
	}

	public WebElement getReadAllButton() {
		return readAllButton;
	}

	public WebElement getReadByIdInput() {
		return readByIdInput;
	}

	public WebElement getReadByIdButton() {
		return readByIdButton;
	}

	public WebElement getTdId() {
		return tdId;
	}

	public WebElement getTrName() {
		return trName;
	}

	public WebElement getTdRace() {
		return tdRace;
	}

	public WebElement getTdGC() {
		return tdGC;
	}

	public WebElement getTdFC() {
		return tdFC;
	}

	public WebElement getTdDC() {
		return tdDC;
	}

	public WebElement getReadbyIdtdid() {
		return readbyIdtdid;
	}

	public WebElement getReadbyIdtdName() {
		return readbyIdtdName;
	}

	public WebElement getReadbyIdtdRace() {
		return readbyIdtdRace;
	}

	public WebElement getReadbyIdtdGC() {
		return readbyIdtdGC;
	}

	public WebElement getReadbyIdtdFC() {
		return readbyIdtdFC;
	}

	public WebElement getReadbyIdtdDC() {
		return readbyIdtdDC;
	}
	
	public WebElement getUpdateId() {
		return updateId;
	}

	public WebElement getUpdateName() {
		return updateName;
	}
	
	
	public WebElement getUpdateButton() {
		return updateButton;
	}

	public WebElement getTdUpdateId() {
		return tdUpdateId;
	}

	public WebElement getTdUpdateName() {
		return tdUpdateName;
	}

	public WebElement getDeleteId() {
		return deleteId;
	}

	public WebElement getDeleteIdButton() {
		return deleteIdButton;
	}

	public WebElement getTdId2() {
		return tdId2;
	}
	
	
	
}
