package org.springboot.springmvc.mybatis.proxy;

public class IntelMainboard implements Mainboard
{
    
    @Override
    public String getMainboardType()
    {
        return "Intel Mainboard";
    }
    
}
