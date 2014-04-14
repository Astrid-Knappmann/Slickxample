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
        enemies = new ArrayList<>();
        enemyCreator = new EnemyCreator();
        enemyCreator.init(container, game);
        enemyManager = new EnemyManager(enemies, enemyCreator);
        playerProjectileManager = new PlayerProjectileManager(enemies);
        enemyProjectileManager = new EnemyProjectileManager(player);
        player = new Player(300, 300, playerImg, playerProjectileManager);
        angleCalc = new MathTool(player);
        tileM = new TileManager();
        tileM.init(container, game);
        lvlCreator = new LevelCreator();
        level = new LevelRenderer(tileM, lvlCreator, enemyManager);
        level.init(container, game);
        moveRegister = new MoveRegister();
        moveRegister.init(container, game);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        level.render(container, game, g);
        player.render(container, game, g);
        playerProjectileManager.render(container, game, g);
        enemyManager.render(container, game, g);
        g.drawString(Integer.toString(count), 300, 50);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        level.update(container, game, delta);
        player.update(container, game, delta);
        playerProjectileManager.update(container, game, delta);
        enemyManager.update(container, game, delta);
        particleCount += 1 * delta;
        input = container.getInput();
        mouseX = input.getMouseX();
        mouseY = input.getMouseY();
        if (mouseX != oldMouseX || mouseY != oldMouseY) {
            if (particleCount > 15) {
                playerProjectileManager.addIceParticle(new IceParticle(mouseX, mouseY, new Image("res/ice.png"), RandomTool.getRandom().nextInt(360), RandomTool.getRandom().nextFloat() / 2 - 0.25f));
                count++;
                particleCount = 0;
            }
        }
        if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
            enemyManager.SpawnProjectile(50, 50, 0);
            enemyManager.SpawnProjectile(110, 50, 0);
            enemyManager.SpawnProjectile(170, 50, 0);
            enemyManager.SpawnProjectile(230, 50, 0);
            enemyManager.SpawnProjectile(290, 50, 0);
        }
        if (input.isMousePressed(Input.MOUSE_MIDDLE_BUTTON)) {
            
        }
        oldMouseX = mouseX;
        oldMouseY = mouseY;

    }
}
