/*
 * Program untuk mencari kombinasi jumlah unit n produk yang optimal
 * (menghasilkan total keuntungan terbesar tanpa melebihi kapasitas) menggunakan rekursif.
 * Bonus: Validasi input untuk mencegah komputasi dengan bilangan negatif
 * Bonus: Input produk tambahan (optimisasi lebih dari 2 produk sekaligus)
 */

import java.util.*;

public class Bengkel {
  static Scanner in = new Scanner(System.in);

  // kapasitas
  static double kapasitasWaktu;
  static double kapasitasBahan;

  // output dari pencarian kombinasi optimal
  static String output = "";

  // akhir baris dari baris hasil kombinasi optimal pada output
  static int indeksOutputOptimal = -1;

  // hasil optimisasi
  static int[] kombinasiOptimal;

  static Produk[] produkArray;

  public static void main(String[] args) {
    System.out.println("=== Program Optimisasi Produksi Bengkel ===");

    System.out.print("Masukkan kapasitas waktu kerja mesin (jam): ");
    kapasitasWaktu = inputDoublePositif();

    System.out.print("Masukkan kapasitas bahan baku (unit): ");
    kapasitasBahan = inputDoublePositif();

    System.out.print("Masukkan banyak jenis produk: ");
    int banyakJenis = inputIntPositif();

    produkArray = new Produk[banyakJenis];
    for (int i = 0; i < banyakJenis; i++) {
      // ambil data setiap produk

      char id = (char) ('A' + i);

      System.out.printf("Masukkan waktu kerja untuk Produk %c  : ", id);
      double waktuKerja = inputDoublePositif();

      System.out.printf("Masukkan bahan baku untuk Produk %c   : ", id);
      double bahanBaku = inputDoublePositif();

      System.out.printf("Masukkan keuntungan per unit Produk %c: ", id);
      double keuntunganPerUnit = inputDoublePositif();

      produkArray[i] = new Produk(id, waktuKerja, bahanBaku, keuntunganPerUnit);
    }

    System.out.println(); /* turun 1 baris */

    cariKombinasiOptimal();

    System.out.println("=== Hasil Optimisasi ===");
    System.out.println("Produksi optimal:");

    for (int i = 0; i < produkArray.length; i++) {
      System.out.printf("Produk %c = %d unit\n", produkArray[i].id, kombinasiOptimal[i]);
    }

    System.out.println("Keuntungan maksimal: Rp" + hitungKeuntungan(kombinasiOptimal));
  }

  /**
   * terus minta input hingga user memasukkan angka positif
   * 
   * @return double bernilai positif dari input user
   */
  private static double inputDoublePositif() {
    while (true) {
      double input = in.nextDouble();

      // validasi
      if (input < 0) {
        System.out.print("(masukkan bilangan positif) : ");
      } else {
        return input;
      }
    }
  }

  /**
   * terus minta input hingga user memasukkan angka positif
   * 
   * @return double bernilai positif dari input user
   */
  private static int inputIntPositif() {
    while (true) {
      int input = in.nextInt();

      // validasi
      if (input < 0) {
        System.out.print("(masukkan bilangan positif) : ");
      } else {
        return input;
      }
    }
  }

  /**
   * mengubah variabel kombinasiOptimal menjadi kombinasi unit yang optimal
   * (menghasilkan total keuntungan terbesar tanpa melebihi kapasitas)
   */
  private static void cariKombinasiOptimal() {
    int[] kombinasi = new int[produkArray.length];
    kombinasiOptimal = kombinasi.clone();
    tambahOutput(kombinasi, true);
    cariKombinasiOptimal(kombinasi, 0);

    output = output.substring(0, indeksOutputOptimal) + " (optimal) "
        + output.substring(indeksOutputOptimal, output.length());
    System.out.println(output);
  }

