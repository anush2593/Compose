package com.example.feature_github.domain

import android.content.Context
import android.content.Intent
import android.net.Uri

class CustomLocalUriHandler {
    companion object {
        val current = CustomLocalUriHandler()
    }

    fun openUri(context: Context, uri: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        context.startActivity(intent)
    }
}