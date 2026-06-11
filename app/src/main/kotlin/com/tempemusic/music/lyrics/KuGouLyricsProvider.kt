/**
 * TempeMusic Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.tempemusic.music.lyrics

import android.content.Context
import com.tempemusic.kugou.KuGou
import com.tempemusic.music.constants.EnableKugouKey
import com.tempemusic.music.utils.dataStore
import com.tempemusic.music.utils.get

object KuGouLyricsProvider : LyricsProvider {
    override val name = "Kugou"
    override fun isEnabled(context: Context): Boolean =
        context.dataStore[EnableKugouKey] ?: true

    override suspend fun getLyrics(
        context: Context,
        id: String,
        title: String,
        artist: String,
        duration: Int,
        album: String?,
    ): Result<String> =
        KuGou.getLyrics(title, artist, duration, album)

    override suspend fun getAllLyrics(
        context: Context,
        id: String,
        title: String,
        artist: String,
        duration: Int,
        album: String?,
        callback: (String) -> Unit,
    ) {
        KuGou.getAllPossibleLyricsOptions(title, artist, duration, album, callback)
    }
}
