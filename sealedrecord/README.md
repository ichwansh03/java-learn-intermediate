## Java Record and Sealed Class

* Record class bersifat immutable, artinya data bersifat final dan tidak dapat diubah. Record akan otomatis men-generate method equals, toString dan hashcode.
* Canonical Constructor adalah kemampuan membuat constructor custom di class record dan value dari properties nya dapat diubah/diinisialisasi langsung.
* Di class record juga bisa buat method seperti class pada biasanya