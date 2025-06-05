package utils;

import java.awt.*;

public class Constants {
    public static final String UPLOAD_ENDPOINT = "http://gatewayantares.com:1337/upload";
    public static final String DOWNLOAD_ENDPOINT = "http://gatewayantares.com:1337/get-top-10";

    public static final Color GAME_PANEL_BACKGROUND = new Color(70, 53, 177);
    public static final Color PLAYER_COLOR = new Color(174, 234, 148);;
    public static final Color PLAYERS_MISSILE_COLOR = new Color(174, 234, 148);
    public static final Color UFO_COLOR = new Color(183, 113, 229);
    public static final Color UFO_WINDOW_COLOR = new Color(255, 251, 202);

    public static final int PANEL_HEIGHT = 600;
    public static final int PANEL_WIDTH = 800;
    public static final String SPLASH_SCREEN_PICTURE = "/UFO_name_50.png";

    public static final boolean DEBUG_MODE = false;
    public static final boolean SHOOT_ENEMY_MISSILES = true;
    public static final boolean DETECT_COLLISIONS_WITH_ENEMY = true;
    public static final boolean DETECT_COLLISIONS_WITH_PLAYER = true;
    public static final boolean ENABLE_DIFFICULTY_SETTINGS = false;

    public static final int PLAYER_WIDTH = 20;
    public static final int PLAYER_HEIGHT = 30;
    public static final int PLAYER_SPEED = 5;
    public static final float PLAYER_MISSILE_SPEED = 7f;
    public static final int PLAYER_FIRE_INTERVAL = 130;
    public static final int PLAYER_HEALTH_LOSS_BY_HIT = 5;

    public static final float SMALL_ENEMY_SIZE = 1.2f;
    public static final float LARGE_ENEMY_SIZE = 2f;
    public static final float ENEMY_SPEED = 1f;
    public static final float ENEMY_MISSILE_SPEED = 2f;

    public static final int GAP_BETWEEN_ENEMY_ROWS = 60;
    public static final int GAP_BETWEEN_ENEMY_COLUMNS = 65;
    public static final int ENEMY_HORIZONTAL_RANGE = (int) (0.3 * PANEL_WIDTH);
}
