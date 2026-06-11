/**
 * TempeMusic Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.tempemusic.music.lyrics

import android.content.Context
import com.tempemusic.music.betterlyrics.BetterLyrics
import com.tempemusic.music.constants.EnableBetterLyricsKey
import com.tempemusic.music.utils.dataStore
import com.tempemusic.music.utils.get

object BetterLyricsProvider : LyricsProvider {
    override val name = "BetterLyrics"

    override fun isEnabled(context: Context): Boolean = context.dataStore[EnableBetterLyricsKey] ?: true

    override suspend fun getLyrics(
        context: Context,
        id: String,
        title: String,
        artist: String,
        duration: Int,
        album: String?,
    ): Result<String> = BetterLyrics.getLyrics(title, artist, duration, album)
}
