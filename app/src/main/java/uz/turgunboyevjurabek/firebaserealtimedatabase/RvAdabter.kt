package uz.turgunboyevjurabek.firebaserealtimedatabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.turgunboyevjurabek.firebaserealtimedatabase.databinding.ItemRvBinding
import uz.turgunboyevjurabek.firebaserealtimedatabase.madels.MyMessage

class RvAdabter(val  list: ArrayList<MyMessage> = ArrayList()):RecyclerView.Adapter<RvAdabter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding):ViewHolder(itemRvBinding.root){
        fun onBind(message: MyMessage){
            itemRvBinding.thtMassage.text=message.title.toString()
            itemRvBinding.thtTime.text=message.time.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}