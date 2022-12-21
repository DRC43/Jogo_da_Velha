import java.util.Scanner;

public class JogoDaVelha {
    private int[][] tabuleiro = new int[3][3];
    private int jogador = 1;

    public JogoDaVelha() {
    }

    public boolean jogar(int x, int y) {
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            if (this.tabuleiro[x][y] != 0) {
                return false;
            } else {
                this.tabuleiro[x][y] = this.jogador;
                this.jogador = this.jogador == 1 ? 2 : 1;
                return true;
            }
        } else {
            return false;
        }
    }

    public int vencedor() {
        int coluna;
        int posicao;
        for(int j = 1; j < 3; ++j) {
            boolean fechou;
            int linha;
            for(coluna = 0; coluna < 3; ++coluna) {
                fechou = true;

                for(linha = 0; linha < 3; ++linha) {
                    if (this.tabuleiro[linha][coluna] != j) {
                        fechou = false;
                    }
                }

                if (fechou) {
                    return j;
                }
            }

            for(coluna = 0; coluna < 3; ++coluna) {
                fechou = true;

                for(linha = 0; linha < 3; ++linha) {
                    if (this.tabuleiro[coluna][linha] != j) {
                        fechou = false;
                    }
                }

                if (fechou) {
                    return j;
                }
            }

            boolean fechou = true;

            for(posicao = 0; posicao < 3; ++posicao) {
                if (this.tabuleiro[posicao][posicao] != j) {
                    fechou = false;
                }
            }

            if (fechou) {
                return j;
            }

            fechou = true;

            for(posicao = 2; posicao >= 0; --posicao) {
                if (this.tabuleiro[posicao][2 - posicao] != j) {
                    fechou = false;
                }
            }

            if (fechou) {
                return j;
            }
        }

        boolean empate = true;

        for(coluna = 0; coluna < 3; ++coluna) {
            for(posicao = 0; posicao < 3; ++posicao) {
                if (this.tabuleiro[posicao][coluna] == 0) {
                    empate = false;
                }
            }
        }

        if (empate) {
            return 3;
        } else {
            return 0;
        }
    }

    public String toString() {
        String out = "";

        for(int linha = 0; linha < 3; ++linha) {
            for(int coluna = 0; coluna < 3; ++coluna) {
                switch (this.tabuleiro[coluna][linha]) {
                    case 0:
                        out = out + "_ ";
                        break;
                    case 1:
                        out = out + "O ";
                        break;
                    case 2:
                        out = out + "X ";
                }
            }

            out = out + "\n";
        }

        return out;
    }

    public void executar() {
        Scanner entrada = new Scanner(System.in);

        while(this.vencedor() == 0) {
            System.out.println(this);
            System.out.println("Jogador: " + this.jogador);
            System.out.print("Coluna: ");
            int coluna = entrada.nextInt();
            System.out.print("Linha: ");
            int linha = entrada.nextInt();
            if (!this.jogar(coluna, linha)) {
                System.out.println("Jogada invalida, tente novamente...");
            }
        }

        System.out.println(this);
        System.out.println(this.vencedor());
    }

    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        jogo.executar();
    }
}