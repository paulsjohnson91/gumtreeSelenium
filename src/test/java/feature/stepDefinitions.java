package feature;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.junit.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import setup.seleniumSetup;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class stepDefinitions extends seleniumSetup {

    private List<WebElement> results;
    private List<WebElement> gumtreeResults;

    @After
    public void closeSelenium(){
        driver.quit();
    }

    @Given("we have connected to google")
    public void launchSelenium() {
        prepareSeleniumWebdriver();
        driver.get("http://www.google.co.uk");
    }

    @And("we search for 'cars in london'")
    public void searchGoogle() {
        driver.findElement(By.id("lst-ib")).sendKeys("Cars in London");
        driver.findElement(By.cssSelector(".jsb > center:nth-child(1) > input:nth-child(1)")).click();


    }

    @Given("we can see search results from gumtree")
    public void viewResults(){
        results = driver.findElements(By.className("r"));
        gumtreeResults = new ArrayList<WebElement>();
        boolean gumtreeFound = false;
        for(WebElement r : results){
            if(r.getText().contains("Gumtree")){
                gumtreeFound = true;
                System.out.println("Gumtree result found: " + r.getText());
                gumtreeResults.add(r);
            }
        }
        Assert.assertTrue(gumtreeFound);
    }

    @Then("^we can verify the title of each link$")
    public void verifyTitle(){
        for(int i=0; i<gumtreeResults.size(); i++){
            List<WebElement> allresults = driver.findElements(By.className("r"));
            List<WebElement> gumtreeresults = new ArrayList<WebElement>();
            for(WebElement r :allresults){
                if(r.getText().contains("Gumtree")){
                    gumtreeresults.add(r);
                }
            }
            gumtreeresults.get(i).click();
            System.out.println("Title found on page: " + driver.findElement(By.cssSelector(".h1-responsive")).getText());
            driver.navigate().back();

        }
    }




}
