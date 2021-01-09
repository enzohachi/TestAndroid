package cl.enzo86.novaera2.ui

import androidx.recyclerview.widget.RecyclerView
import cl.enzo86.novaera2.databinding.ItemTelefonosBinding
import cl.enzo86.novaera2.domain.model.Telefono
import com.squareup.picasso.Picasso

class TelefonoViewHolder(
    private val binding: ItemTelefonosBinding,
    private val onItemClickCopete: TelefonosFragment
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(telefono: Telefono) {
        binding.apply {
            tvNombreTelefono.text = telefono.nombre
            Picasso.get().load(telefono.imagen).into(ivIconoTelefono)
            tvPrecio.text = telefono.precio.toString()
        }
        onItemClickCopete.onItemCLickProducto(telefono)
    }
}
