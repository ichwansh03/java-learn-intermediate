## Java JSON Notes

* `ObjectMapper` cukup dibuat sekali saja (constant field) karena sudah thread safe.
* Gunakan `Map<K, V>` untuk membuat JSON object, jika JSON Array gunakan Collection atau `List<V>`.
* List fitur yang ada di mapper. ![Mapper Feature](https://github.com/FasterXML/jackson-databind/wiki/Mapper-Features).
* 