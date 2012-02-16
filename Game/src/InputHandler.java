// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 03/01/2012 10:42:30
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   InputHandler.java


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

// Referenced classes of package com.mojang.ld22:
//            Game

public class InputHandler
    implements KeyListener
{
    public class Key
    {

        public void toggle(boolean pressed)
        {
            if(pressed != down)
                down = pressed;
            if(pressed)
                presses++;
        }

        public void tick()
        {
            if(absorbs < presses)
            {
                absorbs++;
                clicked = true;
            } else
            {
                clicked = false;
            }
        }

        public int presses;
        public int absorbs;
        public boolean down;
        public boolean clicked;
        final InputHandler this$0;

        public Key()
        {
        	super();
            this$0 = InputHandler.this;
            keys.add(this);
        }
    }


    public void releaseAll()
    {
        for(int i = 0; i < keys.size(); i++)
            ((Key)keys.get(i)).down = false;

    }

    public void tick()
    {
        for(int i = 0; i < keys.size(); i++)
            ((Key)keys.get(i)).tick();

    }

    public InputHandler(GameSource game)
    {
        keys = new ArrayList();
        up = new Key();
        down = new Key();
        left = new Key();
        right = new Key();
        attack = new Key();
        menu = new Key();
        game.addKeyListener(this);
    }

    public void keyPressed(KeyEvent ke)
    {
        toggle(ke, true);
    }

    public void keyReleased(KeyEvent ke)
    {
        toggle(ke, false);
    }

    private void toggle(KeyEvent ke, boolean pressed)
    {
        if(ke.getKeyCode() == 104)
            up.toggle(pressed);
        if(ke.getKeyCode() == 98)
            down.toggle(pressed);
        if(ke.getKeyCode() == 100)
            left.toggle(pressed);
        if(ke.getKeyCode() == 102)
            right.toggle(pressed);
        if(ke.getKeyCode() == 87)
            up.toggle(pressed);
        if(ke.getKeyCode() == 83)
            down.toggle(pressed);
        if(ke.getKeyCode() == 65)
            left.toggle(pressed);
        if(ke.getKeyCode() == 68)
            right.toggle(pressed);
        if(ke.getKeyCode() == 38)
            up.toggle(pressed);
        if(ke.getKeyCode() == 40)
            down.toggle(pressed);
        if(ke.getKeyCode() == 37)
            left.toggle(pressed);
        if(ke.getKeyCode() == 39)
            right.toggle(pressed);
        if(ke.getKeyCode() == 9)
            menu.toggle(pressed);
        if(ke.getKeyCode() == 18)
            menu.toggle(pressed);
        if(ke.getKeyCode() == 65406)
            menu.toggle(pressed);
        if(ke.getKeyCode() == 32)
            attack.toggle(pressed);
        if(ke.getKeyCode() == 17)
            attack.toggle(pressed);
        if(ke.getKeyCode() == 96)
            attack.toggle(pressed);
        if(ke.getKeyCode() == 155)
            attack.toggle(pressed);
        if(ke.getKeyCode() == 10)
            menu.toggle(pressed);
        if(ke.getKeyCode() == 88)
            menu.toggle(pressed);
        if(ke.getKeyCode() == 67)
            attack.toggle(pressed);
    }

    public void keyTyped(KeyEvent keyevent)
    {
    }

    public java.util.List keys;
    public Key up;
    public Key down;
    public Key left;
    public Key right;
    public Key attack;
    public Key menu;
}