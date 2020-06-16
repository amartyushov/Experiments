package io.mart;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import io.mart.services.EmailService;
import io.mart.services.MockService;
import io.mart.services.PostService;
import io.mart.services.Service;

/**
 * @author Aleksandr Martiushov
 */
public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {

        bind(Service.class).to(EmailService.class);

        bind(Service.class).annotatedWith(Names.named("post")).to(PostService.class);

//        bind(Service.class).toProvider(ServiceProvider.class);
    }

//    @Provides
//    Service provideService(){
//        return new MockService();
//    }


}
