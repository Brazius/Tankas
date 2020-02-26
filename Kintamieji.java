package lt.codeacademy.java2kursas.namudarbai2savaite.tankas_v2;

import java.net.Socket;
import java.util.Arrays;

public class Kintamieji {
	private static int[] kryptis = { 1, 0, 0, 0 };
	protected static int[] pozicija = new int[4];
	private int tankoKryptis = 1; // 1 - siaure , 2 - rytai, 3 - pietus, 4 - vakarai
	private int s; // suvis i siaure
	private int r; // suvis i rytus
	private int p; // suvis i pietus
	private int v; // suvis i vakarus
	private int suviai = 10;
	private String[] suvioNumerioTextas = new String[100];
	private static int suvioNumeris = 1;
	private String tankoSivomoKryptisTxt;
	private String[] suvioPozicija = new String[100];
	private String suvioPozicijaTxt;

	public int getSuviai() {
		return suviai;
	}

	public void setSuviai(int suviai) {
		this.suviai = suviai;
	}

	public int[] getKryptis() {
		return kryptis;
	}

	public void setKryptis(int[] kryptis) {
		this.kryptis = kryptis;
	}

	public int[] getPozicija() {
		return pozicija;
	}

	public void setPozicija(int[] pozicija) {
		this.pozicija = pozicija;
	}

	public int getTankoKryptis() {
		return tankoKryptis;
	}

	public void setTankoKryptis(int tankoKryptis) {
		this.tankoKryptis = tankoKryptis;
	}

	public int[] go() {

		if (kryptis[0] == 1) {
			if (pozicija[2] > 0) {
				pozicija[2] -= 1;
				return pozicija;
			}
			pozicija[0] += 1;
			return pozicija;

		} else if (kryptis[1] == 2) {
			if (pozicija[3] > 0) {
				pozicija[3] -= 1;
				return pozicija;
			}
			pozicija[1] += 1;
			return pozicija;

		} else if (kryptis[2] == 3) {
			if (pozicija[0] > 0) {
				pozicija[0] -= 1;
				return pozicija;
			}
			pozicija[2] += 1;
			return pozicija;

		} else if (kryptis[3] == 4) {
			if (pozicija[1] > 0) {
				pozicija[1] -= 1;
			} else {
				pozicija[3] += 1;
			}
		}
		return pozicija;
	}

	public int[] back() {

		if (kryptis[0] == 1) {
			if (pozicija[0] > 0) {
				pozicija[0]--;
				return pozicija;
			}
			pozicija[2]++;
			return pozicija;

		} else if (kryptis[1] == 2) {
			if (pozicija[1] > 0) {
				pozicija[1]--;
				return pozicija;
			}
			pozicija[3]++;
			return pozicija;

		} else if (kryptis[2] == 3) {
			if (pozicija[2] > 0) {
				pozicija[2]--;
				return pozicija;
			}
			pozicija[0]++;
			return pozicija;

		} else if (kryptis[3] == 4) {
			if (pozicija[3] > 0) {
				pozicija[3]--;
				return pozicija;
			}
			pozicija[1]++;
			return pozicija;
		}
		return pozicija;
	}

	public int[] desinen() {
		if (kryptis[0] == 1) {
			kryptis[0] -= 1;
			kryptis[1] += 2;
			return kryptis;
		} else if (kryptis[1] == 2) {
			kryptis[1] -= 2;
			kryptis[2] += 3;
			return kryptis;
		} else if (kryptis[2] == 3) {
			kryptis[2] -= 3;
			kryptis[3] += 4;
			return kryptis;
		} else {
			kryptis[3] -= 4;
			kryptis[0] += 1;
			return kryptis;
		}
	}

	public int[] kairen() {

		if (kryptis[0] == 1) {
			kryptis[0] -= 1;
			kryptis[3] += 4;
			return kryptis;

		} else if (kryptis[1] == 2) {
			kryptis[1] -= 2;
			kryptis[0] += 1;
			return kryptis;

		} else if (kryptis[2] == 3) {
			kryptis[2] -= 3;
			kryptis[1] += 2;
			return kryptis;
		} else {
			kryptis[3] -= 4;
			kryptis[2] += 3;
			return kryptis;
		}

	}

	public String tankoPozicija() {
		if (getPozicija()[0] > 0 && getPozicija()[1] > 0) {
			System.out.println("Tanko pozicija: Siaure: " + pozicija[0] + ", " + "Rytai: " + pozicija[1] + ".");
			return this.suvioPozicijaTxt = ("(siaure " + pozicija[0] + ", rytai " + pozicija[1] + ").");

		} else if (getPozicija()[0] > 0 && getPozicija()[3] > 0) {
			System.out.println("Tanko pozicija: Siaure: " + pozicija[0] + ", " + "Vakarai: " + pozicija[3] + ".");
			return this.suvioPozicijaTxt = "(siaure " + pozicija[0] + ", vakarai " + pozicija[3] + ").";

		} else if (getPozicija()[0] > 0) {
			System.out.println("Tanko pozicija: Siaure: " + pozicija[0] + ".");
			return this.suvioPozicijaTxt = "(siaure " + pozicija[0] + ").";

		} else if (getPozicija()[1] > 0 && getPozicija()[2] > 0) {
			System.out.println("Tanko pozicija: Rytai: " + pozicija[1] + ", " + "Pietus: " + pozicija[2] + ".");
			return this.suvioPozicijaTxt = "(rytai " + pozicija[1] + ", pietus " + pozicija[2] + ").";

		} else if (getPozicija()[1] > 0) {
			System.out.println("Tanko pozicija: Rytai: " + pozicija[1] + ".");
			return this.suvioPozicijaTxt = "(rytai " + pozicija[1] + ").";

		} else if (getPozicija()[2] > 0 && getPozicija()[3] > 0) {
			System.out.println("Tanko pozicija: Pietus: " + pozicija[2] + ", " + "Vakarai: " + pozicija[3] + ".");
			return this.suvioPozicijaTxt = "(pietus " + pozicija[2] + ", vakarai " + pozicija[3] + ").";

		} else if (getPozicija()[2] > 0 && getPozicija()[3] == 0) {
			System.out.println("Tanko pozicija: Pietus: " + pozicija[2] + ".");
			return this.suvioPozicijaTxt = "(pietus " + pozicija[2] + ").";

		} else if (getPozicija()[3] > 0 && getPozicija()[0] > 0) {
			System.out.println("Tanko pozicija: Vakarai: " + pozicija[3] + ", " + "Siaure: " + pozicija[0] + ".");
			return this.suvioPozicijaTxt = "(vakarai " + pozicija[3] + ", siaure " + pozicija[0] + ").";

		} else if (getPozicija()[3] > 0 && getPozicija()[0] == 0) {
			System.out.println("Tanko pozicija: Vakarai: " + pozicija[3] + ".");
			return this.suvioPozicijaTxt = "(vakarai " + pozicija[3] + ").";
		}
		return this.suvioPozicijaTxt;
	}

