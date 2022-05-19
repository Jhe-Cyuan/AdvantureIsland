/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
import java.awt.*;
public class HpBar implements Role
{
    //基本設置
    private Model model = null;
    private ImageSequence Bar = new ImageSequence("img/Advanger/HP/HP10","png",1);
    private int x,y,w,h;//位置、大小
    //動作
    public void reload(int Hp)
    {
        switch(Hp / 10)
        {
            case 10:
                Bar = new ImageSequence("img/Advanger/HP/HP10","png",1);
                break;
            case 9:
                Bar = new ImageSequence("img/Advanger/HP/HP9","png",1);
                break;
            case 8:
                Bar = new ImageSequence("img/Advanger/HP/HP8","png",1);
                break;
            case 7:
                Bar = new ImageSequence("img/Advanger/HP/HP7","png",1);
                break;
            case 6:
                Bar = new ImageSequence("img/Advanger/HP/HP6","png",1);
                break;
            case 5:
                Bar = new ImageSequence("img/Advanger/HP/HP5","png",1);
                break;
            case 4:
                Bar = new ImageSequence("img/Advanger/HP/HP4","png",1);
                break;
            case 3:
                Bar = new ImageSequence("img/Advanger/HP/HP3","png",1);
                break;
            case 2:
                Bar = new ImageSequence("img/Advanger/HP/HP2","png",1);
                break;
            case 1:
                Bar = new ImageSequence("img/Advanger/HP/HP1","png",1);
                break;
            case 0:
                Bar = new ImageSequence("img/Advanger/HP/HP","png",1);
        }
    }
    @Override public void getReady()
    {
        x = 0;
        y = 0;
        w = 0;
        h = 0;
        model = new Model(x,y,w,h);
    }
    @Override public void run()
    {
    }
    @Override public void end()
    {
    }
    @Override public Model getModel()
    {
        return model;
    }
    @Override public void display(Graphics g)
    {
        g.drawImage(Bar.next(true), x, y, null);
    }
    @Override public Effect conflict(Role role, Rectangle rec)
    {
        return null;
    }
}