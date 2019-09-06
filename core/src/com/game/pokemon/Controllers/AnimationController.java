package com.game.pokemon.Controllers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationController {

    public Animation walkUpAnimation, walkRightAnimation, walkLeftAnimation, walkDownAnimation, animation;
    public Texture spritesheet;
    public TextureRegion[] walkUpFrames, walkRightFrames, walkLeftFrames, walkDownFrames;

    public AnimationController() {

        spritesheet = new Texture("res/Ethan Walking sprite.png");
        TextureRegion[][] tmpframes = TextureRegion.split(spritesheet, 64, 64);

        int walkUpIndex = 0;
        walkUpFrames = new TextureRegion[4];
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 4; j++){
                walkUpFrames[walkUpIndex++] = tmpframes[i][j];
            }
        }
        walkUpAnimation = new Animation<TextureRegion>(1f/4f, walkUpFrames);

        int walkRightIndex = 0;
        walkRightFrames = new TextureRegion[4];
        for (int m = 0; m < 1; m++){
            for (int n = 0; n < 4; n++){
                walkRightFrames[walkRightIndex++] = tmpframes[m][n];
            }
        }
        walkRightAnimation = new Animation<TextureRegion>(1f/4f, walkRightFrames);

        int walkLeftIndex = 0;
        walkLeftFrames = new TextureRegion[4];
        for (int o = 0; o < 1; o++){
            for (int p = 0; p < 4; p++){
                walkLeftFrames[walkLeftIndex++] = tmpframes[o][p];
            }
        }
        walkLeftAnimation = new Animation<TextureRegion>(1f/4f, walkLeftFrames);

        int walkDownIndex = 0;
        walkDownFrames = new TextureRegion[4];
        for (int q = 0; q < 1; q++){
            for (int r = 0; r < 4; r++){
                walkDownFrames[walkDownIndex++] = tmpframes[q][r];
            }
        }
        walkDownAnimation = new Animation<TextureRegion>(1f/4f, walkDownFrames);
    }

    public Animation getAnimation() {

        animation = walkUpAnimation = new Animation<TextureRegion>(1f/4f, walkUpFrames);

        return animation;
    }
}