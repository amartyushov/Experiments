package io.mart;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.mart.services.MockService;
import io.mart.services.Service;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Aleksandr Martiushov
 */
public class MyApplicationTest {

    private Injector injector;

    @BeforeTest
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Service.class).to(MockService.class);
            }
        });
    }

    @Test
    public void test(){
        MyApplication app = injector.getInstance(MyApplication.class);
        assertEquals(true, app.sendMessage());
    }

}