package model;

import model.entities.EnemyMissile;
import model.entities.Player;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class PlayerHitDetector implements HitDetector {

    Player player;
    List<EnemyMissile> missiles;
    List<EnemyMissile> missilesToRemove;

    public PlayerHitDetector(Player player, List<EnemyMissile> missiles) {
        this.player = player;
        this.missiles = missiles;
        missilesToRemove = new ArrayList<>();
    }

    @Override
    public int getNumberOfHits() {
        int hits = 0;

        for (EnemyMissile missile : missiles) {
            if (missile.getX() + 2 >= player.getX()
                    && missile.getX() + 2 <= player.getX() + Constants.PLAYER_WIDTH
                    && missile.getY() + 14 >= player.getY()
                    && missile.getY() + 14 <= player.getY() + Constants.PLAYER_HEIGHT) {
                hits++;
                missilesToRemove.add(missile);
            }
        }
        missiles.removeAll(missilesToRemove);


        return hits;
    }
}
