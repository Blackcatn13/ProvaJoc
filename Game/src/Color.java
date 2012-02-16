// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 03/01/2012 10:42:31
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Color.java




public class Color
{

    public Color()
    {
    }

    public static int get(int a, int b, int c, int d)
    {
        return (get(d) << 24) + (get(c) << 16) + (get(b) << 8) + get(a);
    }

    public static int get(int d)
    {
        if(d < 0)
        {
            return 255;
        } else
        {
            int r = (d / 100) % 10;
            int g = (d / 10) % 10;
            int b = d % 10;
            return r * 36 + g * 6 + b;
        }
    }
}