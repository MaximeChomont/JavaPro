package modele.impl;

import annotations.Log;
import inject.annotations.Singleton;
import modele.inter.ILogClassTest;


@Singleton
@Log
public class LogClassTest implements ILogClassTest {
    @Log
    @Override
    public void logMethod() {
        System.out.println("LogMethod");
    }
}
