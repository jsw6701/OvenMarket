package com.example.ovenmarket.chatlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ovenmarket.databinding.ItemChatListBinding
import com.example.ovenmarket.model.ChatListItem

class ChatListAdapter(val onItemClicked: (ChatListItem) -> Unit) : ListAdapter<ChatListItem, ChatListAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemChatListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(chatListItem: ChatListItem) {
            binding.root.setOnClickListener {
                onItemClicked(chatListItem)
            }

            binding.chatRoomTitleTextView.text = chatListItem.itemTitle

            if (chatListItem.profileImageUrl.isNotEmpty()) {
                Glide.with(binding.articleView)
                    .load(chatListItem.profileImageUrl)
                    .into(binding.articleView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemChatListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<ChatListItem>() {
            override fun areItemsTheSame(oldItem: ChatListItem, newItem: ChatListItem): Boolean {
                return oldItem.key == newItem.key
            }

            override fun areContentsTheSame(oldItem: ChatListItem, newItem: ChatListItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}