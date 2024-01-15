## Java Record and Sealed Class

* Record class bersifat immutable, artinya data bersifat final dan tidak dapat diubah. Record akan otomatis men-generate method equals, toString dan hashcode.
* Canonical Constructor adalah kemampuan membuat constructor custom di class record dan value dari properties nya dapat diubah/diinisialisasi langsung.
* Di class record juga bisa buat method seperti class pada biasanya
* Record dapat meng-implement interface, namun tidak dapat meng-extends class lain
* Record juga mendukung generic type
* Sealed class/interface adalah mekanisme sebuah class/interface hanya dapat diturunkan oleh object yg telah ditentukan mana saja class/interface yg hanya boleh di-extend atau di-implement.
* Gunakan keyword `permit` pada class parent. Class turunan dari sealed class harus final. Namun jika child class ingin di extend lagi ke class lain, ganti keyword `final` menjadi `non-sealed`
* Sealed type juga dapat digunakan di interface