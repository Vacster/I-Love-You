package com.asci.iloveyou;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ILoveYou extends ApplicationAdapter{
	SpriteBatch batch;
	Texture imagen0, imagen1;
	Stage stage;
	Numero arreglo[][] = new Numero[51][32];
	boolean done[][] = new boolean[51][32];
	boolean llenos[] = new boolean[32];
	boolean activos[] = new boolean[32];//Demasiados arreglos, si puedes arreglar esto seria cool
	float timef = 0, timef2 = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		imagen0 = new Texture("0.png");
		imagen1 = new Texture("1.png");
		
		for(int x = 0; x < 32; x++){
			for(int y = 0; y < 51; y++){
				done[y][x] = false;
			}
		}
		
		stage = new Stage(new StretchViewport(640, 1020), batch){
			@Override
			public void act(float delta) {
				timef+=delta;
				if(timef >= 0.05){//Cada 0.05 segundos avanza una fila
					timef = 0;
					//changeTextures();
					for(int x = 0; x < 32; x++){//Pasa por todas las columnas
						if(activos[x]){//Si esta activa continua; si no, pasa al siguiente ciclo
							for(int y = 50; y >= 0; y--){
								if(arreglo[y][x].activo && !done[y][x]){
									if(y != 0){
										done[y][x] = true;
										arreglo[y-1][x] = new Numero(MathUtils.random(0,1)==1?imagen0:imagen1);
										arreglo[y-1][x].setPosition(x*20, y*20);
										arreglo[y-1][x].activo = true;
										stage.addActor(arreglo[y-1][x]);
										break;
									}else if(!llenos[x]){
										arreglo[0][x] = new Numero(MathUtils.random(0,1)==1?imagen0:imagen1);
										arreglo[0][x].setPosition(x*20, y*20);
										arreglo[0][x].activo = true;
										stage.addActor(arreglo[0][x]);
										llenos[x] = true;
									}
								}
							}
						}
					}
					super.act(delta);
				}
			}
		};
	}

	boolean flag = true;
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		stage.act(Gdx.graphics.getDeltaTime());
		timef2 += Gdx.graphics.getDeltaTime();
		if(timef2 >= 0.25 && flag){//cada 0.25 seg activa otra fila
			timef2 = 0;
			flag = check();
		}
	}
	
	/*private void changeTextures(){ Funcion para hacer que todos cambien| poner en el act de stage
		for(int y = 0; y < 51; y++)
			for(int x = 0; x < 32; x++)
				if(arreglo[y][x] != null)
					arreglo[y][x].changeTexture(MathUtils.random(0,1)==1?img:img1);
	}*/
	
	private boolean check(){//Empieza a activar las columnas al azar
		while(true){	
		int randy = MathUtils.random(0, 31);
			if(!activos[randy] && !llenos[randy]){
				activos[randy] = true;
				arreglo[50][randy] = new Numero(imagen0);
				arreglo[50][randy].activo = true;
				return true;
			}else{
				boolean flag = false;
				for(int x = 0; x < 32; x++){
					if(!activos[x]){
						flag = true;
						break;
					}
				}
				if(!flag){
					Gdx.app.log("ok", "Full");
					return false;
				}
			}
		}
	}
}