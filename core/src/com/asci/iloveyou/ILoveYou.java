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
	char L1='L', L2='J';
	float delayTime = 0.05f;
	
	SpriteBatch batch;
	Texture imagen0, imagen1;
	Stage stage;
	Numero arreglo[][] = new Numero[51][32];
	boolean done[][] = new boolean[51][32];
	boolean llenos[] = new boolean[32];
	boolean activos[] = new boolean[32];//Demasiados arreglos, si puedes arreglar esto seria cool
	float timef = 0, timef2 = 0;
	boolean full= false;
	
	String heart[] = {"               *               ",
					  "            *** ***            ",
					  "         ****     ****         ",
					  "       ***           ***       ",
					  "     ***               ***     ",
					  "    ***                 ***    ",
					  "   ***                   ***   ",
					  "  ***                     ***  ",
					  " ***                       *** ",
					  "***                         ***",
					  "**                           **",
					  "**                           **",
					  "**                           **",
					  "**                           **",
					  "**             *             **",
					  "***           ***           ***",
					  " ***         ** **         *** ",
					  "   ***     **     **     ***   ",
					  "     ******         ******     ",
					  "        *             *        ",
					  };
	
	boolean y[][] = {{false,false,true,false,false},
			 {false,false,true,false,false},
			 {false,true,true,true,false},
			 {false,true,false,true,false},
			 {false,true,false,true,false},};
	
//	boolean A[][] = {{true,false,false,false,true},
//					 {true,true,true,true,true},
//					 {true,false,false,false,true},
//					 {false,true,false,true,false},
//					 {false,false,true,false,false},};
	
	String A[] = {"*   *",
			      "*****",
			      "*   *",
			      " * * ",
			      "  *  ",};
	
	String B[] = {" ****",
				  "*   *",
				  " ****",
				  "*   *",
				  " ****",};
	
	String C[] = {"*****",
			      "    *",
			      "    *",
			      "    *",
			      "*****",};
	
	String D[] = {" ****",
			      "*   *",
			      "*   *",
			      "*   *",
			      " ****",};
	
	String E[] = {"*****",
			  	  "    *",
			  	  " ****",
			  	  "    *",
			  	  "*****",};
	
	String F[] = {"    *",
		  	  	  "    *",
		  	  	  " ****",
		  	  	  "    *",
		  	  	  "*****",};
	
	String G[] = {"*****",
		  	      "*   *",
		  	      "*** *",
		  	      "    *",
		  	      "*****",};
	
	String H[] = {"*   *",
		  	  	  "*   *",
		  	  	  "*****",
		  	  	  "*   *",
		  	  	  "*   *",};
	
	String I[] = {"*****",
		  	  	  "  *  ",
		  	  	  "  *  ",
		  	  	  "  *  ",
		  	  	  "*****",};
	
	String J[] = {"  ***",
	  	  	  	  "  * *",
	  	  	  	  "  *  ",
	  	  	  	  "  *  ",
	  	  	  	  "*****",};
	
	String K[] = {"*   *",
				  " *  *",
	  	  	  	  "  * *",
	  	  	  	  " *  *",
	  	  	      "*   *",};
	
	String L[] = {"*****",
				  "    *",
	  	  	  	  "    *",
	  	  	  	  "    *",
	  	  	  	  "    *",};
	
	String M[] = {"*   *",
	  	  	  	  "*   *",
	  	  	  	  "* * *",
	  	  	  	  "** **",
	  	  	  	  "*   *",};
	
	String N[] = {"*   *",
	  	  	  	  "**  *",
	  	  	  	  "* * *",
	  	  	  	  "*  **",
	  	  	  	  "*   *",};
	
	String O[] = {" *** ",
	  	  	  	  "*   *",
	  	  	  	  "*   *",
	  	  	  	  "*   *",
	  	  	  	  " *** ",};
	
	String P[] = {"    *",
	  	  	  	  "    *",
	  	  	  	  " ****",
	  	  	  	  "*   *",
	  	  	  	  " ****",};
	
	String Q[] = {"**** ",
	  	  	  	  "**  *",
	  	  	  	  "* * *",
	  	  	  	  "*   *",
	  	  	  	  " *** ",};
	
	String R[] = {"*   *",
	  	  	  	  " *  *",
	  	  	  	  " ****",
	  	  	  	  "*   *",
	  	  	  	  " ****",};
	
	String S[] = {" *** ",
	  	  	  	  " *  *",
	  	  	  	  "  *  ",
	  	  	  	  "*  * ",
	  	  	  	  " *** ",};
	
	String T[] = {"  *  ",
	  	  	  	  "  *  ",
	  	  	  	  "  *  ",
	  	  	  	  "  *  ",
	  	  	  	  "*****",};
	
	String U[] = {"*****",
	  	  	  	  "*   *",
	  	  	  	  "*   *",
	  	  	  	  "*   *",
	  	  	  	  "*   *",};
	
	String V[] = {"  *  ",
	  	  	  	  " * *",
	  	  	  	  "*   *",
	  	  	  	  "*   *",
	  	  	  	  "*   *",};
	
	String W[] = {"*   *",
	  	  	  	  "** **",
	  	  	  	  "* * *",
	  	  	  	  "*   *",
	  	  	  	  "*   *",};
	
	String X[] = {"*   *",
	  	  	  	  " * * ",
	  	  	  	  "  *  ",
	  	  	  	  " * * ",
	  	  	  	  "*   *",};
	
	String Y[] = {"  *  ",
	  	  	  	  "  *  ",
	  	  	  	  "  *  ",
	  	  	  	  " * * ",
	  	  	  	  "*   *",};
	
	String Z[] = {"*****",
	  	  	  	  "*    ",
	  	  	  	  "  *  ",
	  	  	  	  "    *",
	  	  	  	  "*****",};
	
