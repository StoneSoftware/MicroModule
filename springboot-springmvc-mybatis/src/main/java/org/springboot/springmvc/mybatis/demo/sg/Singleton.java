package org.springboot.springmvc.mybatis.demo.sg;

public class Singleton
{
    
    private final static Singleton INSTANCE = new Singleton();
    
    private Singleton()
    {
    }
    
    public static Singleton getInstance()
    {
        return INSTANCE;
    }
}
