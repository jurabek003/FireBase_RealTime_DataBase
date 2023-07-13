package uz.turgunboyevjurabek.firebaserealtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import uz.turgunboyevjurabek.firebaserealtimedatabase.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.firebaserealtimedatabase.madels.MyMessage

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    private lateinit var rvAdabter: RvAdabter
    private lateinit var list: ArrayList<MyMessage>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        firebaseDatabase= FirebaseDatabase.getInstance()
        reference=firebaseDatabase.getReference("user")
        rvAdabter= RvAdabter()
        binding.rvMessage.adapter=rvAdabter

        binding.btnSend.setOnClickListener {
            val id=reference.push().key
            Toast.makeText(this, "$id", Toast.LENGTH_SHORT).show()
            val message=MyMessage(id, binding.edtMessage.text.toString())
            reference.child(id!!).setValue(message)
            Toast.makeText(this, "Send message", Toast.LENGTH_SHORT).show()
            binding.edtMessage.text.clear()
        }

        reference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val children=snapshot.children
                list= ArrayList()
                for (child in children){
                    var value=child.getValue(MyMessage::class.java)
                    if (value!=null){
                        list.add(value)
                    }
                }
                rvAdabter.list.clear()
                rvAdabter.list.addAll(list)
                rvAdabter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Vay shkal", Toast.LENGTH_SHORT).show()
            }
        })
    }
}