- Abstract complex elements in separate class, encapsulates it and provides api for it

- If several components are used of different pages, you can build pages by combining these components.  
So create components with locators and methods, and use them as a building blocks for pages

- It can be a practice to store locators in separate files with a format  
```
LoginPage.loginButton=css=input[value=Login]
```    
And later create a parcer for it

- It is convenient to have a fluent api for pages.

- If there is a hardcoded test data in test input => externalise it to a config file to be able to switch 
between environments
```
staging {
    userLogin=AAA
    userPass=BBB
}
qa {
    userLogin=CCC
    userPass=DDD    
}
```

- Preferred selector order : id > name >links text> css > xpath  
CSS and XPath are location based selectors, they are slower than other selectors.

- Tests should be ordered
```java
import org.junit.runners.MethodSorters;  

//Running tests in order of method names in ascending order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//Running tests in order of method names in ascending order
@FixMethodOrder(MethodSorters.JVM)
```

- Log test name
```java
import org.junit.rules.TestName;

@Rule
public TestName name = new TestName();

//example usage; writes every test name before it runs.
@Before
public void logBeforeTestsStart() {
    log.info(name.getMethodName());
}
```

- Do not use magic strings
```java
// Don't use, create Constants each element name
WebElement element = driver.findElement(By.name("sample"));
```

- @CacheLookup can be useful to annotate WebElement
