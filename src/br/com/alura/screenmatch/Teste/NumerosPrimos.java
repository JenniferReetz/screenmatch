package br.com.alura.screenmatch.Teste;
public class NumerosPrimos {
    public boolean verificarPrimalidade(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void listarPrimos(int limiteSuperior) {
        System.out.println("Números primos até " + limiteSuperior + ": ");
        for (int i = 2; i <= limiteSuperior; i++) {
            if (verificarPrimalidade(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

    // Subclasse VerificadorPrimo
     class VerificadorPrimo extends NumerosPrimos {
        public void verificarSeEhPrimo(int numero) {
            if (verificarPrimalidade(numero)) {
                System.out.println(numero + " é primo.");
            } else {
                System.out.println(numero + " não é primo.");
            }
        }
    }

    // Subclasse GeradorPrimo
     class GeradorPrimo extends NumerosPrimos {
        public int gerarProximoPrimo(int ultimoPrimoConhecido) {
            int proximoNumero = ultimoPrimoConhecido + 1;
            while (!verificarPrimalidade(proximoNumero)) {
                proximoNumero++;
            }
            return proximoNumero;
        }
    }

    // Classe de Teste
    class TesteNumerosPrimos {
        public static void main(String[] args) {
            VerificadorPrimo verificador = new VerificadorPrimo();
            verificador.verificarSeEhPrimo(17);

            GeradorPrimo gerador = new GeradorPrimo();
            int proximoPrimo = gerador.gerarProximoPrimo(17);
            System.out.println("O próximo primo após 17 é: " + proximoPrimo);

            NumerosPrimos numerosPrimos = new NumerosPrimos();
            numerosPrimos.listarPrimos(30);
        }
    }

