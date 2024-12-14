public class Log {
  int[] jumlahUnitArray;
  int indeks;
  double waktuTerpakai;
  double bahanTerpakai;
  double keuntungan;
  Log next;

  void printDetailJumlahUnit(Produk[] produkArray, int[] jumlahUnitArray) {
    System.out.print("Kombinasi: ");
    for (int i = 0; i < produkArray.length; i++) {
      System.out.printf("Produk %c = %d", produkArray[i].id, jumlahUnitArray[i]);
      System.out.print(i == produkArray.length - 1 ? " -> " : ", ");
    }
    System.out.printf("Waktu Mesin = %.2f, ", this.waktuTerpakai);
    System.out.printf("Bahan Baku = %.2f, ", this.bahanTerpakai);
    System.out.printf("Keuntungan = Rp%.2f\n", this.keuntungan);
  }
}
