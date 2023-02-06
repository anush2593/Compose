package com.example.feature_github.domain

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

class GithubUserResponse(
    @SerializedName("login")
    val login: String? = null,

    @Keep
    val id: Int = 0,

    @SerializedName("node_id")
    val nodeId: String? = null,

    @SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @SerializedName("gravatar_id")
    val gravatarId: String? = null,

    @Keep
    val url: String? = null,

    @SerializedName("html_url")
    val htmlUrl: String? = null,

    @SerializedName("followers_url")
    val followersUrl: String? = null,

    @SerializedName("following_url")
    val followingUrl: String? = null,

    @SerializedName("gists_url")
    val gistsUrl: String? = null,

    @SerializedName("starred_url")
    val starredUrl: String? = null,

    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String? = null,

    @SerializedName("organizations_url")
    val organizationsUrl: String? = null,

    @SerializedName("repos_url")
    val reposUrl: String? = null,

    @SerializedName("events_url")
    val events_url: String? = null,

    @SerializedName("received_events_url")
    val receivedEventsUrl: String? = null,

    @Keep
    val type: String? = null,

    @SerializedName("site_admin")
    val siteAdmin: String? = null,

    @Keep
    val name: String? = null,

    @Keep
    val company: String? = null,
    @SerializedName("blog")

    val blog: String? = null,
    @Keep
    val location: String? = null,

    @Keep
    val email: String? = null,

    @Keep
    val hireable: String? = null,

    @Keep
    val bio: String? = null,

    @SerializedName("twitter_username")
    val twitterUsername: String? = null,

    @SerializedName("public_repos")
    val public_repos: Int,

    @SerializedName("public_gists")
    val publicGists: Int,

    @Keep
    val followers: Int,

    @Keep
    val following: Int,

    @SerializedName("created_at")
    val created_at: String? = null,

    @SerializedName("updated_at")
    val updated_at: String? = null
)
