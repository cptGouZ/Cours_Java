package _30_Design_Patterns.Singleton;

public class Singleton {
    private static Singleton singleton = null;
    private Singleton(){ }
    public static Singleton getInstance(){
        if (singleton==null)
            singleton = new Singleton() ;
        return singleton;
    }
}
