package enquete;

import java.security.SecureRandom;

public class Enquete {
    private int quantidadeMax = 100;
    private int quantidade;
    private int[] notas = new int[quantidadeMax];    
    public Enquete(int quantidade) {
        this.quantidade = quantidade; 
    }
    public void setNotas(int nota){
        for(int i = 0; i < quantidade; i++)
            if(this.notas[i] == 0){
                this.notas[i] = nota;
                break;
            }
    }
    public void setNotas(int[] notas){
        this.notas = notas;
    }
    public int[] getNotas(){
        return this.notas;
    }  
    public int getNotas(int indice){
        return this.notas[indice];
    }
    private void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public boolean registrarNotasManual(int nota){
        if(nota > 1 && nota < 10){
            setNotas(nota);      
            return true;
        }
        return false;
    }
    public void registrarNotasAleatorias(){
        SecureRandom gerador = new SecureRandom();
        int numeroGerado;
        for(int i = 0; i < this.quantidade; i++){
            do{
                numeroGerado = gerador.nextInt(11);
            }while(numeroGerado == 0);
            setNotas(numeroGerado);
        }
    }
    public int quantidadeClientes(){
        int totalClientes = 0;
        for(int i = 0; ; i++)
            if(this.notas[i] == 0)
                break;
            else
                totalClientes++;
        return totalClientes;
    }   
    public double mediaEnquete(){
        double media = 0, resultado, qtd = 0.0;
        for(int i = 0; i < this.quantidade; i++){
            media += this.notas[i];
            qtd++;
        }
        return (media/qtd);
    }
    public int mostrarFrequencia(int nota){
        int frequencia = 0;
        for(int i = 0; i < this.quantidade; i++){
            if(this.notas[i] == nota)
                frequencia++;
        }
        return frequencia;
    }
}



