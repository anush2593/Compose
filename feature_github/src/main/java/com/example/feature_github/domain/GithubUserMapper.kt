package com.example.feature_github.domain

import javax.inject.Inject

class GithubUserMapper @Inject constructor() {

    fun map(input: GithubUserResponse?): GithubUserInfo = GithubUserInfo(
        name = input?.name,
        avatar_url = input?.avatar_url,
        bio = input?.bio,
        company = input?.company,
        location = input?.location,
        twitter_username = input?.twitter_username,
        githubUrl = input?.html_url,
        login = input?.login

    )
}
