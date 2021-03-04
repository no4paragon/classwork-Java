public class Triple<A, B, C> {

    private A first;
    private B second;
    private C third;


    public Triple(A a, B b,C c){
        first = a;
        second = b;
        third = c;
    }

    public A getFirst(){
        return first;
    }

    public B getSecond(){
        return second;
    }

    public C getThird(){
        return third;
    }

}