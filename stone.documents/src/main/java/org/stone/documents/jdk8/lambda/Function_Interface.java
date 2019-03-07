package org.stone.documents.jdk8.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import org.stone.documents.extend.R;
import org.stone.documents.extend.T;
import org.stone.documents.extend.U;

public class Function_Interface
{
    /*************************************************************************/
    /********************************* 一个入参 *******************************/
    /*************************************************************************/
    
    /***************** Function<T,R> *****************/
    public Function<T, R> f1 = null;
    
    // Int、Long、Double
    public IntFunction<R> f2 = null;
    
    public LongFunction<R> f3 = null;
    
    public DoubleFunction<R> f4 = null;
    
    // To Int、To Long、To Double
    public ToIntFunction<T> f5 = null;
    
    public ToLongFunction<T> f6 = null;
    
    public ToDoubleFunction<T> f7 = null;
    
    // Int to Long 、Int to Double
    public IntToLongFunction f8 = null;
    
    public IntToDoubleFunction f9 = null;
    
    // Long to Int 、Long to Double
    public LongToIntFunction f10 = null;
    
    public LongToDoubleFunction f11 = null;
    
    // Double to Int 、Double to Double
    public DoubleToIntFunction f12 = null;
    
    public DoubleToLongFunction f13 = null;
    
    /***************** Predicate<T> *****************/
    public Predicate<T> p1 = null;
    
    // Int、Long、Double
    public IntPredicate p2 = null;
    
    public LongPredicate p3 = null;
    
    public DoublePredicate p4 = null;
    
    /***************** Consumer<T> *****************/
    public Consumer<T> c1 = null;
    
    // Int、Long、Double
    public IntConsumer c2 = null;
    
    public LongConsumer c3 = null;
    
    public DoubleConsumer c4 = null;
    
    /***************** Supplier<T> *****************/
    public Supplier<T> s1 = null;
    
    // Int、Long、Double
    public IntSupplier s2 = null;
    
    public LongSupplier s3 = null;
    
    public DoubleSupplier s4 = null;
    
    /*************************************************************************/
    /********************************* 两个入参 *******************************/
    /*************************************************************************/
    
    public BiFunction<T, U, R> bf = null;
    
    public ToDoubleBiFunction<T, U> tb = null;
    public ObjLongConsumer a=null;
    public IntUnaryOperator   x=null;
    
    public BiPredicate<T, U> bp = null;
    
    public BiConsumer<T, U> bc = null;
    
    public BinaryOperator<T> bo = null;// 等价BiFunction<T,T,T>
    
    public DoubleBinaryOperator db = null;// 等价BiFunction<Double,Double,Double>
    
    public static void main(String[] args)
    {
        
    }
    
}
