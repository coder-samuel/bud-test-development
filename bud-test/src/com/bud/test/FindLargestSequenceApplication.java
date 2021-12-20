package com.bud.test;

import java.util.Scanner;

public class FindLargestSequenceApplication {

	public static void main(String[] args) {

		Scanner numbersEntered = new Scanner(System.in);

		String numSequenciaString;

		char[] arrayValores;
		int[] arrayInteiros;

		int index = 0;
		int resultado = 0;
		int numeroAnterior = 0;
		int numeroContagemAtual = 0;
		int contadorSequenciaAtual = -1;
		int contadorMaiorSequencia = 0;
		int primNumDaSequencialAtual = 0;
		int ultimoNumDaSequenciaAtual = 0;
		int primNumDaSequenciaAnterior = 0;
		int ultimoNumDaSequenciaAnterior = 0;

		System.out.println("Por favor, digite uma sequência de números inteiros numa ordem qualquer: ");
		numSequenciaString = numbersEntered.next();
		arrayValores = numSequenciaString.toCharArray();
		arrayInteiros = new int[arrayValores.length];

		for (int i = 0; i < arrayValores.length; i++) {
			arrayInteiros[i] = Integer.parseInt(String.valueOf(arrayValores[i]));
		}
		for (int i = 0; i < arrayInteiros.length; i++) 
		{
			numeroContagemAtual = arrayInteiros[i];

			if (numeroContagemAtual - numeroAnterior == 1 && numeroContagemAtual != 0) 
			{
				contadorSequenciaAtual++;	
			} 
			else if (numeroContagemAtual == 9 && numeroAnterior == 8) 
			{
				contadorSequenciaAtual++;
			} 
			else if (numeroContagemAtual - numeroAnterior == 0 && numeroContagemAtual == 0) 
			{
				if (numeroContagemAtual == numeroAnterior && numeroContagemAtual == 0) 
				{
					contadorSequenciaAtual = 0;	
				} 
				else {
					contadorSequenciaAtual++;
				}
			} 
			else if (numeroContagemAtual == numeroAnterior + 1 && numeroContagemAtual <= 8) 
			{
				contadorSequenciaAtual++;
			} 
			else if (numeroContagemAtual == 0 && numeroAnterior == 9) 
			{
				contadorSequenciaAtual++;
			} 
			else if (numeroContagemAtual <= numeroAnterior && numeroContagemAtual != 0) 
			{
				contadorSequenciaAtual = 0;
			} 
			else {
				contadorSequenciaAtual = 0;
			}

			if (contadorSequenciaAtual == 1 && numeroContagemAtual == 0) 
			{
				primNumDaSequencialAtual = 9;
			} 
				else if (contadorSequenciaAtual == 1 && numeroContagemAtual != 0) 
			{
				primNumDaSequencialAtual = numeroContagemAtual - 1;
			}
			
			if (contadorSequenciaAtual >= 1) 
			{
				ultimoNumDaSequenciaAtual = numeroContagemAtual;

				if (contadorSequenciaAtual >= contadorMaiorSequencia) 
				{
					if (contadorSequenciaAtual > contadorMaiorSequencia) 
					{
						contadorMaiorSequencia = contadorSequenciaAtual;
						primNumDaSequenciaAnterior = primNumDaSequencialAtual;
						ultimoNumDaSequenciaAnterior = ultimoNumDaSequenciaAtual;
					}
				}
				if (contadorSequenciaAtual == contadorMaiorSequencia) 
				{
					if (primNumDaSequencialAtual > primNumDaSequenciaAnterior) 
					{
						primNumDaSequenciaAnterior = primNumDaSequencialAtual;
						ultimoNumDaSequenciaAnterior = ultimoNumDaSequenciaAtual;
					}
				}
			}
			numeroAnterior = numeroContagemAtual;
		}
		
		resultado = primNumDaSequenciaAnterior;
		if(contadorMaiorSequencia != 0) 
		{
			for (index = 0; index < contadorMaiorSequencia+1; index++) 
			{
				if (resultado == 10) 
				{
					resultado++;
					resultado = -1;
					resultado++;
				}
				resultado++;
				System.out.print(resultado - 1);
			}
		}
		else 
		{
			System.out.println("Nenhuma sequência foi encontrada!");
		}
	}
}

