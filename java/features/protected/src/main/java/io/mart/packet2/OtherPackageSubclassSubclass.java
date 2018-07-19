package io.mart.packet2;

import io.mart.packet1.BaseClass;

public class OtherPackageSubclassSubclass extends OtherPackageSubclass {
	public OtherPackageSubclassSubclass() {
		this.protectedValue = 20;
	}

	public static void main(String[] args) {
		OtherPackageSubclassSubclass a = new OtherPackageSubclassSubclass();
		OtherPackageSubclass b = new OtherPackageSubclassSubclass();
		OtherPackageSubclass e = new OtherPackageSubclass();
		BaseClass c = new OtherPackageSubclassSubclass();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(e);
	}
}
