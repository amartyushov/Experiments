package io.mart.packet1;

public class SamePackageSubclass extends BaseClass {

	public SamePackageSubclass() {
		this.defaultValue = 2;
		this.protectedValue = 2;

		BaseClass baseClass = new BaseClass();
		baseClass.defaultValue = 3;
		baseClass.protectedValue = 3;
	}
}
