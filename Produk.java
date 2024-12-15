/**
 * kelas untuk menyimpan data produk
 * id, waktuKerja, bahanBaku, dan keuntunganPerUnit
 */
public class Produk {
  char id;
  double waktuKerja;
  double bahanBaku;
  double keuntunganPerUnit;

  Produk(char id, double waktuKerja, double bahanBaku, double keuntunganPerUnit) {
    this.id = id;
    this.waktuKerja = waktuKerja;
    this.bahanBaku = bahanBaku;
    this.keuntunganPerUnit = keuntunganPerUnit;
  }
}
