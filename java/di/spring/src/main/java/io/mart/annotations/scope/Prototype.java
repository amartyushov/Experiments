package io.mart.annotations.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksandr Martiushov.
 */
@Component
@Scope("prototype")
public class Prototype {
}
