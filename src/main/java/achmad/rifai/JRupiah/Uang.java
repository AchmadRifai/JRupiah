package achmad.rifai.JRupiah;

import java.math.BigInteger;

public class Uang {
	private BigInteger nilai;
	private char koma, titik;
	private String mata;

	public Uang(String s) throws UangException {
		super();
		validasi(s);
		mata = "";
		nilai = BigInteger.ZERO;
		koma = ' ';
		titik = ' ';
		decode(s);
	}

	private void validasi(String s) throws UangException {
		if(s == null)
			throw new UangException("String tidak boleh kosong");
		if(s == "")
			throw new UangException("Format String Ditolak");
	}

	public Uang(BigInteger nilai, MataUang mu) throws UangException {
		super();
		if(nilai == null)
			throw new UangException("Nilai uang harus diisi");
		if(mu == null)
			throw new UangException("Mata Uang Harus Jelas");
		this.nilai = nilai;
		koma = mu.getKoma();
		titik = mu.getTitik();
		mata = mu.getMata();
	}

	Uang(BigInteger nilai, char koma, char titik, String mata) {
		super();
		this.nilai = nilai;
		this.koma = koma;
		this.titik = titik;
		this.mata = mata;
	}

	private void decode(String s) throws UangException {
		boolean spasi = false, foundKoma = false, foundTitik = false;
		int off = 0;
		for(char c : s.toCharArray()) {
			if(c != ' ') {
				if(spasi) {
					if(Character.isDigit(c)) {
						off++;
						nilai = nilai.multiply(BigInteger.TEN);
						nilai = nilai.add(new BigInteger("" + c));
					} else {
						if(!foundTitik) {
							titik = c;
							foundTitik = true;
							off = 0;
						} else if(!foundKoma && c != titik) {
							koma = c;
							foundKoma = true;
							off = 0;
						} else throw new UangException("Terlalu Banyak Tanda");
					}
				} else mata += c;
			} else spasi = true;
		} buatTitik(off); 
	}

	private void buatTitik(int off) {
		if(koma == ' ') {
			for(int x = 0; x < off; x++)
				nilai = nilai.divide(BigInteger.TEN);
			koma = titik;
		} if(koma == ',') titik = '.';
		if(koma == '.') titik = ',';
	}

	@Override
	public String toString() {
		String s = mata + " ", end = koma + "00";
		BigInteger tmp = nilai;
		int i = 3;
		while(tmp != BigInteger.ZERO) {
			BigInteger v = tmp.mod(BigInteger.TEN);
			tmp = tmp.divide(BigInteger.TEN);
			end = "" + v + end;
			i--;
			if(tmp != BigInteger.ZERO && i == 0) {
				end= "" + titik + end;
				i = 3;
			}
		} return s + end;
	}

	BigInteger getNilai() {
		return nilai;
	}

	char getKoma() {
		return koma;
	}

	char getTitik() {
		return titik;
	}

	String getMata() {
		return mata;
	}
}