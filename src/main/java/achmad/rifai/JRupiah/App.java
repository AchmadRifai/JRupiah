package achmad.rifai.JRupiah;

import java.math.BigInteger;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws UangException {
        Uang u = new Uang(new BigInteger("1000000"), MataUang.IDR);
        BigInteger b = u.getNilai();
        System.out.println(u);
        System.out.println(b);
        System.out.println(u.getKoma());
        System.out.println(u.getTitik());
        System.out.println(u.getMata());
    }
}
