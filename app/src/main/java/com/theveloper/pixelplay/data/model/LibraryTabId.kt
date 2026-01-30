package com.theveloper.pixelplay.data.model

import androidx.compose.runtime.Immutable
import com.theveloper.pixelplay.R

@Immutable
enum class LibraryTabId(
    val storageKey: String,
    val title: String,
    val defaultSort: SortOption
) {
    SONGS("SONGS", "SONGS", SortOption.SongTitleAZ),
    ALBUMS("ALBUMS", "ALBUMS", SortOption.AlbumTitleAZ),
    ARTISTS("ARTIST", "ARTIST", SortOption.ArtistNameAZ),
    PLAYLISTS("PLAYLISTS", "PLAYLISTS", SortOption.PlaylistNameAZ),
    FOLDERS("FOLDERS", "FOLDERS", SortOption.FolderNameAZ),
    LIKED("LIKED", "LIKED", SortOption.LikedSongDateLiked);

    companion object {
        fun fromStorageKey(key: String): LibraryTabId =
            entries.firstOrNull { it.storageKey == key } ?: SONGS
    }
}

fun String.toLibraryTabIdOrNull(): LibraryTabId? =
    LibraryTabId.entries.firstOrNull { it.storageKey == this }

fun LibraryTabId.displayTitle(): String = when (this) {
    LibraryTabId.SONGS -> "Songs"
    LibraryTabId.ALBUMS -> "Albums"
    LibraryTabId.ARTISTS -> "Artists"
    LibraryTabId.PLAYLISTS -> "Playlists"
    LibraryTabId.FOLDERS -> "Folders"
    LibraryTabId.LIKED -> "Liked"
}

fun LibraryTabId.iconRes(): Int = when (this) {
    LibraryTabId.SONGS -> R.drawable.rounded_music_note_24
    LibraryTabId.ALBUMS -> R.drawable.rounded_album_24
    LibraryTabId.ARTISTS -> R.drawable.rounded_artist_24
    LibraryTabId.PLAYLISTS -> R.drawable.rounded_playlist_add_24
    LibraryTabId.FOLDERS -> R.drawable.rounded_folder_24
    LibraryTabId.LIKED -> R.drawable.rounded_favorite_24
}