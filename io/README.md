## Java IO Notes

* Sangat disarankan menggunakan `InputStream` dan `OutputStream` pada kasus data non text seperti gambar, video dan lain-lain. Jika data text, lebih disarankan menggunakan `Reader` dan `Writer`.
* Hampir semua class di Java Collection merupakan turunan dari interface Serializable, jadi dapat juga menggunakan Object Stream untuk menyimpan data collection