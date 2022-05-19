/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
import java.awt.*;
public class Item_Normal extends Fall
{
    Item_Normal(Game ctl, int hurt)
    {
        super(ctl, hurt);
    }
    @Override public ImageSequence setImg()
    {
        ImageSequence button = new ImageSequence("img/Weapon/Normal/Normal/Cake", "png", 2);
        return button;
    }
    @Override public int setW()
    {
        int w = 50;
        return w;
    }
    @Override public int setH()
    {
        int h = 50;
        return h;
    }
    @Override public Effect conflict(Role role, Rectangle rec)
    {
        if (role instanceof Advanger)
        {
            Hit();
            this.end();
            return new Item_Normal_Effect(this, role, (int) rec.getX(), (int)rec.getY(), 110, 69, 10);
        }
        else
            return null;
    }
}
