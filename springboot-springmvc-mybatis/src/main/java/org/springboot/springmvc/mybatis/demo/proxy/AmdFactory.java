package org.springboot.springmvc.mybatis.demo.proxy;

public class AmdFactory extends AbstractFactory
{
    
    @Override
    public CPU crateCpu()
    {
        AmdCpu amdCpu = new AmdCpu();
        System.out.println(amdCpu.getCpuType());
        return amdCpu;
    }
    
    @Override
    public Mainboard createMainboard()
    {
        AmdMainboard amdMainboard = new AmdMainboard();
        System.out.println(amdMainboard.getMainboardType());
        return amdMainboard;
    }
    
}
