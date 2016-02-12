package com.asci.iloveyou;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class Numero extends Image{
	
	public boolean activo = false;
	public boolean selected = false;
	
	public Numero(Texture texture) {
		super(texture);
	}
	
	@Override
	public void act(float delta) {

		super.act(delta);
	}
	
	public void changeTexture(Texture texture){
		setDrawable(new SpriteDrawable(new Sprite(texture)));
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		if(selected)setColor(Color.RED);
		else setColor(Color.DARK_GRAY);
		super.draw(batch, parentAlpha);
	}
}
