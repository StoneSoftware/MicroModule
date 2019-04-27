package org.springboot.springmvc.mybatis.proxy;

public class IntelFactory extends AbstractFactory
{
    
    public CPU crateCpu()
    {
        IntelCpu intlCpu = new IntelCpu();
        System.out.println(intlCpu.getCpuType());
        return intlCpu;
    }
    
    public Mainboard createMainboard()
    {
        IntelMainboard intelMainboard = new IntelMainboard();
        System.out.println(intelMainboard.getMainboardType());
        return intelMainboard;
    }
    
}
