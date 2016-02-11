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
	Texture img, img1;
	Stage stage;
	Numero arreglo[][] = new Numero[51][32];
	boolean llenos[] = new boolean[32];
	boolean activos[] = new boolean[32];
	long time = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("0.png");
		img1 = new Texture("1.png");
		stage = new Stage(new StretchViewport(640, 1020), batch){
			@Override
			public void act() {
				if(time % 10 == 0){//Cada 10 ciclos
					for(int x = 0; x < 32; x++){//Pasa por todas las columnas
						if(activos[x]){//Si esta activa continua; si no, pasa al siguiente ciclo
							for(int y = 50; y >= 0; y--){//Pasa por todas las filas
								if(arreglo[y][x] != null && arreglo[y][x].activo && !llenos[x]){//Revisa que exista un numero en la posicion, que este activo y que la columna no este llena
									if(y == 0){//Si llego a la ultima columna esta lleno
										llenos[x] = true;
									}
									else{//si no
										arreglo[y-1][x] = new Numero(MathUtils.random(0,1)==1?img:img1);//Crea un nuevo numero en la siguiente posicion
										arreglo[y-1][x].setPosition(x*20, y*20);//se define la posicion
										arreglo[y-1][x].activo = true;//se activa el numero como para decir que ya esta en pantalla (aqui ocurre el problema principalmente)
										stage.addActor(arreglo[y-1][x]);	//se agrega al estadio
									}
								}
							}
						}
					}
					super.act();
				}
			}
		};
		
	/*	for(int y = 0; y < 51; y++)
			for(int x = 0; x < 32; x++){
				Numero tmp = new Numero(MathUtils.random(0,1)==1?img:img1);
				tmp.setPosition(20*x, 20*y);
				stage.addActor(tmp);
			}
	 */
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		stage.act();
		time++;
		if(time %35 == 0)//cada 35 ciclos activa otra fila
			check();
	}
	
	
	
	private void check(){//Empieza a activar las columnas al azar | aun no sigue intentando si la columna elegida ya esta llena
		int randy = MathUtils.random(0, 31);
			if(!activos[randy] && !llenos[randy]){
				activos[randy] = true;
				arreglo[50][randy] = new Numero(img);
				arreglo[50][randy].activo = true;
			}
	}
}
