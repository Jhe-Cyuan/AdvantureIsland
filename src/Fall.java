/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
import java.util.Random;
import java.awt.*;
public abstract class Fall /*extends Effect*/ implements Role
{
    //遊戲
    private final Game ctl;
    //基本設置
    private Model model = null;
    private final Random rd = new Random();
    private ImageSequence fall;
    private int x,y,w,h;//位置、大小
    private int hurt;
    //移動
    private Movement jump; //跳、移動
    //動作
    public abstract ImageSequence setImg();
    Fall(Game ctl, int hurt)
    {
        this.ctl = ctl;
        fall = setImg();
        this.hurt = hurt;
    }
    public abstract int setW();
    public abstract int setH();
    @Override public void getReady()
    {
        x = rd.nextInt(1646);
        y = 0;
        w = setW();
        h = setH();
        model = new Model(x,y,w,h);
        jump = new Jump();
    }
    @Override public void run()
    {
        jump.updatePos(model);
        x = model.getX();
        y = model.getY();
        if(y>1000)
        {
            end();
        }
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
        g.drawImage(fall.next(true), x, y, null);
    }
    public void Hit()
    {
        hurt = 0;
    }
    public int getHurt()
    {
        return hurt;
    }
    @Override public abstract Effect conflict(Role role, Rectangle rec);
}