## Java JSON Notes

* `ObjectMapper` cukup dibuat sekali saja (constant field) karena sudah thread safe.
* Gunakan `Map<K, V>` untuk membuat JSON object, jika JSON Array gunakan Collection atau `List<V>`.
* List fitur yang ada di mapper. [Mapper Feature](https://github.com/FasterXML/jackson-databind/wiki/Mapper-Features).

## Related Article
[Mengenal Library Jackson untuk Parsing JSON di Java](https://ichwansholihin.medium.com/mengenal-library-jackson-untuk-parsing-json-di-java-17cbc1749785)
