/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
public class Level
{
    private String status;
    Level()
    {
        status = "NotStart";
    }
    void SetLevel(String status)
    {
        this.status = status;
    }
    String getLevel()
    {
        return status;
    }
    void levelUp()
    {
        switch (status)
        {
            case "NotStart":
                status = "Login";
                break;
            case "Login":
                status = "Menu";
                break;
            case "Menu":
                status = "EasyStory1";
                break;
            case "EasyStory1":
                status = "EasyStory2";
                break;
            case "EasyStory2":
                status = "EasyStory3";
                break;
            case "EasyStory3":
                status = "Easy";
                break;
            case "Easy":
                status = "NormalStory1";
                break;
            case "NormalStory1":
                status = "NormalStory2";
                break;
            case "NormalStory2":
                status = "NormalStory3";
                break;
            case "NormalStory3":
                status = "Normal";
                break;
            case "Normal":
                status = "HardStory1";
                break;
            case "HardStory1":
                status = "HardStory2";
                break;
            case "HardStory2":
                status = "HardStory3";
                break;
            case "HardStory3":
                status = "HardStory4";
                break;
            case "HardStory4":
                status = "HardStory5";
                break;
            case "HardStory5":
                status = "Hard";
                break;
            case "Hard":
                status = "Ending";
                break;
            case "Ending":
                status = "Login";
                break;
            case "Die0":
                status = "Die1";
                break;
            case "Die1":
                status = "Die2";
                break;
            case "Die2":
                status = "Login";
                break;
        }
    }
}
