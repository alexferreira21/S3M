package util;

import java.util.List;


public class  RandomUtils{

	
	public static Object selecionarAleatoriamente(List<?> lista){
		int indice = (int)( (lista.size()) * Math.random() );
		
		return lista.get(indice);
	}
	
	public static int entreValores(int min, int max){
		
		return min + (int)( (max-min+1) * Math.random() ) ;
 	}

	public static float entreValores(float min, float max){
		
		return min + (float)( (max-min+1) * Math.random() ) ;
 	}
	
	public static int menorQue(int i){
		return (int)(i * Math.random());
	}

}
