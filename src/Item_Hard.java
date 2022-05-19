/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
import java.awt.*;
public class Item_Hard extends Fall
{
    //new Fall(game, "img/Weapon/Knife/Down/Knife", "png", 7, 18, 102, -50)
    Item_Hard(Game ctl/*, String path, String ex, int num, int w, int h*/, int hurt)
    {
        super(ctl, hurt);
    }
    @Override public ImageSequence setImg()
    {
        ImageSequence button = new ImageSequence("img/Weapon/Hard/Normal/FireBall", "png", 12);
        return button;
    }
    @Override public int setW()
    {
        int w = 18;
        return w;
    }
    @Override public int setH()
    {
        int h = 102;
        return h;
    }
    @Override public Effect conflict(Role role, Rectangle rec)
    {
        if (role instanceof Advanger)
        {
            Hit();
            this.end();
            return new Item_Hard_Effect(this, role, (int) rec.getX(), (int)rec.getY(), 134, 112, 10);
        }
        else
            return null;
    }
}
