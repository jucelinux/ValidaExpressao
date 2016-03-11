package com.jucelinux;

import java.util.ArrayList;
import java.util.List;

public class ValidadorUtil {
	
	public static boolean validaExpressao(String expressao){
		
		//Criando lista para controle dos símbolos
		List<Character> simbolos = new ArrayList<Character>();
		for(char caracter : expressao.toCharArray()){
			
			//Sempre que o caracter for um símbolo de abertura, insere na lista
			if(caracter == obtemCaracter("{") || caracter == obtemCaracter("[") || caracter == obtemCaracter("(")){
				simbolos.add(caracter);
			}else
			//Toda vez que o caracter for um símbolo de fechamento...
			if(caracter == obtemCaracter("}") || caracter == obtemCaracter("]") || caracter == obtemCaracter(")")){
				
				//...Se e a lista estiver vazia a expressão e inválida
				if(simbolos.isEmpty()){
					return false;
				}
				
				/*...Identificamos o simbolo de abertura correspondente ao caracter atual e, em seguida,
				 * validamos se corresponde ao último item da lista (pilha). Se for removemos o último item da lista
				 * e continuamos o processamento, caso contrário, a expressão é inválida.
				 */
				char simboloAbertura = obtemSimboloAbertura(caracter);
				int ultimoIndice = simbolos.size() -1;
				if(simboloAbertura == simbolos.get(ultimoIndice)){
					simbolos.remove(ultimoIndice);
				}else{
					return false;
				}
				
			}
		}
		
		//Retorna false caso ainda exista simbolos de abertura na lista
		if(simbolos.size() > 0){
			return false;
		}
		
		return true;
	}

	private static char obtemSimboloAbertura(char caracter) {
		
		Character retorno = null;
		
		if(caracter == obtemCaracter("}")){
			
			retorno = obtemCaracter("{");
			
		}else if(caracter == obtemCaracter("]")){
			
			retorno = obtemCaracter("[");
			
		}else if(caracter == obtemCaracter(")")){
			
			retorno = obtemCaracter("(");
			
		}
		
		return retorno;
	}

	private static char obtemCaracter(String string) {
		return string.charAt(0);
	}

}
