package com.silva.xpto.domain.relatorios;

public class ValorTransacao {
	
public double valorTransacao(Integer qtdTransacao){
	   
    if (qtdTransacao <= 10) {
      return 1.00;

    } else if ((qtdTransacao > 10) && (qtdTransacao <= 20)){
      return 0.75;

    } else {
      return 0.50;
    }

  }  
}
