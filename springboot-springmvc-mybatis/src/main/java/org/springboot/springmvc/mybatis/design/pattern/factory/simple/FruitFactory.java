package org.springboot.springmvc.mybatis.design.pattern.factory.simple;

public class FruitFactory
{
    public Fruits getFruit(String name)
    {
        if ("apple".equals(name))
        {
            return new Apple();
        }
        else if ("banana".equals(name))
        {
            return new Banana();
        }
        else if ("pear".equals(name))
        {
            return new Pear();
        }
        return null;
    }
}
