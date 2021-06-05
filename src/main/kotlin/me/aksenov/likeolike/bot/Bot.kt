package me.aksenov.likeolike.bot

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

@Service
class Bot(
    @Value("bot.token") private val token: String,
    @Value("bot.username") private val username: String
) : TelegramLongPollingBot() {

    override fun onUpdateReceived(update: Update) {
        TODO("Not yet implemented")
    }

    override fun getBotUsername(): String = username

    override fun getBotToken(): String = token
}