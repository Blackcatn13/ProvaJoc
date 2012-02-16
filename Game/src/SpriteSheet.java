// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 03/01/2012 10:42:32
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SpriteSheet.java



import java.awt.image.BufferedImage;

public class SpriteSheet
{

    public SpriteSheet(BufferedImage image)
    {
        width = image.getWidth();
        height = image.getHeight();
        pixels = image.getRGB(0, 0, width, height, null, 0, width);
        for(int i = 0; i < pixels.length; i++)
            pixels[i] = (pixels[i]&0xff)/64;
        
    }

    public int width;
    public int height;
    public int pixels[];
}