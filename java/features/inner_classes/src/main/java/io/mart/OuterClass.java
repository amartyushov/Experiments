package io.mart;

public class OuterClass {

	OuterClass.StaticNestedClass staticNestedClass = new StaticNestedClass();

	OuterClass outerObject = new OuterClass();
	OuterClass.InnerClass innerObject = outerObject.new InnerClass();

	class InnerClass {
		// have access to members of enclosed class, even if they are private
		// As with instance methods and variables, an inner class is associated with an instance of its enclosing class and has direct access to that object's methods and fields.
		// an inner class is associated with an instance, it cannot define any static members itself.
		// An instance of InnerClass can exist only within an instance of OuterClass
		// There are two special kinds of inner classes: local classes and anonymous classes.
	}

	static class StaticNestedClass {
		// do not have access to other members of enclosed class
		// like static class methods, a static nested class cannot refer directly to instance variables or methods defined in its enclosing class:
		// it can use them only through an object reference.

		//  A static nested class interacts with the instance members of its outer class (and other classes) just like any other top-level class.
		// In effect, a static nested class is behaviorally a top-level class that has been nested in another top-level class for packaging convenience.
	}
}


class Shadowing {

	public int x = 0;

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("ShadowTest.this.x = " + Shadowing.this.x);
		}
	}

	public static void main(String... args) {
		Shadowing st = new Shadowing();
		Shadowing.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
}