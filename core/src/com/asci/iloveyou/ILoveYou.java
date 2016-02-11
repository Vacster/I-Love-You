package com.asci.iloveyou;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ILoveYou extends ApplicationAdapter{
	SpriteBatch batch;
	Texture img, img1;
	Stage stage;
	Numero arreglo[][] = new Numero[51][32];
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("0.png");
		img1 = new Texture("1.png");
		Image image = new Image(img);
		stage = new Stage(new StretchViewport(640, 1020), batch);
		for(int y = 0; y < 51; y++)
			for(int x = 0; x < 32; x++){
				Numero tmp = new Numero(MathUtils.random(0,1)==1?img:img1);
				tmp.setPosition(20*x, 20*y);
				stage.addActor(tmp);
			}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		stage.act();
	}
}
