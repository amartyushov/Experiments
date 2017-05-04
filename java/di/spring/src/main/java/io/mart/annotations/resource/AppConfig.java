package io.mart.annotations.resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aleksandr Martiushov
 * Notice @ComponentScan which will make Spring auto detect
 * the annotated beans via scanning the specified package
 * and wire them wherever needed (using @Resource or @Autowired ).
 */
@Configuration
@ComponentScan("io.mart.annotations")
public class AppConfig {

}