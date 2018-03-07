package io.mart.tests;

import com.google.inject.Inject;
import io.mart.Checker;
import io.mart.Executor;
import io.mart.guice.ModuleForTests;
import io.mart.guice.MyModuleFactory;
import org.testng.annotations.Guice;

// it can be also simple @Guice annotation w/o params, if you do not need to use modules

@Guice(moduleFactory = MyModuleFactory.class, modules = {ModuleForTests.class})
class AbstractTestClass {

    @Inject
    Executor executor;
    @Inject
    Checker checker;

}
