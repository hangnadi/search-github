package com.hang.search.view.recyclerview

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.hang.search.R
import com.hang.search.base.AbstractViewHolder
import com.hang.search.data.UserData
import kotlinx.android.synthetic.main.recyclerview_item_user.view.*

class UserViewHolder (itemView: View) : AbstractViewHolder<UserData>(itemView) {

    companion object {
        const val LAYOUT = R.layout.recyclerview_item_user
    }

    override fun bind(model: UserData) {
        itemView.username.text = model.login
        Glide.with(itemView.context)
            .asBitmap()
            .load(model.avatarUrl)
            .dontAnimate()
            .into(itemView.profile)
    }
}
