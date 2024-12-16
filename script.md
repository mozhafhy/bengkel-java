Assalamualaikum wr. wb. perkenalkan kami dari Kelompok 1
1. Saya Abiyyu NIM 24515020
2. Saya Dewa Nyoman NIM 24515020
3. Saya Farid NIM 24515020
4. Saya Fazle NIM 24515020
5. Saya Zhafif NIM 24515020

### Overview (Farid)
Pada kesempatan kali ini, kami akan menjelaskan solusi untuk studi kasus optimisasi produksi di sebuah bengkel sederhana Bengkel ini, pada dasarnya, memproduksi 2 jenis produk: Produk A dan Produk B dengan keterbatasan, yaitu total waktu kerja maks mesin: 100 dan total bahan baku maks yang tersedia: 50. Produk A membutuhkan 10 jam waktu kerja, 5 unit bahan baku, menghasilkan keuntungan Rp5000 per unit. Peoduk B membutuhkan 15 jam waktu kerja, 3 unit bahan baku, dan menghasilkan keuntungan Rp7000 per unit.  
  
Program ini akan membantu bengkel menentukan kombinasi produk sehingga menghasilkan total keuntungan yang optimal.

**RUN KODE BROK**  
Di sini saya akan menjalankan program yang telah dibuat untuk menyelesaikan skenario tersebut. Di sini kapasitas waktu kerja mesin saya set = 100, kapasitas bahan baku = 50, banyak produk = 2, waktu kerja Produk A = 10, bahan baku Produk A = 5, keuntungan per unit Produk A = 5000; waktu kerja produk B = 15, bahan baku Produk B = 3, dan keuntungan per unit Produk B = 7000.  

**BACA OUTPUT ANJING**
Setelah semua informasi dimasukkan, program akan menampilkan log kombinasi yang telah dicoba (proses pencarian) dan hasil dari pencarian kombinasi yang memberikan keuntungan optimal. Program akan menampilkan 1 baris log untuk kombinasi valid yang telah dicoba dan pada pencarian yang memberikan kombinasi optimal akan diberikan tulisan "(optimal)" di akhir kalimat baris log tersebut. Terakhir, program akan menampilkan jumlah unit masing-masing produk yang harus diproduksi untuk mendapat keuntungan maksimal dan juga keuntungan yang didapat dari kombinasi optimal tersebut

#### GANTI INYO BJIR
Program kami juga mengimplementasikan poin bonus, validasi input user agara program hanya menerima input positif.

**RUN KODE BROK**  
Sekarang saya akan coba masukkan -100 untuk kapasitas waktu kerja mesin maka program akan meminta user untuk memasukkan ulang angka hingga user memberi oinput berupa bilangan positif. Sehingga jika sekarang saya berikan input seperti sebelumnya..... dan saya run. Hasil optimisasi yang sama tetap akan didapatkan.  

**RUN KODE BROK**  
Program kami juga mengimplementasikan poin bonus, fitur untuk memasukkan data untuk produk tambahan. Sehingga jika disini kapasitas waktu kerja mesin saya set = 100, kapasitas bahan baku = 50, naum banyak produk = 3.... lalu waktu kerja Produk A = 10, bahan baku Produk A = 5, keuntungan per unit Produk A = 5000; waktu kerja produk B = 15, bahan baku Produk B = 3, dan keuntungan per unit Produk B = 7000. Program akan meminta produk ketig, produk C, untuk dipertimbangkan. waktu kerja Produk C = 10, bahan baku Produk C = 7, keuntungan per unit Produk A = 6000. Program akan memberi output tanpa masalah seperti berikut.

## Penjelasan Algoritma dan Method  
### Validasi Input (Abiyyu + Inyo)  

pada program, user diminta untuk memasukkan kapasitas waktu kerja mesin dalam satuan jam. Kemudian akan dilakukan pemanggilan method inputDoublePositif, di dalam method user dapat memasukkan nilai kapasitas waktu kerja dan kemudian akan di validasi, apabila < 0 maka program akan meminta user untuk memasukkan nilai yang bernilai positif. nilai dari input akan tersimpan pada variabel kapasitasWaktu

setelah itu, pada program, user diminta untuk memasukkan kapasitas bahan baku dalam satuan unit. Kemudian akan dilakukan pemanggilan method inputDoublePositif, di dalam method user dapat memasukkan nilai kapasitas bahan baku dan kemudian akan di validasi, apabila < 0 maka program akan meminta user untuk memasukkan nilai yang bernilai positif. nilai dari input akan tersimpan pada variabel kapasitasBahan

kemudian, pada program user diminta untuk memasukkan banyak jenis produk, kemudian akan dilakukan pemangginlan method inputIntPositif, di dalam method program akan menerima input dari user dan mengecek apakah input < 0, bila < 0 maka program akan meminta user untuk input bilangan positif. nilai dari input akan tersimpan pada variabel banyakJenis. 

input user yang terimpan pada variabel banyakJenis akan menjadi tumpuan berapa banyak jenis barang. hal tersebut kami implementasikan dengan membuat array yang memuat panjang dari input user yang telah tersimpan di variabel banyakJenis.

kemudian akan dilakukan penginputan waktu kerja, bahan baku dan keuntungan dari tiap tiap jenis produk. hal tersebut kami implementasikan dengan menggunakan for loop, yang dimana perulangan dimulai dari 0 hingga < banyakJenis yang merupakan input dari user yang berisi banyak jenis produk.

untuk penamaan id, kami mulai dari A dan produk setelahnya kami +1 sehingga tiap perulangan akan bertamnbah menjasi C D E dll. 

setelah pemberian id, program meminta user untuk menginputkan waktu kerja, yang dimana input dari user akan disimpan di variabel waktuKerja, dan dilakukan pemnaggilan method inputDouble yang berfungsi untuk input dan validasi, apabila < 0 maka program akan meminta user untuk input hinga positif.

kemudian program meminta user untuk menginputkan bahan baku produk yang dimana input dari user akan disimpan di variabel bahanBaku, dan dilakukan pemanggilan method inputDouble yang berfungsi untuk input dan validasi, apabila input < 0 maka program akan meminta user untuk input hinga positif.

kemudian program meminta user untuk menginputkan keuntungan per unit produk yang dimana input dari user akan disimpan di variabel keuntunganPerUnit, dan dilakukan pemanggilan method inputDouble yang berfungsi untuk input dan validasi, apabila input < 0 maka program akan meminta user untuk input hinga positif.

sehingga setelah user input semua nilai yang dibutuhkan maka array dengan variabel produkArray akan terisi dengan nilai nilai sesuai dengan input dari user baik id, waktu kerja, bahan baku dan juga keuntungan per unit.
### Proses Optimisasi (Zhafif)  


### Output (Fazle)  


Sekian presentasi dari kelompok kami, wassalamualaikum wr. wb.