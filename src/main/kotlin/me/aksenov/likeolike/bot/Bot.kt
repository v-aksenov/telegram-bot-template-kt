package me.aksenov.likeolike.bot

import me.aksenov.likeolike.Logger
import me.aksenov.likeolike.utils.hasLike
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import javax.annotation.PostConstruct

@Service
class Bot(
    @Value("\${bot.token}") private val token: String,
    @Value("\${bot.username}") private val username: String
) : TelegramLongPollingBot(), Logger {

    override fun onUpdateReceived(update: Update) {
        log.info(update.toString())
        Character.toChars(0x2764).toString()
        if (update.message.hasLike()) sendLikeMessage(update.message.chatId.toString())
        if (update.message.isChannelMessage) log.info("channelMessage")
    }

    private fun sendLikeMessage(chatId: String) {
        sendApiMethod(SendMessage(chatId, "Like you!"))
    }

    override fun getBotUsername(): String = username

    override fun getBotToken(): String = token

    @PostConstruct
    fun startup() {
        TelegramBotsApi(DefaultBotSession::class.java).registerBot(this)
        log.info("like-o-like started")
    }
}