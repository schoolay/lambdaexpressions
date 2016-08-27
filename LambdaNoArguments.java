package Java8;

/**
 * Hello world!
 *
 */
public class LambdaNoArguments
{
    public static void main( String[] args )
    {
        MyInterface myInterface = () -> {
            for(int i = 0; i < 4 ; i++){
                System.out.println("Printing on a new line");
            }
        };

clientClass clientClass = new clientClass();
clientClass.helloWorld(myInterface);

    }
}

interface MyInterface{
    public void doSomething();
}

class clientClass {
    public void helloWorld(MyInterface myInterface){
        myInterface.doSomething();
    }
}
