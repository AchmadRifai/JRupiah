package achmad.rifai.JRupiah;

public class MataUang {
	private char titik, koma;
	private String mata;

	private MataUang(char titik, char koma, String mata) {
		super();
		this.titik = titik;
		this.koma = koma;
		this.mata = mata;
	}

	public char getTitik() {
		return titik;
	}

	public char getKoma() {
		return koma;
	}

	public String getMata() {
		return mata;
	}

	public static MataUang IDR = new MataUang('.', ',', "Rp");
	public static MataUang USD = new MataUang(',', '.', "$");
	public static MataUang RUB = new MataUang(',', '.', "\u20BD");
	public static MataUang AFN = new MataUang('.', ',', "\u060B");
	public static MataUang ZAR = new MataUang(',', '.', "R");
	public static MataUang XAF = new MataUang(',', '.', "Fr");
	public static MataUang EUR = new MataUang(',', '.', "\u20AC");
	public static MataUang ALL = new MataUang(',', '.', "L");
	public static MataUang GBP = new MataUang(',', '.', "\u00A3");
	public static MataUang GGP = new MataUang(',', '.', "\u00A3");
}
