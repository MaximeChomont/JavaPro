package modele.impl;

import inject.annotations.Singleton;
import modele.inter.ILogger;

@Singleton
public class LoggerTest implements ILogger{
    private static boolean beforeWorked = false;
    private static boolean afterWorked = false;
    /*DEFAULT CONSTRUCTOR*/
    public LoggerTest() {

    }
    /*GETTERS*/
    public static boolean isAfterWorked() {
        return afterWorked;
    }
    public static boolean isBeforeWorked() {
        return beforeWorked;
    }
    /*SETTERS*/

    public void setAfterWorked(boolean afterWorked) {
        this.afterWorked = afterWorked;
    }

    public void setBeforeWorked(boolean beforeWorked) {
        this.beforeWorked = beforeWorked;
    }
    /*METHODS*/
    @Override
    public void before() {
        beforeWorked = true;
        System.out.println("Before");
    }

    @Override
    public void after() {
        afterWorked  = true;
        System.out.println("After");
    }

    public void initialiseLogger(){
        beforeWorked = false;
        afterWorked  = false;
    }

}
