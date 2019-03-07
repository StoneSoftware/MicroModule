package org.springboot.springmvc.mybatis.demo.proxy;

public class IntelCpu implements CPU
{
    
    @Override
    public String getCpuType()
    {
        return "Intel CPU";
    }
    
}
