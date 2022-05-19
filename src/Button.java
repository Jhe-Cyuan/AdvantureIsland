/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
import java.awt.*;
public abstract class Button implements Role
{
    //遊戲
    private Game ctl = null;
    private final GameManager mgr;
    //基本設置
    private Model model = null;
    private ImageSequence button;
    private int x,y,w,h;//位置、大小
    //動作
    public abstract ImageSequence setImg();
    Button(Game ctl, GameManager mgr)
    {
        this.ctl = ctl;
        this.mgr = mgr;
        button = setImg();
    }
    public GameManager getGameManager()
    {
        return mgr;
    }
    public Game getGame()
    {
        return ctl;
    }
    public abstract int setX();
    public abstract int setY();
    public abstract int setW();
    public abstract int setH();
    @Override public void getReady()
    {
        x = setX();
        y = setY();
        w = setW();
        h = setH();
        model = new Model(x,y,w,h);
    }
    @Override public void run()
    {
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
        g.drawImage(button.next(true), x, y, w, h, null);
    }
    @Override public abstract Effect conflict(Role role, Rectangle rec);
}
