## Java Resilience4j Notes

* Resilience4j merupakan fault tolerance library di Java yang meningkatkan kemudahan serta meminimalisir kesalahan dalam menggunakan functional interface pada lambda atau method reference.
* Time Limiter membutuhkan eksekusi dalam bentuk Future atau Comparable Future.
* Direkomendasikan menggunakan `Registry` pada setiap module di resilience4j.
* Circuit Braker digunakan untuk aplikasi dengan traffic tinggi atau integrasi dengan app lain.
* `Decorators` digunakan untuk menggabungkan module yang berbeda, kecuali Time Limiter.
* `getEventPublisher()` dapat digunakan pada semua module untuk menambahkan keterangan pada setiap event yg terjadi.

## Related Aricle
[Kenal Lebih Dekat dengan Library Resilience4j di Java](https://ichwansholihin.medium.com/kenal-lebih-dekat-dengan-library-resilience4j-di-java-261cb2ebc673)
