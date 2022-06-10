<h1>Final Fantasy XIV Practical Project</h1>

**Introduction**

The objective of this project was to create a fully functional CRUD application for a relational database with at least 2 entities. I did this with the utilisation of supporting tools, methodologies and technologies that we've learned over the last several weeks at the academy.

I decided to use the subject of Final Fantasy XIV,  as not only is it my most played game but also characters in the game can have multiple jobs, providing me with a basis for a relational database.  The Information is then stored in a database, with an API to manage requests to and from the database, and has a front end for user interactions.

**What was used for the project:**

>-A Jira board for project management

>-Git & GitHub for version source control

>-Java and Spring Boot for the creation of a restful API

>-JUnit and Mockito for unit and integration testing.

>-SonarQube for code analysis.

>-HTML, CSS and JavaScript for the front-end application, with Bootstrap.

>-Selenium for automated Testing.


**Project Management:**

Link to jira board: https://jasminw.atlassian.net/jira/software/projects/FSPP/boards/4/backlog

I created epics of Create, Read, Update and Delete for my backlog entries. Each entry had a priority and a story point estimate attached to them. For the story point estimates I used the fibonacci sequence, as I like that the numbers are exponential. Below is a screenshot of my Jira backlog:

![Jira board](https://user-images.githubusercontent.com/89535920/173086295-f280be4b-ea64-4708-be62-482b86aa0122.png)




**Database:**

Below is an ERD to show the relationship between the entities:

![FF14 ERD after](https://user-images.githubusercontent.com/89535920/173085921-c4e7208c-0b93-4ec1-a687-93b002c514b9.png)


**Java back-end Design:**

Below is a UML of the back-end showing the relationship between classes:

![FF14PP uml](https://user-images.githubusercontent.com/89535920/173085979-343d4b8f-b69b-4400-8c30-98eb7a167eba.png)






**Testing:**

For the Java back-end, integration tests used JUnit and MockMVC to test the functionality of the API, and Mockito was used for unit testing the service classes.
The below screenshots show all of my tests passing and my coverage of the back-end classes.

![Junit tests](https://user-images.githubusercontent.com/89535920/173086242-2e70d9e7-be5f-4233-9094-a6685c7680fa.png)
![Coverage](https://user-images.githubusercontent.com/89535920/173086260-83cd8ae7-8b27-4be3-b1cb-04d2cc77c303.png)




I also created automated tests using selenium for my front-end using the page object model. These black-box tests would recreate user interaction and check the response.

![seleniumchara](https://user-images.githubusercontent.com/89535920/173086523-803ef8df-6377-482c-ad86-4c696fa23dd7.png)
![seleniumjob](https://user-images.githubusercontent.com/89535920/173086552-8df934cf-3a96-4fda-8c91-92552ad1432b.png)




**Front-end:**

This was built using HTML, CSS and JavaScript. The webpages have forms to create, read, update and delete a character or job, with a button to submit. The read sections return the data in a table format. A character does need to be present in the database in order to be able to create a job, so the character page button is placed higher than the job page button on the home page.

![fechara](https://user-images.githubusercontent.com/89535920/173086717-7405ec90-9017-4ce3-9d3f-a98e92016a5b.png)
![fejob](https://user-images.githubusercontent.com/89535920/173086734-f0f277d3-a169-4b9b-95d8-785f1a1dbe5d.png)



**Continued Development:**

-Add find by character name functionality so users can find by their characters name rather than remembering their Id number.

-Add another entity for raid/story progression. 

-Aesthetic improvements to the front-end and linking the character and job page rather than going through the home page.

