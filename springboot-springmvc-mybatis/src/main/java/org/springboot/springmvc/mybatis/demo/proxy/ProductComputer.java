package org.springboot.springmvc.mybatis.demo.proxy;

public class ProductComputer
{
    public static void main(String[] args)
    {
        // 组装intel电脑
        AbstractFactory intelFactory = new IntelFactory();
        intelFactory.createComputer();
        
        // 组装amd电脑
        AbstractFactory amdFactory = new AmdFactory();
        amdFactory.createComputer();
    }
    
}
