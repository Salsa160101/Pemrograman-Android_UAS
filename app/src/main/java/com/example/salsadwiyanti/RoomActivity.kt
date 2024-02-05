package com.example.salsadwiyanti

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.RemoteViews.RemoteCollectionItems
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.salsadwiyanti.databinding.ActivityMainBinding
import com.example.salsadwiyanti.db.NoteRoomDatabase
import com.example.salsadwiyanti.model.Note
import com.example.salsadwiyanti.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRoomBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Cek apakah data sudah dimasukkan sebelumnya
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val isDataInserted = sharedPreferences.getBoolean("isDataInserted", false)

        if (!isDataInserted) {
            // Jika belum dimasukkan, maka masukkan data dan simpan status ke shared preferences
            addDummyData()
            sharedPreferences.edit().putBoolean("isDataInserted", true).apply()
        }

        // Menampilkan data dari database ke dalam RecyclerView
        getNotesDate()

        binding.floatingAdd.setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
    }

    private fun addDummyData() {
        val database = NoteRoomDatabase.getDatabase(application)
        val dao = database.getNoteDao()

        // Membuat 50 data dan memasukkannya ke dalam database
        // Data dummy
        val dummyDataList = listOf(
            Note(
                npm = "2169700028",
                nama = "Firman Tegar",
                nilai = "93",
                keterangan = "LULUS",
                jumlahsks = "24",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700012",
                nama = "Ratu Nurul Fauziah",
                nilai = "91",
                keterangan = "LULUS",
                jumlahsks = "25",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700018",
                nama = "Meli Ai Hayati Rahmah",
                nilai = "90",
                keterangan = "LULUS",
                jumlahsks = "24",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700024",
                nama = "Harys Hakim Kurniawan",
                nilai = "89",
                keterangan = "LULUS",
                jumlahsks = "23",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700022",
                nama = "Toibul Khoiri",
                nilai = "87",
                keterangan = "LULUS",
                jumlahsks = "21",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700044",
                nama = "Dwiki Wisnu Aji",
                nilai = "86",
                keterangan = "LULUS",
                jumlahsks = "25",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700042",
                nama = "Wita Dwiyanti",
                nilai = "73",
                keterangan = "LULUS",
                jumlahsks = "22",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700041",
                nama = "Ilham Rizky Ramadhan",
                nilai = "85",
                keterangan = "LULUS",
                jumlahsks = "26",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700039",
                nama = "Ersa Putra Riano",
                nilai = "82",
                keterangan = "LULUS",
                jumlahsks = "24",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700038",
                nama = "Kosmara",
                nilai = "75",
                keterangan = "LULUS",
                jumlahsks = "19",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700037",
                nama = "Siti Muslihah",
                nilai = "83",
                keterangan = "LULUS",
                jumlahsks = "21",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700036",
                nama = "Lina Faujiah",
                nilai = "75",
                keterangan = "LULUS",
                jumlahsks = "18",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700035",
                nama = "Yusuf Ardiansyah",
                nilai = "50",
                keterangan = "Tidak Lulus",
                jumlahsks = "25",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700030",
                nama = "Lulu Fauziyah",
                nilai = "81",
                keterangan = "LULUS",
                jumlahsks = "25",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700029",
                nama = "Chandra Yulistianto",
                nilai = "79",
                keterangan = "LULUS",
                jumlahsks = "21",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700008",
                nama = "Lukman Muhamad Syamil",
                nilai = "82",
                keterangan = "LULUS",
                jumlahsks = "26",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700013",
                nama = "Anna Silvana",
                nilai = "78",
                keterangan = "LULUS",
                jumlahsks = "20",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700014",
                nama = "Adi Suharyadi",
                nilai = "63",
                keterangan = "TIDAK LULUS",
                jumlahsks = "21",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700015",
                nama = "Dani Ramadon",
                nilai = "60",
                keterangan = "TIDAK LULUS",
                jumlahsks = "24",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700019",
                nama = "Duta Rizky Darmawan",
                nilai = "82",
                keterangan = "LULUS",
                jumlahsks = "23",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700020",
                nama = "Wahyu Hidayat",
                nilai = "65",
                keterangan = "TIDAK LULUS",
                jumlahsks = "22",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700021",
                nama = "Riska Yulinar",
                nilai = "75",
                keterangan = "LULUS",
                jumlahsks = "18",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700025",
                nama = "Gilang Pramudya Asega",
                nilai = "72",
                keterangan = "LULUS",
                jumlahsks = "23",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700027",
                nama = "Tapan Nurzaman Malik",
                nilai = "73",
                keterangan = "LULUS",
                jumlahsks = "17",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700001",
                nama = "Salsa Dwiyanti",
                nilai = "84",
                keterangan = "LULUS",
                jumlahsks = "19",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700004",
                nama = "Yeni Nuraeni",
                nilai = "77",
                keterangan = "LULUS",
                jumlahsks = "20",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700005",
                nama = "Tiara Agustin",
                nilai = "75",
                keterangan = "LULUS",
                jumlahsks = "22",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700006",
                nama = "Listiani Lesveva Setiawan",
                nilai = "80",
                keterangan = "LULUS",
                jumlahsks = "18",
                hargasks = "15000"
            ),
            Note(
                npm = "2169700007",
                nama = "Sendi Rahman Huda",
                nilai = "80",
                keterangan = "LULUS",
                jumlahsks = "21",
                hargasks = "15000"
            ),
            Note(
                npm = "2069700002",
                nama = "Tomi Riki Saputra",
                nilai = "85",
                keterangan = "LULUS",
                jumlahsks = "24",
                hargasks = "15000"
            ),
        )

        // Menambahkan data ke dalam database
        for (dummyNote in dummyDataList) {
            dao.insert(dummyNote)
        }
    }


    private fun getNotesDate() {
        val database = NoteRoomDatabase.getDatabase(application)
        val dao = database.getNoteDao()
        val listItems = arrayListOf<Note>()
        listItems.addAll(dao.getAll())
        setupRecyclerView(listItems)
    }

    private fun setupRecyclerView(listItems: ArrayList<Note>) {
        binding.recycleViewMain.apply {
            adapter = NoteAdapter(listItems, object : NoteAdapter.NoteListener {
                override fun OnItemClicked(note: Note) {
                    val intent = Intent(this@RoomActivity, EditActivity::class.java)
                    intent.putExtra(EditActivity().EDIT_NOTE_EXTRA, note)
                    startActivity(intent)
                }
            })

            layoutManager = LinearLayoutManager(this@RoomActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        getNotesDate()
    }
}