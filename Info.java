package lt.codeacademy.java2kursas.namudarbai2savaite.tankas_v2;

import java.util.Arrays;

public class Info extends Kintamieji {
	Kintamieji kintamieji = new Kintamieji();

	public void bendraInfo() {
		kintamieji.getKryptis();
		kintamieji.getPozicija();
		kintamieji.getSuviai();
		kintamieji.getTankoKryptis();
		
/*		TESTAVIMAS
		System.out.println("Tanko kryptis:\n--------------" + Arrays.toString(kintamieji.getKryptis()));
		System.out.println("Tanko pozicija s, r, p, v \n" +
		"--------------" + Arrays.toString(kintamieji.getPozicija()));
		System.out.println(kintamieji.getSuviai());
		System.out.println(kintamieji.getTankoKryptis());
*/
	}

	public void pirmyn() {
		kintamieji.go();
	}
	public void atgal() {
		kintamieji.back();
	}
	
	public void info() {
		tankoPozicija();
		
		tankoKryptis();
		tankoKryptisPrint();
		tankoIssautiSoviniai();
		tankoSovimoKryptys();
		suvioNrspausdinimas();
	}

	
}
