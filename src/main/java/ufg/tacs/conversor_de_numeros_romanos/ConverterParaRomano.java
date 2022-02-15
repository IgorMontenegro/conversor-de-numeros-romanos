package ufg.tacs.conversor_de_numeros_romanos;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterParaRomano
{	
	//Mapa de tradução de números romanos para decimais
	private Map<String, Integer> enumeradorRomanos;
	
	public Integer converter(String numeroRomano) {
		
		Integer numeroDecimal = null;
		iniciarTabelaDeConversao();
		
		if(numeroRomano != null && !numeroRomano.isEmpty() && validarNumerosRomanos(numeroRomano) ){
			numeroRomano = numeroRomano.toUpperCase();
			numeroDecimal = enumeradorRomanos.get(numeroRomano);

			if(numeroDecimal == null){
				numeroDecimal = 0;
				
				int i = 0;
				
				while (i < numeroRomano.length()) {
			          
		             char letraRomano = numeroRomano.charAt(i);
		             String stringLetraRomano = letraRomano + "";
		             
		             if(enumeradorRomanos.containsKey(stringLetraRomano)) {
			             int numeroAtual = enumeradorRomanos.get(stringLetraRomano); 
			             i++; 
			             
			             if (i == numeroRomano.length()) {
			                
			            	 numeroDecimal += numeroAtual;
			             }
			             else {
			            	 char letraProximoRomano = numeroRomano.charAt(i); 
			            	 String proximoRomano = letraProximoRomano + "";
			            	 
			                int numeroProximo = enumeradorRomanos.get(proximoRomano);
			                if (numeroProximo > numeroAtual) {
			                	numeroDecimal += (numeroProximo - numeroAtual);
			                	i++;
			                }
			                else {
			                	numeroDecimal += numeroAtual;
			                }
			             }
		             } 
		          }   
			}
			
			return numeroDecimal;
		}
		return numeroDecimal;
	}

	private void iniciarTabelaDeConversao() {
		enumeradorRomanos = new HashMap<String, Integer>();
		enumeradorRomanos.put("I", 1);
		enumeradorRomanos.put("II", 2);
		enumeradorRomanos.put("III", 3);
		enumeradorRomanos.put("IV", 4);
		enumeradorRomanos.put("V", 5);
		enumeradorRomanos.put("VI", 6);
		enumeradorRomanos.put("VII", 7);
		enumeradorRomanos.put("VIII", 8);
		enumeradorRomanos.put("IX", 9);
		enumeradorRomanos.put("X", 10);
		enumeradorRomanos.put("L", 50);
		enumeradorRomanos.put("C", 100);
		enumeradorRomanos.put("D", 500);
		enumeradorRomanos.put("M", 1000);
		
	}

	private boolean validarNumerosRomanos(String romano) {
		boolean resultado = false;
		
		romano = romano.toUpperCase();
		
		/*A pedido do professor, a notação do número 4000 foi mudada para MMMM, pois não é possível comparar a notação
		original romana.*/
		
		Pattern pattern = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
		Matcher matcher = pattern.matcher(romano);
		boolean regexValido = matcher.matches();
		
		if(regexValido){
			resultado = true;
		}
		
		return resultado;
	}
}


