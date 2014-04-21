package slickxample;

import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Patrick
 */
public class MainMenu extends BasicGameState {

    private int id;
    private Image playerImg;
    private ArrayList<IceParticle> particleEffects;
    private Player player;
    private PlayerHandler playerHandler;
    private ArrayList<Projectile> projectiles;
    private PlayerProjectileManager playerProjectileManager;
    private EnemyProjectileManager enemyProjectileManager;
    private ArrayList<Entity> enemies;
    private EnemyManager enemyManager;
    private MathTool angleCalc;
    private TileManager tileM;
    private LevelRenderer level;
    private MoveRegister moveRegister;
    private Input input;
    private float mouseX = 0;
    private float mouseY = 0;
    private float oldMouseX = 0;
    private float oldMouseY = 0;
    public static int count = 0;
    private float particleCount = 0;
    private LevelCreator lvlCreator;
    private EnemyCreator enemyCreator;
    private LavaFlow lavaFlow;
    private boolean paused = false;
    private ScoreManager scoreManager;
    private Image deathTint;
    private float deathDelay = 100;
    private boolean showDeath = false;
    private boolean resetReady = false;

    public MainMenu(int id) {
        this.id = id;

    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        playerImg = new Image("res/Player.png");
        scoreManager = new ScoreManager();
        enemies = new ArrayList<>();
        enemyCreator = new EnemyCreator();
        enemyCreator.init(container, game);
        enemyManager = new EnemyManager(enemies, enemyCreator, scoreManager);
        lavaFlow = new LavaFlow(-20, 600, 0, new Image("res/LavaFlow.png"));
        playerProjectileManager = new PlayerProjectileManager(enemies, lavaFlow);
        player = new Player(400, 300, playerImg, playerProjectileManager);
        playerHandler = new PlayerHandler(player);
        playerHandler.init(container, game);
        enemyProjectileManager = new EnemyProjectileManager(player, lavaFlow);
        angleCalc = new MathTool(player, lavaFlow);
        tileM = new TileManager();
        tileM.init(container, game);
        lvlCreator = new LevelCreator();
        level = new LevelRenderer(tileM, lvlCreator, enemyManager);
        level.init(container, game);
        moveRegister = new MoveRegister();
        moveRegister.init(container, game);
        deathTint = new Image("res/BlackBox.png");
        deathTint.setAlpha(0.65f);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        level.render(container, game, g);
        player.render(container, game, g);
        playerProjectileManager.render(container, game, g);
        enemyManager.render(container, game, g);
        enemyProjectileManager.render(container, game, g);
        lavaFlow.render(container, game, g);
        playerHandler.render(container, game, g);
        scoreManager.render(container, game, g);
        g.drawString(Integer.toString(count), 300, 50);
        if (paused) {
            deathTint.draw(-1, -1);
            g.setColor(Color.white);
            g.drawString("Paused", 375, 250);
        }

        if (showDeath) {
            deathTint.draw(-1, -1);
            g.setColor(Color.red);
            g.drawString("You are dead", 335, 250);
            g.setColor(Color.white);
            g.drawString("Final score: " + (int) scoreManager.getCurrentScore(), 325, 300);
            if(resetReady){
                g.drawString("Press ", 300, 350);
                g.setColor(Color.red);
                g.drawString("space", 350, 350);
                g.setColor(Color.white);
                g.drawString("to try again", 400, 350);
            }
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (!paused && !playerHandler.isDead()) {
            level.update(container, game, delta);
            player.update(container, game, delta);
            playerProjectileManager.update(container, game, delta);
            enemyManager.update(container, game, delta);
            enemyProjectileManager.update(container, game, delta);
            lavaFlow.update(container, game, delta);
            playerHandler.update(container, game, delta);

            particleCount += 1 * delta;
        }
        
        input = container.getInput();

        if (playerHandler.isDead()) {
            if (!showDeath) {
                deathDelay -= 0.1f * delta;
                if (deathDelay <= 0) {
                    showDeath = true;
                    deathDelay = 100;
                }
            } else {
                if (!resetReady) {
                    deathDelay -= 0.1f * delta;
                    if (deathDelay <= 0) {
                        resetReady = true;
                        deathDelay = 100;
                        input.clearKeyPressedRecord();
                    }
                }
            }
        }

           
        if(resetReady){
            if (input.isKeyPressed(Input.KEY_SPACE)) {
                reset();
        }
        }
        
        if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {

        }
        if (input.isMousePressed(Input.MOUSE_MIDDLE_BUTTON)) {
            reset();
        }

        if (input.isKeyPressed(Input.KEY_P) || input.isKeyPressed(Input.KEY_ESCAPE)) {
            if (!playerHandler.isDead()) {
                if (paused) {
                    paused = false;
                } else {
                    paused = true;
                }
            }
        }
    }

    public void reset() {
        enemies = new ArrayList<>();
        enemyManager.reset(enemies);
        enemyProjectileManager.reset();
        lavaFlow.reset();
        player.reset();
        playerHandler.reset();
        playerProjectileManager.reset(enemies);
        scoreManager.reset();
        level.reset();
        showDeath = false;
        resetReady = false;
        count = 0;
    }
}
