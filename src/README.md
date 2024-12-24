# README.md for Pocket Blue Application

## Deskripsi Aplikasi
Pocket Blue adalah aplikasi berbasis Java yang dirancang untuk membantu pengguna dalam mengelola keuangan pribadi. Aplikasi ini memungkinkan pengguna untuk mencatat pemasukan dan pengeluaran secara mudah dan efisien. Dengan tampilan antarmuka grafis yang sederhana dan user-friendly, Pocket Blue memberikan pengalaman yang menyenangkan bagi pengguna yang ingin mencatat dan melacak transaksi keuangan mereka.

Aplikasi ini dibangun menggunakan Swing, sebuah library Java untuk pembuatan antarmuka grafis (GUI), yang memungkinkan aplikasi memiliki tampilan yang menarik dan interaktif. Pengguna dapat login dengan kredensial tertentu, kemudian memasukkan dan melihat catatan pemasukan dan pengeluaran mereka.

## Fitur Aplikasi
1. *Login System*
    - Pengguna harus login menggunakan username dan password yang valid untuk mengakses aplikasi.
    - Username dan password default adalah admin dan password.

2. *Menu Utama*
    - Setelah login berhasil, pengguna akan diarahkan ke menu utama dengan dua pilihan utama:
        - *Catatan Pemasukan*: Untuk mencatat pemasukan yang diterima.
        - *Catatan Pengeluaran*: Untuk mencatat pengeluaran yang dilakukan.

3. *Catatan Pemasukan*
    - Pengguna dapat menambahkan catatan pemasukan dengan memasukkan rincian dan jumlah nominal pemasukan.
    - Semua transaksi pemasukan yang dimasukkan akan ditampilkan dalam daftar yang dapat digulir.

4. *Catatan Pengeluaran*
    - Pengguna dapat menambahkan catatan pengeluaran dengan memasukkan rincian dan jumlah nominal pengeluaran.
    - Semua transaksi pengeluaran yang dimasukkan akan ditampilkan dalam daftar yang dapat digulir.

5. *Validasi Input*
    - Aplikasi memastikan bahwa input nominal yang dimasukkan adalah angka yang valid. Jika input tidak valid, pengguna akan diberi peringatan.

6. *Tampilan Antarmuka*
    - Aplikasi menggunakan desain berbasis panel dengan tombol, input teks, dan daftar untuk mempermudah navigasi dan interaksi.
    - Setiap fitur (pemasukan dan pengeluaran) memiliki halaman terpisah untuk input data dan menampilkan daftar transaksi.

7. *Tombol Navigasi*
    - Tombol "Simpan" untuk menyimpan data yang dimasukkan.
    - Tombol "Tambahkan" untuk menambahkan transaksi ke daftar.
    - Tombol "Keluar" untuk keluar dari halaman dan kembali ke menu utama atau menutup aplikasi.