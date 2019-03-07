package org.springboot.springmvc.mybatis.demo.proxy;

public abstract class AbstractFactory
{
    abstract CPU crateCpu();
    
    abstract Mainboard createMainboard();
    
    public void createComputer(){
        crateCpu();
        createMainboard();
    }
}
