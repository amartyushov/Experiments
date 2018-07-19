package io.mart.packet2;

import io.mart.packet1.BaseClass;

public class OtherPackageSubclass extends BaseClass{
	public OtherPackageSubclass() {
		//this.defaultValue = 10; // compilation error.
		this.protectedValue = 10;

		BaseClass baseClass = new BaseClass();
		//baseClass.protectedValue = 10;  // compilation error

	}
}
