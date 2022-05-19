/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
public class Item_Easy_Effect extends Effect
{
    public Item_Easy_Effect(Role s, Role d, int x, int y, int dw, int dh, int cycles)
    {
        super(s, d, x, y, dw, dh, null, null, cycles);
        this.is =new ImageSequence("img/Weapon/Easy/DownHurt/ItemBlood","png", 12); //分鏡圖
        String fn = "sound/Effect/Ball/BGMBallBlood.mp3";
        this.audioPlayer = new SpecialGameSoundManager().getPlayer(fn);
    }
    @Override
    public void effectDone(Role source, Role dest)
    { //特效結束時
        source.end(); //stop the role and get it removed
        ((Advanger)dest).notHurt();
    }
}