	public void tankoKryptisPrint() {
		System.out.println("Tanko kryptis: "+ tankoSivomoKryptisTxt);
	}

	public String tankoKryptis() {
		if (kryptis[0] == 1) {
			return tankoSivomoKryptisTxt = "siuare";
		} else if (kryptis[1] == 2) {
			return tankoSivomoKryptisTxt = "rytai";
		} else if (kryptis[2] == 3) {
			return tankoSivomoKryptisTxt = "pietus";
		} else {
			return tankoSivomoKryptisTxt = "vakarai";
		}
	}

	public int suvis() {
		if (suviai == 0) {
			System.err.println("Nera soviniu...");
			return suviai;
		}
		sovimokryptis();
		suvioInfo();
		suviai--;
		return suviai;

	}


	public String[] suvioInfo() {
		tankoKryptis();
		suvioPozicijaRadimas();
		suvioNumerioTextas[suvioNumeris - 1] = "Tanko suvis Nr. " + suvioNumeris + ": kryptis = "
				+ tankoSivomoKryptisTxt + ", pozicija " + suvioPozicijaRadimas();
		
		++suvioNumeris;
		return suvioNumerioTextas;

	}
	public String suvioPozicijaRadimas() {
		if (getPozicija()[0] > 0 && getPozicija()[1] > 0) {
			return this.suvioPozicijaTxt = ("(siaure " + pozicija[0] + ", rytai " + pozicija[1] + ").");

		} else if (getPozicija()[0] > 0 && getPozicija()[3] > 0) {
			return this.suvioPozicijaTxt = "(siaure " + pozicija[0] + ", vakarai " + pozicija[3] + ").";

		} else if (getPozicija()[0] > 0) {
			return this.suvioPozicijaTxt = "(siaure " + pozicija[0] + ").";

		} else if (getPozicija()[1] > 0 && getPozicija()[2] > 0) {
			return this.suvioPozicijaTxt = "(rytai " + pozicija[1] + ", pietus " + pozicija[2] + ").";

		} else if (getPozicija()[1] > 0) {
			return this.suvioPozicijaTxt = "(rytai " + pozicija[1] + ").";

		} else if (getPozicija()[2] > 0 && getPozicija()[3] > 0) {
			return this.suvioPozicijaTxt = "(pietus " + pozicija[2] + ", vakarai " + pozicija[3] + ").";

		} else if (getPozicija()[2] > 0 && getPozicija()[3] == 0) {
			return this.suvioPozicijaTxt = "(pietus " + pozicija[2] + ").";

		} else if (getPozicija()[3] > 0 && getPozicija()[0] > 0) {
			return this.suvioPozicijaTxt = "(vakarai " + pozicija[3] + ", siaure " + pozicija[0] + ").";

		} else if (getPozicija()[3] > 0 && getPozicija()[0] == 0) {
			return this.suvioPozicijaTxt = "(vakarai " + pozicija[3] + ").";
		}
		return suvioPozicijaTxt;
	}
	public void suvioNrspausdinimas() {
		for (int i = 0; i < suvioNumerioTextas.length; i++) {
			if (suvioNumerioTextas[i] != null) {
				System.out.println(suvioNumerioTextas[i]);
			}
		}
	}

	public int sovimokryptis() {
		if (kryptis[0] == 1) {
			s++;
			return s;
		} else if (kryptis[1] == 2) {
			r++;
			return r;
		} else if (kryptis[2] == 3) {
			p++;
			return p;
		}
		v++;
		return v;
	}

	public String tankoSovimoKryptys() {
		if (s > 0) {
			System.out.println("Tanko sauti suviai i siaure: " + s);
		}
		if (r > 0) {
			System.out.println("Tanko sauti suviai i rytus: " + r);
		}
		if (p > 0) {
			System.out.println("Tanko sauti suviai i pietus: " + p);
		}
		if (v > 0) {
			System.out.println("Tanko sauti suviai i vakarus: " + v);
		}
		return null;
	}

	public void tankoIssautiSoviniai() {
		if (suviai != 10) {
			System.out.println("Tanko issauti soviniai: " + (10 - suviai));
		}
	}

	public String[] getSuvioPozicija() {
		return suvioPozicija;
	}

	public String[] setSuvioPozicija(String[] suvioPozicija) {
		this.suvioPozicija = suvioPozicija;
		return suvioPozicija;
	}

}