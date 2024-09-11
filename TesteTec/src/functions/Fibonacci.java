package functions;

import java.util.Scanner;

public class Fibonacci {
	// Função para verificar se o número pertence à sequência de Fibonacci
    public static boolean ehFibonacci(int number) {
        if (number == 0 || number == 1) {
            return true;
        }

        int a = 0, b = 1;
        int prox = a + b;

        // Gerar a sequência até que o valor seja maior ou igual ao número informado
        while (prox <= number) {
            if (prox == number) {
                return true;
            }
            a = b;
            b = prox;
            prox = a + b;
        }

        return false;
    }

    public static void checkLetterA(String text) {
        int count = 0;
        
        // Converta o texto para minúsculas para facilitar a contagem
        String lowerCaseText = text.toLowerCase();
        
        // Contar o número de ocorrências de 'a'
        for (char c : lowerCaseText.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }
        
        // Exibir o resultado
        if (count > 0) {
            System.out.println("A letra 'a' ocorre " + count + " vez(es) na string.");
        } else {
            System.out.println("A letra 'a' não ocorre na string.");
        }
    }
    
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1. Verificar se um número pertence à sequência de Fibonacci");
        System.out.println("2. Contar a ocorrência da letra 'a' em uma string");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha restante

        switch (choice) {
            case 1:
                System.out.print("Informe um número: ");
                int number = scanner.nextInt();
                if (ehFibonacci(number)) {
                    System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
                } else {
                    System.out.println("O número " + number + " NÃO pertence à sequência de Fibonacci.");
                }
                break;
                
            case 2:
                System.out.print("Informe uma string: ");
                String text = scanner.nextLine();
                checkLetterA(text);
                break;
                
            default:
                System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
                break;
        }

        scanner.close();
    }
    

}
