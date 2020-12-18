package enquete;

import java.util.Scanner;

public class Teste {
    static Scanner input;
    public static void main(String[] args) {            
        input = new Scanner(System.in);
        int quantidaDeAlunos;
        int opcao;
        quantidaDeAlunos = menu1();
        Enquete enquete = new Enquete(quantidaDeAlunos);
        opcao = menu2();  
        if(opcao == 3){
                return;
        }
        switch(opcao){
            case 1:
                registrarNotasManual(enquete, quantidaDeAlunos);
                    break;
            case 2:
                enquete.registrarNotasAleatorias();
                break;
        } 
        do{
            opcao = menu3();
            switch(opcao){
                case 1: // Mostra a media da enquete
                    mostrarMediaEnquete(enquete);
                    break;
                case 2: // Mostra as notas da enquete
                    mostrarNotasAlunos(enquete, quantidaDeAlunos);
                    break;
                case 3: // Procura um aluno e mostra a nota
                    mostrarNotaDoAluno(enquete, quantidaDeAlunos);
                    break;
                case 4: // Mostra a frequencia que uma nota aparece
                    mostrarFrequenciaDaNota(enquete, quantidaDeAlunos);                    
                    break;
            }
        }while(opcao != 0);
    }

    private static int menu3() {
        int opcao;
        do{
            System.out.print("\nO que voce deseja fazer:"
                    + "\n(1). Mostrar media"
                    + "\n(2). Mostrar todas as notas"
                    + "\n(3). Mostrar a nota de um aluno"
                    + "\n(4). Mostrar a frequncia que uma nota aparece"
                    + "\n(0). Encerrar"
                    + "\nOpcao desejada: ");
            opcao = input.nextInt();
        }while(opcao < 0 || opcao > 4);
        return opcao;
    }
    private static int menu2() {
        int opcao;
        do{
            System.out.print("\nDeseja digitar as notas ou gerar uma pesquisa aleatoria:"
                    + "\n(1). Digitar"
                    + "\n(2). Aleatoria"
                    + "\n(0). Encerrar"
                    + "\nOpcao desejada: ");
            opcao = input.nextInt();
        }while(opcao < 0 && opcao > 2);
        return opcao;
    }
    private static int menu1(){
        int quantidadeAlunos;
        do{
            System.out.print("Pesquisa de satisfacao do bandejao do CEFET-MG"
                    + "\nDigite a quantidade de alunos que irao participar da pesquisa de satisfacao do bandejao (numero maximo 100): ");
            quantidadeAlunos = Integer.parseInt(input.nextLine());
        }while(quantidadeAlunos < 1 || quantidadeAlunos > 100);
        return quantidadeAlunos;
    }
    private static void mostrarNotaDoAluno(Enquete enquete, int quantidadeAlunos) {
        int aluno;
        do{
            System.out.print("\nDigite o numero do aluno que deseja saber a nota: ");
            aluno = input.nextInt();
        }while(aluno < 1 || aluno > quantidadeAlunos);
        printarAluno(enquete, aluno-1);
    }
    private static void printarAluno(Enquete enquete, int indiceAluno){
        System.out.println("\nA nota que o aluno de indice "+(indiceAluno+1)+" deu foi: "+enquete.getNotas(indiceAluno));
    }
    private static void mostrarNotasAlunos(Enquete enquete, int quantidadeDeAlunos){
        for(int i = 0; i < quantidadeDeAlunos; i++){
            printarAluno(enquete, i);
        }
    }
    private static void mostrarFrequenciaDaNota(Enquete enquete, int quantidadeAlunos) {
        int nota;
        do{
            System.out.print("\nDigite a nota que gostaria de saber a frequencia: ");
            nota = input.nextInt();
        }while(nota < 1 || nota > 10);
        var frequencia = enquete.mostrarFrequencia(nota); 
        System.out.println("A frequencia que a nota "+nota+" aparece é: "+frequencia);
    }
    private static void mostrarMediaEnquete(Enquete enquete){
        System.out.println("\nA media de notas dos "+enquete.getQuantidade()+" alunos, foi de: "+ enquete.mediaEnquete());
    }
    private static void registrarNotasManual(Enquete enquete, int quantidaDeAlunos) {
        int[] notas = new int[quantidaDeAlunos];
        for(int i = 0; i < quantidaDeAlunos; i++){
            do{
                System.out.print((i+1)+". Digite a nota: ");
                notas[i] = input.nextInt();
            }while(notas[i] < 1 || notas[i] > 10);
        }
        enquete.setNotas(notas);
    }
}
    




























