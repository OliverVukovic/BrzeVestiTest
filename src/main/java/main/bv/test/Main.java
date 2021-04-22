package main.bv.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/Asus/Desktop/home-workspace/chromedriver.exe");       
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");
        
        
         // create new category 

       // precondition: user is logged in 
       // 1. go on Categories page
       // 2. click on button "add category"
       // 3. enter unique title in title field
       // 4. click on save button
       // expeted result >
       // - user is redirected to categories page
       // - confirmation massage is shown "Category "title" has been succesfully saved!"
       // - new category is listed as the last element in table
       
       // Precondition        
         // find element field by Name locator
        WebElement emailField = driver.findElement(By.name("email"));
         // enter email into email field 
        emailField.sendKeys("qa@cubes.rs");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("cubesqa");

        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();    
        
        
       // Go on Categories page
        WebElement navCategory = driver.findElement(By.linkText("Categories"));
        navCategory.click();
        
       // Click on button "add category"
        WebElement addNewCategoryButton = driver.findElement(By.className("pull-right"));
        addNewCategoryButton.click();
        
       // Enter unique title in title field
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys("Oliver");
        
       // Click on save button
        WebElement saveButton = driver.findElement(By.id("save-category-button"));
        saveButton.click();
        
        
       // Expeted result
        String expectedResult = "Category \"title\" has been succesfully saved!";
        String actualResult = driver.findElement(By.className("alert-success")).getText();
        
        if (expectedResult.equals(actualResult)) {
            System.out.println("Test je prosao!");
        }else {
        System.out.println("Test nije prosao!");
        
        }
    }
}
