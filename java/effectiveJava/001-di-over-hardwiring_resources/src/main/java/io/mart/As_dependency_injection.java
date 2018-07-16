package io.mart;

import io.mart.bad.practice.Your_dependency;

import java.util.Objects;

public class As_dependency_injection {

	private final Your_dependency dependency;

	public As_dependency_injection(Your_dependency dependency) {
		this.dependency = Objects.requireNonNull(dependency);
	}

	// methods
}
