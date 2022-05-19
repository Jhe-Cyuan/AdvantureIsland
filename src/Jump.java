/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
public class Jump implements Movement
{
    //基本設置
    private final double gx = 0;
    private final double gy;
    private double vx;
    private final double O_vx;
    private double vy;
    private final double O_vy;
    private final double dt = 0.4;
    //動作
    Jump()
    {
        this.vx  =  0;
        this.vy  =  0;
        O_vx = vx;
        O_vy = vy;
        gy = 50;
    }
    Jump(double gy)
    {
        this.vx  =  0;
        this.vy  =  0;
        O_vx = vx;
        O_vy = vy;
        this.gy = gy;
    }
    Jump(double vx,double vy,double gy)
    {
        this.vx  =  vx;
        this.vy  =  vy;
        O_vx = vx;
        O_vy = vy;
        this.gy = gy;
    }
    @Override public void reset()
    {
        vx = O_vx;
        vy = O_vy;
    }      
    @Override public Model updatePos(Model model)
    {
        vx += gx*dt;
        vy += gy*dt;
        int curX = model.getX();
        int curY = model.getY();
        model.setState((int)(curX + (vx*dt+gx*dt*dt*0.5)), (int)(curY + (vy*dt+gy*dt*dt*0.5)));
        return model;
    }
    @Override public void setvx(double i)
    {
        vx = i;
    }
    @Override public void setvy(double i)
    {
        vy = i;
    }
}