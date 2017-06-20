package com.kuhy.nameless_quest.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Kuhy on 20.6.2017.
 */

public final class UITools {
    private static Skin skin;

    private UITools() {}

    public static void setup() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
    }

    public static TextButton makeTextButton(String text, float x, float y, float width, float height) {
        TextButton textButton = new TextButton(text, skin, "default");
        textButton.setPosition(x, y);
        textButton.setSize(width, height);
        return textButton;
    }

    public static void dispose() {
        skin.dispose();
    }
}
