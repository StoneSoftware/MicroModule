package org.springboot.springmvc.mybatis.proxy;

public abstract class AbstractFactory
{
    abstract CPU crateCpu();
    
    abstract Mainboard createMainboard();
    
    public void createComputer(){
        crateCpu();
        createMainboard();
    }
}
