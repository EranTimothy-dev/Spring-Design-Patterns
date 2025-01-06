package spring.designpatterns.singleton;

// creating singletons in the norma java way
// check the test class for implementation checking
public class SingletonA {

    private static SingletonA instance;

    private SingletonA(){
        super();
    }

    public static SingletonA getInstance(){
        // double-checking to ensure better thread safety when creating an instance of the singleton
        if(instance == null){
            synchronized (SingletonA.class){
                if(instance == null){
                    instance = new SingletonA();
                }
            }
        }
        return instance;
    }

}
