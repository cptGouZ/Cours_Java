package _70_JUnit5;

import lombok.Setter;

public class App {
    @Setter
    private int b;
    public int divide(int a){
        return a/b;
    }
}
