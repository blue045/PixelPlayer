package com.theveloper.pixelplay.data.model

enum class FolderSource(val storageKey: String, val displayName: String) {
    INTERNAL("internal", "Internal Storage"),
    SD_CARD("sd_card", "SD Card"),
    ALL("all", "All Storages");

    companion object {
        fun fromStorageKey(rawValue: String?): FolderSource =
            entries.firstOrNull { it.storageKey == rawValue } ?: ALL
    }
}
