package uz.turgunboyevjurabek.firebaserealtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import uz.turgunboyevjurabek.firebaserealtimedatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        firebaseDatabase= FirebaseDatabase.getInstance()
        reference=firebaseDatabase.getReference("user")

        binding.btnSigning.setOnClickListener {
            reference.setValue("jurabek")
        }
    }
}