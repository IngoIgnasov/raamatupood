package ee.ut.cs.wad2018.test2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2ApplicationTests {
    static WebDriver driver;
    String url = "https://raamatupood.herokuapp.com/";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void contextLoads() {
    }


    @Test
    public void veryfyTitle() {
        String title = driver.getTitle();
        assertTrue(title.contains("Raamatupood"));
    }



    @Test
    public void verifyHeading(){
        String expectedsearchHeading = "Raamatupood";
        String actualheading = driver.findElement(By.xpath("html/body/div/h1")).getText();
        assertEquals(expectedsearchHeading,actualheading);
    }

    @After
    public void tearDown() {

        driver.close();
    }
}


    /*


   @Test
    public void veryfyTitle(){
       System.out.println("In Verify Title Test Case ");
       String title = driver.getTitle();
       assertTrue(title.contains("Raamatupood"));
   }

   @Test
    public void verifyHeading(){
       System.out.println("In verify heading text above search test case");
       String expectedsearchHeading = "Raamatupood";
       String actualheading = driver.findElement(By.xpath("html/body/div/h1")).getText();
       assertEquals(expectedsearchHeading,actualheading);
   }

   @AfterClass
    public static void tearDown(){
       driver.quit();
    }
}


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RaamatupoodApplicationTest {

	private final String url = "http://localhost:8080/";
	private WebDriver driver;



	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);

	}



	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void contextLoads() {
	}

}

*/