package com.voidcorp.voidplay.utils

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import com.voidcorp.voidplay.MainActivity
import timber.log.Timber

object IconSwitcher {

    private const val BASE_PACKAGE = "com.voidcorp.voidplay"

    val ALIASES = listOf(
        "MainActivityAmoled",
        "MainActivityOcean",
        "MainActivityFrost"
    )

    fun setIcon(context: Context, aliasName: String) {
        val packageManager = context.packageManager

        ALIASES.forEach { alias ->
            val componentName = ComponentName(context, "$BASE_PACKAGE.$alias")
            val newState = if (alias == aliasName) {
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED
            } else {
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED
            }

            try {
                packageManager.setComponentEnabledSetting(
                    componentName,
                    newState,
                    PackageManager.DONT_KILL_APP
                )
            } catch (e: Exception) {
                Timber.e(e, "Failed to set icon alias: $alias")
            }
        }

        // Handle the main activity if none of the aliases are selected or as default
        // Usually, we want one of the aliases to be the primary launcher.
    }
}
