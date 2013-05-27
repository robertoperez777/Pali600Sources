package com.certpal;

public class Dream    
{
    public static void main(String... args)
    {
        System.out.println(PinSize.BIG == PinSize.BIGGER); // #1
        System.out.println(PinSize.BIG.equals(PinSize.BIGGER));// #2
        //System.out.println(PinSize.BIG > PinSize.BIGGERER);// #3 Compilation fail
        System.out.println(PinSize.BIG.toString().equals(PinSize.BIGGER));// #4
        PinSize b = PinSize.BIG ;
        System.out.println( b instanceof Comparable);// #5
    }  
}
enum PinSize { BIG, BIGGER, BIGGERER }; 
