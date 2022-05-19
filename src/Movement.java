/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
public interface Movement
{
    Model updatePos(Model model);
    void reset();
    void setvx(double i);
    void setvy(double i);
}