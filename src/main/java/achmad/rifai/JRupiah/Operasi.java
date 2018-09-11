package achmad.rifai.JRupiah;

import java.math.BigInteger;

public class Operasi {
	public static boolean isSama(Uang a, Uang b) throws UangException {
		if(a == null || b == null)
			throw new UangException("Mata Uang Tidak Boleh Kosong");
		if(a.getMata() != b.getMata())
			throw new UangException("Mata Uang Tidak Sama");
		return a.getNilai() == b.getNilai();
	}

	public static boolean isKurang(Uang a, Uang b) throws UangException {
		if(a == null || b == null)
			throw new UangException("Mata Uang Tidak Boleh Kosong");
		if(a.getMata() != b.getMata())
			throw new UangException("Mata Uang Tidak Sama");
		return a.getNilai().compareTo(b.getNilai()) == -1;
	}

	public static boolean isLebih(Uang a, Uang b) throws UangException {
		if(a == null || b == null)
			throw new UangException("Mata Uang Tidak Boleh Kosong");
		if(a.getMata() != b.getMata())
			throw new UangException("Mata Uang Tidak Sama");
		return 1 == a.getNilai().compareTo(b.getNilai());
	}

	public static Uang tambah(Uang a, Uang b) throws UangException {
		if(a == null || b == null)
			throw new UangException("Mata Uang Tidak Boleh Kosong");
		if(a.getMata() != b.getMata())
			throw new UangException("Mata Uang Tidak Sama");
		Uang c = new Uang(a.getNilai().add(b.getNilai()), a.getKoma(), 
				a.getTitik(), a.getMata());
		return c;
	}

	public static Uang kurang(Uang a, Uang b) throws UangException {
		if(a == null || b == null)
			throw new UangException("Mata Uang Tidak Boleh Kosong");
		if(a.getMata() != b.getMata())
			throw new UangException("Mata Uang Tidak Sama");
		Uang c = new Uang(a.getNilai().subtract(b.getNilai()), a.getKoma(), 
				a.getTitik(), a.getMata());
		return c;
	}

	public static Uang kali(Uang a, int x) throws UangException {
		if(a == null)
			throw new UangException("Mata Uang Tidak Boleh Kosong");
		Uang c = new Uang(a.getNilai().multiply(BigInteger.valueOf(x)), 
				a.getKoma(), a.getTitik(), a.getMata());
		return c;
	}

	public static Uang bagi(Uang a, int x) throws UangException {
		if(a == null)
			throw new UangException("Mata Uang Tidak Boleh Kosong");
		Uang c = new Uang(a.getNilai().divide(BigInteger.valueOf(x)), a.getKoma(), 
				a.getTitik(), a.getMata());
		return c;
	}
}
