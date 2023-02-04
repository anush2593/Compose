package com.example.feature_github.domain

import javax.inject.Inject

class GithubUserMapper @Inject constructor() {

    fun map(input: GithubUserResponse?): GithubUserInfo = GithubUserInfo(
        name = input?.name,
        avatarUrl = input?.avatarUrl,
        bio = input?.bio,
        company = input?.company,
        location = input?.location,
        twitterUsername = input?.twitterUsername,
        githubUrl = input?.htmlUrl,
        login = input?.login

    )
}
