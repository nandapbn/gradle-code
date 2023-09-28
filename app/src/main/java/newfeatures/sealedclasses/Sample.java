package newfeatures.sealedclasses;

sealed class A {

}

final class B extends A {

}

final class C extends A {

}

// 🚫 D to extend class A.
class D {

}

public class Sample {

}
