package com.certpal;

public class One 
{
    final Integer y=10;

	class two
    {
        final int x;
        public two()
        {
            x = 10;
            class ten
            {
                int x = 11;
            }
        }
    }
    public int get()
    {
        two two2 = new two();
        return two2.x;
    }
    public static void main(String [] args)
    {
        One one = new One();
        System.out.println(one.y + one.get()); //Result: 20   (10 +10)         
    }
}