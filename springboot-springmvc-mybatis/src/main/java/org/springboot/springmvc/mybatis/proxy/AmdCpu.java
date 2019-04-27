package org.springboot.springmvc.mybatis.proxy;

public class AmdCpu implements CPU
{
    
    @Override
    public String getCpuType()
    {
        return "AMD CPU";
    }
    
}