  /**
   * mengubah variabel kombinasiOptimal menjadi kombinasi unit yang optimal
   * (menghasilkan total keuntungan terbesar tanpa melebihi kapasitas)
   */
  private static void tambahOutput(int[] jumlahUnitArray, boolean apakahOptimal) {
    output += "Kombinasi: ";
    for (int i = 0; i < produkArray.length; i++) {
      output += String.format("Produk %c = %d", produkArray[i].id, jumlahUnitArray[i]);
      output += (i == produkArray.length - 1 ? " -> " : ", ");
    }
    output += String.format("Waktu Mesin = %.2f, ", hitungWaktuTerpakai(jumlahUnitArray));
    output += String.format("Bahan Baku = %.2f, ", hitungBahanTerpakai(jumlahUnitArray));
    output += String.format("Keuntungan = Rp%.2f", hitungKeuntungan(jumlahUnitArray));

    if (apakahOptimal) {
      // simpan indeks dari akhir kalimat produk optimal
      indeksOutputOptimal = output.length();
    }

    output += "\n";
  }

  /**
   * mencari kombinasi (menghasilkan total keuntungan terbesar tanpa melebihi
   * kapasitas) jumlah untit optimal dengan cara rekursif mulai dari produk
   * ke-indeksProduk produk terakhir pada produkArray
   * 
   * @param kombinasi    kombinasi jumlah unit setiap produk pada produkArray
   * @param indeksProduk indeks paling kiri untuk produk yang ingin dioptimisasi
   */
  private static void cariKombinasiOptimal(int[] kombinasi, int indeksProduk) {
    // cek boundary
    if (indeksProduk == produkArray.length)
      return;

    Produk produk = produkArray[indeksProduk];

    double waktuTerpakai = hitungWaktuTerpakai(kombinasi);
    double bahanTerpakai = hitungBahanTerpakai(kombinasi);

    // optimisasi
    while (true) {
      // optimisasi produk berikutnya
      cariKombinasiOptimal(kombinasi.clone(), indeksProduk + 1);

      // naikkan jumlah unit untuk produk saat ini
      waktuTerpakai += produk.waktuKerja;
      bahanTerpakai += produk.bahanBaku;
      if (waktuTerpakai > kapasitasWaktu || bahanTerpakai > kapasitasBahan) {
        break;
      }

      kombinasi[indeksProduk]++;

      boolean apakahOptimal = hitungKeuntungan(kombinasi) > hitungKeuntungan(kombinasiOptimal);

      if (apakahOptimal)
        kombinasiOptimal = kombinasi.clone();

      tambahOutput(kombinasi, apakahOptimal);
    }
  }

  /**
   * hitung total waktu terpakai dari kombinasi jumlah unit produk
   * 
   * @param kombinasi kombinasi jumlah unit setiap produk pada produkArray
   * @return
   */
  private static double hitungWaktuTerpakai(int[] kombinasi) {
    double waktuTerpakai = 0;
    for (int i = 0; i < produkArray.length; i++) {
      waktuTerpakai += produkArray[i].waktuKerja * kombinasi[i];
    }
    return waktuTerpakai;
  }

  /**
   * hitung total bahan terpakai dari kombinasi jumlah unit produk
   * 
   * @param kombinasi kombinasi jumlah unit setiap produk pada produkArray
   * @return
   */
  private static double hitungBahanTerpakai(int[] kombinasi) {
    double bahanTerpakai = 0;
    for (int i = 0; i < produkArray.length; i++) {
      bahanTerpakai += produkArray[i].bahanBaku * kombinasi[i];
    }
    return bahanTerpakai;
  }

  /**
   * hitung total keuntungan dari kombinasi jumlah unit produk
   * 
   * @param kombinasi kombinasi jumlah unit setiap produk pada produkArray
   * @return
   */
  private static double hitungKeuntungan(int[] kombinasi) {
    double totalKeuntungan = 0;
    for (int i = 0; i < produkArray.length; i++) {
      totalKeuntungan += produkArray[i].keuntunganPerUnit * kombinasi[i];
    }
    return totalKeuntungan;
  }
}