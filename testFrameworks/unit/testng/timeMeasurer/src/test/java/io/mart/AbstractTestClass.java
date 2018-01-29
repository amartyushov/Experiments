package io.mart;

import io.mart.analyser.CustomListener;
import org.testng.annotations.Listeners;

@Listeners({CustomListener.class})
//@Listeners({CustomListener.class, MyListener.class})
public class AbstractTestClass {
}
