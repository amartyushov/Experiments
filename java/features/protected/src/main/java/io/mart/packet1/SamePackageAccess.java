package io.mart.packet1;

public class SamePackageAccess {
	public SamePackageAccess() {
		BaseClass baseClass = new BaseClass();
		baseClass.defaultValue = 2;
		baseClass.protectedValue = 2;
	}
}
