import  java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\nEscolha a conversão de moedas:");
            System.out.println("1 - [USD-Dolar] =>> [BRL-Real] e [BRL-Real] =>> [USD-Dolar]");
            System.out.println("2 - [CAD-Dolar] =>> [BRL-Real] e [BRL-Real] =>> [CAD-Dolar]");
            System.out.println("3 - [AUD-Dolar] =>> [BRL-Real] e [BRL-Real] =>> [AUD-Dolar]");
            System.out.println("4 - [EUR-Euro]  =>> [BRL-Real] e [BRL-Real] =>>  [EUR-Euro]");
            System.out.println("5 - [ARS-Peso]  =>> [BRL-Real] e [BRL-Real] =>>  [ARS-Peso]");
            System.out.println("6 - [CLP-Peso]  =>> [BRL-Real] e [BRL-Real] =>>  [CLP-Peso]");
            System.out.println("0 - Encerrar");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Programa encerrado");
                break;
            }

            System.out.println("Digite a quantidade a ser convertida:");
            double quantidade = scanner.nextDouble();

            try {
                double resultado = 0;
                switch (choice) {
                    case 1:
                        resultado = converter.converting("USD", "BRL", quantidade);
                        System.out.printf("U$ %.2f dólares americanos é igual a R$ %.2f reais%n", quantidade, resultado);
                        resultado = converter.converting("BRL", "USD", quantidade);
                        System.out.printf("R$ %.2f reais é igual a U$ %.2f dólares americanos%n", quantidade, resultado);
                        break;
                    case 2:
                        resultado = converter.converting("CAD", "BRL", quantidade);
                        System.out.printf("$ %.2f dólares canadenses é igual a R$ %.2f reais%n", quantidade, resultado);
                        resultado = converter.converting("BRL", "CAD", quantidade);
                        System.out.printf("R$ %.2f reais é igual a $ %.2f canadian dólares canadenses%n", quantidade, resultado);
                        break;
                    case 3:
                        resultado = converter.converting("AUD", "BRL", quantidade);
                        System.out.printf("$ %.2f dólares australianos é igual a R$ %.2f reais%n", quantidade, resultado);
                        resultado = converter.converting("BRL", "AUD", quantidade);
                        System.out.printf("R$ %.2f reais é igual a $ %.2f dólares australianos%n", quantidade, resultado);
                        break;
                    case 4:
                        resultado = converter.converting("EUR", "BRL", quantidade);
                        System.out.printf("€ %.2f euros é igual a R$ %.2f reais%n", quantidade, resultado);
                        resultado = converter.converting("BRL", "EUR", quantidade);
                        System.out.printf("R$ %.2f reais é igual a € %.2f euros%n", quantidade, resultado);
                        break;
                    case 5:
                        resultado = converter.converting("ARS", "BRL", quantidade);
                        System.out.printf("$ %.2f pesos argentinos é igual a R$ %.2f reais%n", quantidade, resultado);
                        resultado = converter.converting("BRL", "ARS", quantidade);
                        System.out.printf("R$ %.2f reais é igual a $ %.2f pesos argentinos%n", quantidade, resultado);
                        break;
                    case 6:
                        resultado = converter.converting("ARS", "BRL", quantidade);
                        System.out.printf("$ %.2f pesos chilenos é igual a R$ %.2f reais%n", quantidade, resultado);
                        resultado = converter.converting("BRL", "ARS", quantidade);
                        System.out.printf("R$ %.2f reais é igual a $ %.2f pesos chilenos%n", quantidade, resultado);
                        break;
                    default:
                        System.out.println("Escolha inválida.");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
