package com.github.krtowl;

import javax.swing.*;
import java.util.InputMismatchException;


public class Usuario {

    private Grade grade;

    public void iniciar(){
        criarGrade();
        mostrarGradeMontada();
        posicionarCelulas();
        while (true) {

            grade = grade.proximo();
            grade.mostrarGradeMontada();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void criarGrade(){
        while (true){
            try {
                JOptionPane.showMessageDialog(null, "Vamos escolher o tamanho da grade");
                var coluna = new Tamanho(Integer.parseInt(JOptionPane.showInputDialog("Digite quantas colunas vai ter:")));
                var linhas = new Tamanho(Integer.parseInt(JOptionPane.showInputDialog("Digite quantas linhas vai ter:")));
                grade = new Grade(linhas, coluna);
                return;
            } catch (InputMismatchException | NumberFormatException | Tamanho.TamanhoInvalido ex) {
                JOptionPane.showMessageDialog(null, "Coloque um tamanho válido (inteiro positivo)!!!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void mostrarGradeMontada() {
        if(grade == null) return;

        grade.mostrarGradeMontada();
    }


    public void posicionarCelulas(){

        int input = JOptionPane.showConfirmDialog(null, "Você quer posicionar as células manualmente?");
        // 0=yes, 1=no, 2=cancel
        if (input == 0){
            do {
                int coluna = ((Integer.parseInt(JOptionPane.showInputDialog("Em qual coluna você quer posicionar a celula? Lembrando que colunha é no sentido horizontal >>>>>"))) - 1);
                int linha = ((Integer.parseInt(JOptionPane.showInputDialog("Em qual linha você quer posicionar a celula? Lembrando que linha é no sentido vertical V")))-1);

                grade.trocarCelulaParaViva(coluna, linha);
                System.out.println("Grade Atualizada");
                mostrarGradeMontada();
                input = JOptionPane.showConfirmDialog(null, "Gostaria de posicionar mais uma célula?");
            } while (input == 0);
        }
    }



}









