package me.aksenov.likeolike

import me.aksenov.likeolike.bot.Bot
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import javax.annotation.PostConstruct


@SpringBootApplication
class App

fun main(args: Array<String>) {
    runApplication<App>(*args)
}

@PostConstruct
fun start(bot: Bot) {
    val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
    try {
        telegramBotsApi.registerBot(bot)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
