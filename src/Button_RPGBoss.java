/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
import java.awt.*;
public class Button_RPGBoss extends Button
{
    Button_RPGBoss(Game ctl, GameManager mgr)
    {
        super(ctl, mgr);
    }
    @Override public ImageSequence setImg()
    {
        ImageSequence button = new ImageSequence("img/Background/Menu/Button/RPGBoss", "png", 1);
        return button;
    }
    @Override public int setX()
    {
        int x = 1085;
        return x;
    }
    @Override public int setY()
    {
        int y = 20;
        return y;
    }
    @Override public int setW()
    {
        int w = 209;
        return w;
    }
    @Override public int setH()
    {
        int h = 387;
        return h;
    }
    @Override public Effect conflict(Role role, Rectangle rec)
    {
        super.getGameManager().SetLevel("RPGBoss");
        super.getGame().clearGame();
        return null;
    }
}
