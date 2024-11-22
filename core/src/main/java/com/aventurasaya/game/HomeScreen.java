package com.aventurasaya.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector3;

/** First screen of the application. Displayed after the application is created. */
public class HomeScreen implements Screen {

    private final Main game;
    private Texture backGround, tPlayButton;
    private Sprite playButton;
    private Sound clickSound;

    public HomeScreen(Main game) {
        this.game = game;

        tPlayButton = new Texture("playButton.png");
        playButton = new Sprite(tPlayButton);
        playButton.setSize(playButton.getWidth() /3f, playButton.getHeight()/ 3f);
        playButton.setCenter(Main.WORLD_WIDTH / 2f, Main.WORLD_HEIGHT / 3f);

        backGround = new Texture("Game_Background.png");

        clickSound = Gdx.audio.newSound(Gdx.files.internal("meow.ogg"));

    }


    @Override
    public void show() {
        // Prepare your screen here.
    }

    @Override
    public void render(float delta) {
        game.getSpriteBatch().begin();

        checkButtonPress();

        game.getSpriteBatch().draw(backGround, 0, 0, Main.WORLD_WIDTH, Main.WORLD_HEIGHT);
        playButton.draw(game.getSpriteBatch());

        game.getSpriteBatch().end();
    }

    void checkButtonPress() {
        if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            game.getCamera().unproject(touchPos);

            if (playButton.getBoundingRectangle().contains(touchPos.x, touchPos.y)) {
                clickSound.play();
                game.setScreen(new GameScreen(game));
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        backGround.dispose();
        tPlayButton.dispose();
    }
}
