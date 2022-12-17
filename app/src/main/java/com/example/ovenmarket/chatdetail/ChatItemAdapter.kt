package com.example.ovenmarket.chatdetail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ovenmarket.databinding.ItemChatBinding
import com.example.ovenmarket.model.ChatItem

class ChatItemAdapter : ListAdapter<ChatItem, ChatItemAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemChatBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(chatItem: ChatItem) {
            binding.messageTextView.text = chatItem.message
            binding.senderTextView.text = chatItem.senderId
            binding.messageItemTextViewTime.text = chatItem.time

            if (chatItem.profileImageUrl.isNotEmpty()) {
                Glide.with(binding.messageItemImageviewProfile)
                    .load(chatItem.profileImageUrl)
                    .into(binding.messageItemImageviewProfile)
            }
            Log.d("ChatItemAdapter", "${chatItem.message}, ${chatItem.senderId}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
        Log.d("ChatItemAdapter", "current Item = ${currentList[position].message}, ${currentList[position].senderId}")

    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ChatItem>() {
            override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}