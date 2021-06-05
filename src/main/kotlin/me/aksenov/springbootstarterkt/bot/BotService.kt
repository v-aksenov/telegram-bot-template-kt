package me.aksenov.springbootstarterkt.bot

import com.elbekD.bot.Bot
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class BotService(
    @Value("bot.token") private val token: String,
    @Value("bot.username") private val username: String
) {

    @PostConstruct
    fun start() {
        val bot = Bot.createPolling(username, token) {
            // below is optional parameters
            // limit = 50
            // timeout = 30
            // allowedUpdates = listOf(AllowedUpdate.Message)
            // removeWebhookAutomatically = true
            // period = 1000
        }

        bot.onCommand("/start") { msg, _ ->
            bot.sendMessage(msg.chat.id, "Like you!")
        }

        bot.start()
    }
}