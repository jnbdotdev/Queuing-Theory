package logics;

public class Formulas {

		
	public double tempoMedioChegadas(double lambda) {
		
		double result = 1/lambda;
		
		return result;
	}
	
	public double tempoMedioAtendimento(double mi) {
		
		double result = 1/mi;
		
		return result;
	}
	
	public double numeroProvavelSistema(double lambda, double mi) {
		
		double result = lambda/(mi-lambda);
				
		return result;
	}
	
	public double numeroProvavelFila(double lambda, double mi) {
		
		double result = Math.pow(lambda, 2)/(mi*(mi-lambda));
				
		return result;
	}
	
	public double pOcupacaoSistema(double lambda, double mi) {
		
		double result = lambda/mi;
		
		return result;
	}
	
	public double probabilidadeSistemaVazio(double lambda, double mi) {
		
		double result = 1 - this.pOcupacaoSistema(lambda, mi);
		
		return result;
	}
	
	public double probabilidadeFilaVazia(double lambda, double mi) {
		
		double result = 1 - Math.pow(this.pOcupacaoSistema(lambda, mi),2);
		
		return result;
		
	}
	
	public double tempoProvavelSistema(double lambda, double mi) {
		
		double result = 1/(mi - lambda);
		
		return result;
		
	}
	
	public double tempoProvavelFila(double lambda, double mi) {
		
		double result = lambda/(mi*(mi-lambda));
		
		return result;
		
	}

}
