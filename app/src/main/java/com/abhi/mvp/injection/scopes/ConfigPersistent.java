package com.abhi.mvp.injection.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Abhishek Prajapati
 * @version 1.0.0
 * @since 12/16/17.
 *
 * A scoping annotation to permit dependencies conform to the life of the {@link
 * ConfigPersistentComponent}
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigPersistent {
}
