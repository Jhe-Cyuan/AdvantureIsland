/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
import java.awt.*;
public class Item_Easy extends Fall
{
    Item_Easy(Game ctl, int hurt)
    {
        super(ctl, hurt);
    }
    @Override public ImageSequence setImg()
    {
        ImageSequence button = new ImageSequence("img/Weapon/Easy/Normal/Item", "png", 2);
        return button;
    }
    @Override public int setW()
    {
        int w = 36;
        return w;
    }
    @Override public int setH()
    {
        int h = 34;
        return h;
    }
    @Override public Effect conflict(Role role, Rectangle rec)
    {
        if (role instanceof Advanger)
        {
            Hit();
            this.end();
            return new Item_Easy_Effect(this, role, (int) rec.getX(), (int)rec.getY(), 96, 79, 10);
        }
        else
            return null;
    }
}
