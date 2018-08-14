/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.exercicioPP;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Geraldo
 */
public class JogoAdivinheONumero {

    public static void main(String[] args) {
        final int NUM_ALEATORIOS = 50;
        final int NUM_TENTATIVAS = 10;
        Random numeroAleatorio = new Random();
        int sorteado = numeroAleatorio.nextInt(NUM_ALEATORIOS+1);
        Scanner s = new Scanner(System.in);
        int numDigitado, tentativas = 0;

        System.out.println("Bem vindo ao jogo!!!\n"
                + "Decubra o numero sorteado pelo sistema");

        do {
            System.out.println("Digite um numero inteiro de 0 até " + NUM_ALEATORIOS);
            if (!s.hasNextInt()) {
                throw new IllegalArgumentException(s.next() + " não é um argumento valido");
            }
            numDigitado = s.nextInt();
            if (numDigitado < 0 || numDigitado > NUM_ALEATORIOS) {
                throw new IllegalArgumentException("O numero digitado deve ser maior que 0 e menor ou igual a "+NUM_ALEATORIOS + " :"+ numDigitado);
            }

            tentativas++;

            if (numDigitado < sorteado) {
                System.out.println("Errou!!! Numero digitado é menor que o numero sorteado");
                System.out.println(" Você fez: " + tentativas + " tentativas");
            } else if (numDigitado > sorteado) {
                System.out.println("Errou!!! Numero digitado é maior que o numero sorteado");
                System.out.println(" Você fez: " + tentativas + " tentativas");
            } else {
                System.out.println("Você acertou, parabéns!!!");
                System.out.println(" Você fez: " + tentativas + " tentativas");
                return;
            }

            System.out.println("");
            
            

        } while (tentativas < NUM_TENTATIVAS);
        s.close();
        System.out.println("fim de programa!!!");
        System.out.println(sorteado);
    }

}
