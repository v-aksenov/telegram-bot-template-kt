package me.aksenov.likeolike.utils

import org.telegram.telegrambots.meta.api.objects.Message

fun Message?.hasLike(): Boolean = this?.sticker?.emoji == likeSymbol || this?.text == likeSymbol

private val likeSymbol = String(Character.toChars(0x2764)) + String(Character.toChars(65039))