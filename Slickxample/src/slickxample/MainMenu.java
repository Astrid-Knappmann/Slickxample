package slickxample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
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
    private Image startButton;
    private ArrayList<IceParticle> particleEffects;
    private Player player;
    private ArrayList<PlayerProjectile> projectiles;
    private PlayerProjectileManager projectileManager;
    private ArrayList<Entity> enemies;
    private EnemyManager enemyManager;
    private AngleCalculator angleCalc;
    private Input input;
    private float mouseX = 0;
    private float mouseY = 0;
    private float oldMouseX = 0;
    private float oldMouseY = 0;
    public static int count = 0;
    private float particleCount = 0;

    public MainMenu(int id) {
        this.id = id;

    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        startButton = new Image("res/wannabeIce.png");
        enemies = new ArrayList<>();
        enemyManager = new EnemyManager(enemies);
        projectileManager = new PlayerProjectileManager(enemies);
        player = new Player(300, 300, startButton, projectileManager);
        angleCalc = new AngleCalculator(player);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        player.render(container, game, g);
        projectileManager.render(container, game, g);
        enemyManager.render(container, game, g);
        g.drawString(Integer.toString(count), 300, 50);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        player.update(container, game, delta);
        projectileManager.update(container, game, delta);
        enemyManager.update(container, game, delta);
        particleCount += 1 * delta;
        input = container.getInput();
        mouseX = input.getMouseX();
        mouseY = input.getMouseY();
        if (mouseX != oldMouseX || mouseY != oldMouseY) {
            if (particleCount > 15) {
                projectileManager.addIceParticle(new IceParticle(mouseX, mouseY, new Image("res/wannabeIce.png"), RandomTool.getRandom().nextInt(360), RandomTool.getRandom().nextFloat() / 2 - 0.25f));
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
        oldMouseX = mouseX;
        oldMouseY = mouseY;
    }
}