//	boolean J[][] = {{false,false,true,true,true},
//					 {false,false,true,false,true},
//					 {false,false,true,false,false},
//					 {false,false,true,false,false},
//					 {true,true,true,true,true},};
	
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
		
		stage = new Stage(new StretchViewport(640, 1020), batch);
	}

	boolean flag = true;
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		stage.act();
		
		if(!full)
		{
			float delta = Gdx.graphics.getDeltaTime();
			timef+=delta;
			if(timef >= delayTime){//Cada 0.05 segundos avanza una fila
				timef = 0;
				//changeTextures();
				for(int x = 0; x < 32; x++){//Pasa por todas las columnas
					if(activos[x]){//Si esta activa continua; si no, pasa al siguiente ciclo
						for(int y = 50; y > -1; y--){
							if(!done[y][x]){
									done[y][x] = true;
									arreglo[y][x] = new Numero(MathUtils.random(0,1)==1?imagen0:imagen1);
									arreglo[y][x].setPosition(x*20, (y)*20);
									arreglo[y][x].activo = true;
									stage.addActor(arreglo[y][x]);
									if(y == 0)
										llenos[x] = true;
									break;
							}
						}
					}
				}
			}
		
			timef2 += Gdx.graphics.getDeltaTime();
			if(timef2 >= 0.25 && flag){//cada 0.25 seg activa otra fila
				timef2 = 0;
				flag = check();
			}
			full = isFull();
		}else{
//			arreglo[50][31].selected = true;
//			arreglo[50][0].selected = true;
//			arreglo[0][31].selected = true;
//			arreglo[0][0].selected = true;
//			for (int i = 0; i < arreglo.length; i++) {
//				for (int j = 0; j < arreglo[i].length; j++) {
//					arreglo[i][j].selected = true;
//				}
//			}
//			vertical
//			animar(30,17,J);
//			animar(24,17,y);
//			animar(18,17,A);
//			horizontal
			drawText();
			drawHeart(17, 30);
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
				arreglo[50][randy] = new Numero(MathUtils.random(0,1)==1?imagen0:imagen1);
				arreglo[50][randy].activo = true;
				arreglo[50][randy].setPosition(randy*20, 1000);
				done[50][randy] = true;
				stage.addActor(arreglo[50][randy]);
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
	
	private boolean isFull(){
		for (int i = 0; i < llenos.length; i++) {
			if(!llenos[i]) return false;
		}
		return true;
	}
	
	private void animar(int f, int c, boolean letra[][]){
//		while(true){
			float delta = Gdx.graphics.getDeltaTime();
			timef+=delta;
			if(timef>=0.5){
				timef=0;
				for (int i = 0,ii=f; i < letra.length; i++,ii++) {
					for (int j = 0,jj=c; j < letra[i].length; j++,jj--) {
						arreglo[ii][jj].selected = letra[i][j];
					}
				}
			}
//		}
	}
	
	private void drawText(){
		animar(25,10,getArray(L1));
		animar(25,17,y);
		animar(25,24,getArray(L2));
	}
	
	private String[] getArray(char l){
		switch (l) {
		case 'A':
			return A;
case 'B':
	return B;
			
case 'C':
	return C;
	
case 'D':
	return D;
	
case 'E':
	return E;
	
case 'F':
	return F;
	
case 'G':
	return G;
	
case 'H':
	return H;
	
case 'I':
	return I;
	
case 'J':
	return J;
	
case 'K':
	return K;
	
case 'L':
	return L;
	
case 'M':
	return M;
	
case 'N':
	return N;
	
case 'O':
	return O;
	
case 'P':
	return P;
	
case 'Q':
	return Q;
	
case 'R':
	return R;
	
case 'S':
	return S;
	
case 'T':
	return T;
	
case 'U':
	return U;
	
case 'V':
	return V;
	
case 'W':
	return W;
	
case 'X':
	return X;
	
case 'Y':
	return Y;
	
case 'Z':
	return Z;
	
		}
		return null;
	}
	
	private void animar(int f, int c, String letra[]){
//		while(true){
			float delta = Gdx.graphics.getDeltaTime();
			timef+=delta;
			if(timef>=0.5){
				timef=0;
				for (int i = 0,ii=f; i < letra.length; i++,ii++) {
					for (int j = 0,jj=c; j < letra[i].length(); j++,jj--) {
						if(letra[i].charAt(j)=='*')
							arreglo[ii][jj].selected = true;
					}
				}
			}
//		}
	}
	
	private void drawHeart(int f, int c){
		float delta = Gdx.graphics.getDeltaTime();
		timef+=delta;
		if(timef>=0.5){
			timef=0;
			for (int i = 0,ii=f; i < heart.length; i++,ii++) {
				for (int j = 0,jj=c; j < heart[i].length(); j++,jj--) {
					if(heart[i].charAt(j)=='*')
						arreglo[ii][jj].selected = true;
				}
			}
		}
	}
}