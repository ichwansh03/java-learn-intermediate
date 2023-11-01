## Java Sequence Collection Notes

* Sequence collection merupakan improvement version dari collection sebelumnya yang tidak memiliki operasi index di awal (`xxxFirst()`) maupun di akhir (`xxxLast()`) seperti deque (collection sebelumnya). [Proposal JEP 431](https://openjdk.org/jeps/431)
* Collection sequence memiliki interface tambahan seperti `SequenceCollection`, `SequenceSet` dan `SequenceMap`.
* Jika akan menggunakan `SequenceSet` atau `SequenceMap`, pahami bahwa data akan otomatis terurut walaupun kita tambahkan menggunakan operasi awal dan akhir pada elemen (kecuali `LinkedHashSet`/`LinkedHashMap`)