/**
 * @serial 物件導向技術
 * @author 第20組
 * @member 楊哲銓 / 鍾誌杰 / 曾志敏 / 賴享 / 劉峻銘 / 羅聖皓
 */
import game.framework.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class GameStarter implements GameManager,KeyListener
{
    //遊戲
    private final GameManager mgr = this;
    private Game game;
    private GameContext ctx;
    private ArrayList<Role> myroles;
    private Advanger player;
    //基本設置
    private final Level level = new Level();
    private int loginbg = 1;
    private int second = 0;
    //動作
    private Timer Repeat_Run, Time_Run;
    private TimerTask secondplus, loginbgrun, ball_fall, cake_fall, knife_fall;
    private void setLoop()
    {
        secondplus = new TimerTask()
        {
            @Override public void run()
            {
                if("Tutorial".equals(level.getLevel()))
                {
                    second++;
                    if(second == 8)
                    {
                        second = 0;
                        SetLevel("Login");
                        levelUp();
                    }                                 
                }
                else if ("RPGBoss".equals(level.getLevel()) || "RPGDadmom".equals(level.getLevel()) || "AboutUs".equals(level.getLevel()))  
                {
                    second++;
                    if(second == 2)
                    {
                        second = 0;
                        SetLevel("Login");
                        levelUp();
                    }
                }    
                else if("EasyStory1".equals(level.getLevel()) || 
                        "EasyStory2".equals(level.getLevel()) || 
                        "EasyStory3".equals(level.getLevel()) || 
                        "NormalStory1".equals(level.getLevel()) || 
                        "NormalStory2".equals(level.getLevel()) || 
                        "NormalStory3".equals(level.getLevel()) || 
                        "HardStory1".equals(level.getLevel()) || 
                        "HardStory2".equals(level.getLevel()) || 
                        "HardStory3".equals(level.getLevel()) || 
                        "HardStory4".equals(level.getLevel()) || 
                        "HardStory5".equals(level.getLevel()) || 
                        "Ending".equals(level.getLevel()) || 
                        "Die1".equals(level.getLevel()) || 
                        "Die2".equals(level.getLevel()))
                {
                    second++;
                    if(second == 2)
                    {
                        second = 0;
                        levelUp();
                    }
                }
                else if(("Easy".equals(level.getLevel()) || "Normal".equals(level.getLevel()) || "Hard".equals(level.getLevel())) &&
                        ((Advanger)player).getAlive())
                {
                    second++;
                    if(second == 30)
                    {
                        second = 0;
                        levelUp();
                    }
                }
            }   
        };
        loginbgrun = new TimerTask()
        {
            @Override public void run()
            {// TODO Auto-generated method stub
                loginbg++;
                if(++loginbg > 36)
                    loginbg = 0;
                String path = "img/Background/Login/Login"+Integer.toString(loginbg)+".png";
                GameContext st = new GameContext (
                        ctx.getGameName(), game.getWidth(), game.getHeight(), Color.white)
                {
                    @Override public String getBackgroundImgPath()
                    {
                        return path;
                    }
                    @Override public String getBackgroundMusicPath()
                    {
                        return "sound/BGM/Login/BGMLogin1.wav";
                    }
                };
                game.setGameContext(st);
            }   
        };
        ball_fall = new TimerTask()
        {
            @Override public void run()
            {
                game.addNewRole(new Item_Easy(game, -10));
            }   
        };
        cake_fall = new TimerTask()
        {
            @Override public void run()
            {
                game.addNewRole(new Item_Normal(game, -20));
            }   
        };
        knife_fall = new TimerTask()
        {
            @Override public void run()
            {
                game.addNewRole(new Item_Hard(game, -50));
            }   
        };
    }
    @Override public String getLevel()
    {
        return level.getLevel();
    }
    @Override public void SetLevel(String newLevel)
    {
        level.SetLevel(newLevel);
        second = 0;
    }
    @Override public void levelUp()
    {
        level.levelUp();
        Repeat_Run.cancel();
        Repeat_Run.purge();
        Repeat_Run = new Timer();
        this.setLoop();
        //prepare new games
        switch (level.getLevel())
        {
            default:
                game.removeRole(player);
                break;
            case "Login":
                second = 0;
                Repeat_Run.schedule(loginbgrun, 0, 250);
                game.halt();
                game.clearGame();
                break;
            case "Menu":
                game.setGameContext(ctx);
                game.addNewRole(player);
                game.addNewRole(new Button_Start(game, this));
                game.addNewRole(new Button_Tutorial(game, this));
                game.addNewRole(new Button_AboutUs(game, this));
                game.addNewRole(new Button_RPGBoss(game, this));
                game.addNewRole(new Button_RPGDadmom(game, this));
                break;
            case "Easy":
                game.addNewRole(player);
                Repeat_Run.schedule(ball_fall, 3000, 300);
                break;
            case "Normal":
                game.addNewRole(player);
                Repeat_Run.schedule(cake_fall, 3000, 100);
                break;
            case "Hard":
                game.addNewRole(player);
                Repeat_Run.schedule(knife_fall, 3000, 75);
                break;
        }
        game.restart();
    }
    private void setctx()
    {
        ctx = new GameContext ("Adventure Island  ver.19.01.12", 1680, 725, Color.white)
        {
            @Override
            public String getBackgroundImgPath()
            {
                String level=GameStarter.this.getLevel();
                switch(level)
                {
                    default:
                        return "img/Background/Login/Login0.png";
                    case "Login":
                        return "img/Background/Login/Login0.png";
                    case "Menu":
                        return "img/Background/Menu/background.png";
                    case "Tutorial":
                        return "img/Background/Tutorial/Tutorial.png";
                    case "AboutUs":
                        return "img/Background/AboutUs/AboutUs.png";
                    case "RPGBoss":
                        return "img/Background/RPGBoss/RPGBoss.png";
                    case "RPGDadmom":
                        return "img/Background/RPGDadmom/RPGDadmom.png";
                    case "EasyStory1":
                        return "img/Story/Easy/0.png";
                    case "EasyStory2":
                        return "img/Story/Easy/1.png";
                    case "EasyStory3":
                        return "img/Story/Easy/2.png";
                    case "Easy":
                        return "img/Background/Easy/background.png";
                    case "NormalStory1":
                        return "img/Story/Normal/0.png";
                    case "NormalStory2":
                        return "img/Story/Normal/1.png";
                    case "NormalStory3":
                        return "img/Story/Normal/2.png";
                    case "Normal":
                        return "img/Background/Normal/background.png";
                    case "HardStory1":
                        return "img/Story/Hard/0.png";
                    case "HardStory2":
                        return "img/Story/Hard/1.png";
                    case "HardStory3":
                        return "img/Story/Hard/2.png";
                    case "HardStory4":
                        return "img/Story/Hard/3.png";
                    case "HardStory5":
                        return "img/Story/Hard/4.png";
                    case "Hard":
                        return "img/Background/Hard/background.png";
                    case "Ending":
                        return "img/Story/Ending/0.png";
                    case "Die1":
                        return "img/Story/Die/0.png";
                    case "Die2":
                        return "img/Story/Die/1.png";
                }
            }
            @Override
            public String getBackgroundMusicPath()
            {
                String level=GameStarter.this.getLevel();
                switch(level)
                {
                    default:
                        return "sound/BGM/Login/BGMLogin1.wav";
                    case "Login":
                        return "sound/BGM/Login/BGMLogin1.wav";
                    case "Menu":
                        return "sound/BGM/Login/BGMLogin2.mp3";
                    case "Tutorial":
                        return "sound/BGM/Tutorial/BGMHowToPlay.mp3";
                    case "AboutUs":
                        return "sound/BGM/Tutorial/BGMHowToPlay.mp3";                       
                    case "RPGBoss":
                        return "sound/BGM/Tutorial/BGMHowToPlay.mp3";                       
                    case "RPGDadmom":
                        return "sound/BGM/Tutorial/BGMHowToPlay.mp3";
                    case "EasyStory1":
                        return "sound/BGM/Story/Easy/1.mp3";
                    case "EasyStory2":
                        return "sound/BGM/Story/Easy/1.mp3";
                    case "EasyStory3":
                        return "sound/BGM/Story/Easy/1.mp3";
                    case "Easy":
                        return "sound/BGM/Scenes/BGMScenesA.wav";
                    case "NormalStory1":
                        return "sound/BGM/Story/Normal/1.mp3";
                    case "NormalStory2":
                        return "sound/BGM/Story/Normal/1.mp3";
                    case "NormalStory3":
                        return "sound/BGM/Story/Normal/1.mp3";
                    case "Normal":
                        return "sound/BGM/Scenes/BGMScenesB.wav";
                    case "HardStory1":
                        return "sound/BGM/Story/Hard/1.mp3";
                    case "HardStory2":
                        return "sound/BGM/Story/Hard/1.mp3";
                    case "HardStory3":
                        return "sound/BGM/Story/Hard/1.mp3";
                    case "HardStory4":
                        return "sound/BGM/Story/Hard/1.mp3";
                    case "HardStory5":
                        return "sound/BGM/Story/Hard/1.mp3";
                    case "Hard":
                        return "sound/BGM/Scenes/BGMScenesC.wav";
                    case "Ending":
                        return "sound/BGM/ScenesWin/BGMScenesWin.mp3";
                    case "Die1":
                        return "sound/BGM/ScenesLose/BGMScenesLose.mp3";
                    case "Die2":
                        return "sound/BGM/ScenesLose/BGMScenesLose.mp3";
                }
            }
        };
    }
    public void setup()
    {
        this.setctx();
        game = new Game(ctx,true); //Game就是遊戲引擎3
        Repeat_Run = new Timer();
        Time_Run = new Timer();
        myroles = new ArrayList<> ();
        game.registerKeyEventHandler((KeyListener) this);
        Repeat_Run.schedule(loginbgrun, 0, 250);
        Time_Run.schedule(secondplus, 0, 1000);
    }
    public void run()
    {
        level.levelUp();
        game.go(myroles);
    }
    @Override public void keyTyped(KeyEvent e){}
    @Override public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ENTER &&
                "Login".equals(level.getLevel()))
        {
            player = new Advanger(game, this);
            game.registerKeyEventHandler((KeyListener) player);
            player.Alive();
            this.levelUp();
        }
        else if (e.getKeyCode() == KeyEvent.VK_V && 
            ("Easy".equals(level.getLevel()) || 
                "Normal".equals(level.getLevel()) || 
                "Hard".equals(level.getLevel())))
        {
            player.setAdcanced();
        }
    }
    @Override public void keyReleased(KeyEvent e){}
    public static void main(String[] args)
    {
        GameStarter GS = new GameStarter();
        GS.setLoop();
        GS.setup();
        GS.run();
    }
}