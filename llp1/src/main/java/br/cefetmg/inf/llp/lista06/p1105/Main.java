package br.cefetmg.inf.llp.lista06.p1105;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int divida [] = new int [20];
        int numBancos, numDevedores, bancoCredor, bancoDevedor, valorPedido;
        
        while (true) {
            numBancos = sc.nextInt();
            numDevedores = sc.nextInt();
            
            if (numBancos == 0 && numDevedores == 0) 
                break;
            
            for (int i = 0; i < numBancos; i++)
                divida [i] = sc.nextInt();
            
            for (int aux = 0; aux < numDevedores; aux++) {
                bancoDevedor = sc.nextInt();
                bancoCredor = sc.nextInt();
                valorPedido = sc.nextInt();
                
                if (bancoDevedor == bancoCredor) {
                    aux --;
                    continue;
                }
                
                divida [bancoCredor - 1] += valorPedido;
                divida [bancoDevedor - 1] -= valorPedido;
                
            }
            
            int num = 0;
            for (int i = 0; i < numBancos; i++) 
                if (divida [i] >= 0)
                    num++;

            if (num == numBancos)
                System.out.println("S");
            else
                System.out.println("N");
        }
    }
}
