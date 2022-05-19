/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
public class Button_Start_Effect extends Effect
{
    Button Start;
    public Button_Start_Effect(Role s, Role d, int x, int y, int dw, int dh, int cycles, Button but)
    {
        super(s, d, x, y, dw, dh, null, null, cycles);
        this.is =null;
        String fn = "sound/Effect/GameStart/Start.mp3";
        this.audioPlayer = new SpecialGameSoundManager().getPlayer(fn);
        Start = but;
    }
    @Override
    public void effectDone(Role source, Role dest)
    { //特效結束時
        Start.getGameManager().levelUp();
        Start.getGame().clearGame();
    }
}
