public class LogList {
  Log head;
  Log tail;
  int panjang = 0;

  int addLog(int[] jumlahUnitArray, double waktuTerpakai, double bahanTerpakai, double keuntungan) {
    Log log = new Log();
    log.jumlahUnitArray = jumlahUnitArray;
    log.bahanTerpakai = bahanTerpakai;
    log.keuntungan = keuntungan;
    log.waktuTerpakai = waktuTerpakai;
    log.indeks = panjang;

    panjang++;

    if (head == null) {
      head = log;
    } else {
      tail = log;
    }

    return log.indeks;
  }
}
