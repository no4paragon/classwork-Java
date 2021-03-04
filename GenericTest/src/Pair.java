public class Pair<A,B> {

    private A first;
    private B second;

    //Constructor to force used to pass in initial values.
    public Pair(A a, B b){
        first = a;
        second = b;

    }

    public A getFirst(){
        return first;
    }

    public B getSecond(){
        return second;
    }

}
