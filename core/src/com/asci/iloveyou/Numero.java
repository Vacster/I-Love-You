package com.asci.iloveyou;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Numero extends Image{
	
	public boolean activo = false;
	
	public Numero(Texture texture) {
		super(texture);
	}
	
	@Override
	public void act(float delta) {

		super.act(delta);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		setColor(Color.RED);
		super.draw(batch, parentAlpha);
	}
}
