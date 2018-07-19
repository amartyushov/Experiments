package io.mart.packet2;

import io.mart.packet1.NonPublicChild;

public class OtherPackageChildNonPublic /*extends NonPublicClass*/{ // compilation error
}

class NextClass extends NonPublicChild {
	int[] a = new int[10];
	public NextClass() {
		//this.value=7;
	}

	public static void main(String[] args) {
		NonPublicChild nonPublicChildAsNext = new NextClass();
		NonPublicChild nonPublicChild = new NonPublicChild();
		NextClass next = new NextClass();
		System.out.println(nonPublicChildAsNext.getValue());
		System.out.println(nonPublicChild.getValue());
		System.out.println(next.getValue());
	}
}