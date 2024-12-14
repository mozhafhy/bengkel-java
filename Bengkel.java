import java.util.*;

public class Bengkel {
  static Scanner in = new Scanner(System.in);
  static double kapasitasWaktu;
  static double kapasitasBahan;
  static String output = "";
  static int[] kombinasiOptimal;
  static int indeksOutputOptimal = -1;

  public static void main(String[] args) {
    System.out.println("=== Program Optimisasi Produksi Bengkel ===");

    System.out.print("Masukkan kapasitas waktu kerja mesin (jam): ");
    kapasitasWaktu = inputDoublePositif();

    System.out.print("Masukkan kapasitas bahan baku (unit): ");
    kapasitasBahan = inputDoublePositif();

    System.out.print("Masukkan banyak jenis produk: ");
    int banyakJenis = inputIntPositif();

    Produk[] produkArray = new Produk[banyakJenis];
    for (int i = 0; i < banyakJenis; i++) {
      char id = (char) ('A' + i);

      System.out.printf("Masukkan waktu kerja untuk Produk %c  : ", id);
      double waktuKerja = inputDoublePositif();

      System.out.printf("Masukkan bahan baku untuk Produk %c   : ", id);
      double bahanBaku = inputDoublePositif();

      System.out.printf("Masukkan keuntungan per unit Produk %c: ", id);
      double keuntunganPerUnit = inputDoublePositif();

      produkArray[i] = new Produk(id, waktuKerja, bahanBaku, keuntunganPerUnit);
    }
    System.out.println();
    

    cariJumlahOptimal(produkArray);

    System.out.println("=== Hasil Optimisasi ===");
    System.out.println("Produksi optimal:");

    for (int i = 0; i < produkArray.length; i++) {
      System.out.printf("Produk %c = %d unit\n", produkArray[i].id, kombinasiOptimal[i]);
    }

    System.out.println("Keuntungan maksimal: Rp" + hitungKeuntungan(produkArray, kombinasiOptimal));
  }

  private static double inputDoublePositif() {
    while (true) {
      double input = in.nextDouble();

      if (input < 0) {
        System.out.print("Masukkan bilangan positif ");
      } else {
        return input;
      }
    }
  }

  private static int inputIntPositif() {
    while (true) {
      int input = in.nextInt();

      if (input < 0) {
        System.out.print("Masukkan bilangan positif ");
      } else {
        return input;
      }
    }
  }

  private static void cariJumlahOptimal(Produk[] produkArray) {
    int[] kombinasi = new int[produkArray.length];
    kombinasiOptimal = kombinasi.clone();
    tambahOutput(produkArray, kombinasi, true);
    cariJumlahOptimal(produkArray, kombinasi, 0);

    output = output.substring(0, indeksOutputOptimal) + " (optimal) "
        + output.substring(indeksOutputOptimal, output.length());
    System.out.println(output);
  }

  private static void tambahOutput(Produk[] produkArray, int[] jumlahUnitArray, boolean apakahOptimal) {
    output += "Kombinasi: ";
    for (int i = 0; i < produkArray.length; i++) {
      output += String.format("Produk %c = %d", produkArray[i].id, jumlahUnitArray[i]);
      output += (i == produkArray.length - 1 ? " -> " : ", ");
    }
    output += String.format("Waktu Mesin = %.2f, ", hitungWaktuTerpakai(produkArray, jumlahUnitArray));
    output += String.format("Bahan Baku = %.2f, ", hitungBahanTerpakai(produkArray, jumlahUnitArray));
    output += String.format("Keuntungan = Rp%.2f", hitungKeuntungan(produkArray, jumlahUnitArray));

    if (apakahOptimal) {
      indeksOutputOptimal = output.length();
    }

    output += "\n";
  }

  private static int[] cariJumlahOptimal(Produk[] produkArray, int[] kombinasi, int indeksProduk) {
    // cek boundary
    if (indeksProduk == produkArray.length)
      return kombinasi;

    // memecah data
    Produk produk = produkArray[indeksProduk];
    double waktuTerpakai = hitungWaktuTerpakai(produkArray, kombinasi);
    double bahanTerpakai = hitungBahanTerpakai(produkArray, kombinasi);

    // optimisasi
    while (true) {
      cariJumlahOptimal(produkArray, kombinasi.clone(), indeksProduk + 1);

      waktuTerpakai += produk.waktuKerja;
      bahanTerpakai += produk.bahanBaku;
      if (waktuTerpakai > kapasitasWaktu || bahanTerpakai > kapasitasBahan) {
        break;
      }

      kombinasi[indeksProduk]++;

      boolean apakahOptimal = hitungKeuntungan(produkArray, kombinasi) > hitungKeuntungan(produkArray,
          kombinasiOptimal);
    
      if (apakahOptimal) kombinasiOptimal = kombinasi.clone();
      tambahOutput(produkArray, kombinasi, apakahOptimal);
    }

    return kombinasi;
  }

  private static double hitungWaktuTerpakai(Produk[] produkArray, int[] jumlahUnitArray) {
    double waktuTerpakai = 0;
    for (int i = 0; i < produkArray.length; i++) {
      waktuTerpakai += produkArray[i].waktuKerja * jumlahUnitArray[i];
    }
    return waktuTerpakai;
  }

  private static double hitungBahanTerpakai(Produk[] produkArray, int[] jumlahUnitArray) {
    double bahanTerpakai = 0;
    for (int i = 0; i < produkArray.length; i++) {
      bahanTerpakai += produkArray[i].bahanBaku * jumlahUnitArray[i];
    }
    return bahanTerpakai;
  }

  private static double hitungKeuntungan(Produk[] produkArray, int[] jumlahUnitArray) {
    double totalKeuntungan = 0;
    for (int i = 0; i < produkArray.length; i++) {
      totalKeuntungan += produkArray[i].keuntunganPerUnit * jumlahUnitArray[i];
    }
    return totalKeuntungan;
  }
}