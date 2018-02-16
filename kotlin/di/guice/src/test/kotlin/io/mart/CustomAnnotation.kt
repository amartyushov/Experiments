package io.mart

import com.google.inject.ScopeAnnotation


@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@ScopeAnnotation
annotation class BatchScoped