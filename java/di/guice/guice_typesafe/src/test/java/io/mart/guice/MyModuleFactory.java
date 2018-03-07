package io.mart.guice;

import com.github.racc.tscg.TypesafeConfigModule;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.testng.IModuleFactory;
import org.testng.ITestContext;

//https://github.com/racc/typesafeconfig-guice
public class MyModuleFactory implements IModuleFactory{

    @Override
    public Module createModule(ITestContext context, Class<?> testClass) {
        return TypesafeConfigModule.fromConfigWithPackage(
                ConfigWrapper.getConfig(), "io.mart");
    }
}
