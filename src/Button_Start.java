/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
import java.awt.*;
public class Button_Start extends Button
{
    Button_Start(Game ctl, GameManager mgr)
    {
        super(ctl, mgr);
    }
    @Override public ImageSequence setImg()
    {
        ImageSequence button = new ImageSequence("img/Background/Menu/Button/Start", "png", 1);
        return button;
    }
    @Override public int setX()
    {
        int x = 800;
        return x;
    }
    @Override public int setY()
    {
        int y = 390;
        return y;
    }
    @Override public int setW()
    {
        int w = 160;
        return w;
    }
    @Override public int setH()
    {
        int h = 65;
        return h;
    }
    @Override public Effect conflict(Role role, Rectangle rec)
    {
        return new Button_Start_Effect(this, role, 0, 0, 0, 0, 10, this);
    }
}
