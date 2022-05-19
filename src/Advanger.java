/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Advanger implements Role,KeyListener
{
    //遊戲
    private Game ctl = null;
    private final GameManager mgr;
    private boolean alive = false;
    private final HpBar hpbar = new HpBar();
    private boolean hit = false;
    //基本設置
    private boolean Advanced = false;
    private Model model = null;
    private int x,y,w,h;//位置、大小
    private final ImageSequence[] character = 
    {
        new ImageSequence("img/Advanger/Stop/Right/Char", "png", 1),
        new ImageSequence("img/Advanger/Stop/Left/Char", "png", 1),
        new ImageSequence("img/Advanger/Move/ToRight/Char", "png", 21),
        new ImageSequence("img/Advanger/Move/ToLeft/Char", "png", 21),
        new ImageSequence("img/Advanger/Jump/ToRight/Char", "png", 9),
        new ImageSequence("img/Advanger/Jump/ToLeft/Char", "png", 9)
    };
    //狀態
    private int status = 0, statustmp = status;//0.StopR 1.StopL 2.RightMove 3.LeftMove
    private boolean walk = false;
    private int Hp = 100;
    //移動
    private Movement jump; //跳、移動
    //動作
    Advanger(Game ctl, GameManager mgr)
    {
        this.ctl = ctl;
        this.mgr = mgr;
    }
    public void setAdcanced()
    {
        if(!Advanced)
        {
            Advanced = true;
        }
        else
        {
            Advanced = false;
        }
    }
    public void notHurt()
    {
        hit = false;
    }
    @Override public void getReady()
    {
        x = 750;
        y = 570;
        w = 112;
        h = 136;
        Hp = 100;
        status = 0;
        hpbar.reload(Hp);
        model = new Model(x,y,w,h);
        jump = new Jump(85);
    }
    @Override public void run()
    {
        jump.updatePos(model);
        x = model.getX();
        y = model.getY();
        if(y>570){y = 570;model.setY(y);jump.setvy(0);}
        if(x<0){x = 0;model.setX(x);jump.setvx(0);}
        else if(x>1550){x = 1550;model.setX(x);jump.setvx(0);}
    }
    @Override public void end()
    {
        ctl.removeRole(this);
    }
    @Override public Model getModel()
    {
        return model;
    }
    @Override public void display(Graphics g)
    {
        g.drawImage(character[status].next(true), x,y, null);
        hpbar.display(g);
    }
    @Override public Effect conflict(Role role,Rectangle rec)
    {
        if(role instanceof Fall)//被Fall類別的東西打到
        {
            if(!Advanced)
            {
                if(!hit)
                {
                    hit = true;
                    this.Hp += ((Fall) role).getHurt();
                }
            }
            hpbar.reload(Hp);
            if(Hp <= 0)
            {
                this.alive = false;
                this.end();
                mgr.SetLevel("Die0");
                mgr.levelUp();
            }
        }
        return null;
    }
    public void Alive()
    {
        alive = true;
    }
    public boolean getAlive()
    {
        return alive;
    }
    @Override public void keyTyped(KeyEvent e)
    {
    }
    @Override public void keyPressed(KeyEvent e)
    {
        if (alive && e.getKeyCode() == KeyEvent.VK_UP && y == 570)
        {
            if(status != 4 && status != 5)statustmp = status;
            if(status == 0)
                status = 4;
            else if(status == 1)
                status = 5;
            jump.setvy(-200);
        }
        else if (alive && e.getKeyCode() == KeyEvent.VK_RIGHT && y == 570)
        {
            status = 2;
            walk = true;
            if(walk)jump.setvx(100);
        }
        else if (alive && e.getKeyCode() == KeyEvent.VK_LEFT && y == 570)
        {
            status = 3;
            walk = true;
            if(walk)jump.setvx(-100);
        }
    }
    @Override public void keyReleased(KeyEvent e)
    { 
        if (alive && e.getKeyCode() == KeyEvent.VK_UP)
        {
            status = statustmp;
            jump.setvy(0);
        }
        else if (alive && e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            status = 0;
            walk = false;
            jump.setvx(0);
        }
        else if (alive && e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            status = 1;
            walk = false;
            jump.setvx(0);
        }
    }
}