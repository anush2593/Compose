package com.example.feature_github.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.feature_github.domain.CustomLocalUriHandler
import com.example.feature_github.domain.getDimenDp
import com.example.feature_github.domain.getDimenSp
import com.example.ui.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val githubViewModel: GithubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardElevation()
        }
    }

    @Preview
    @Composable
    fun CardElevation() {
        val user = githubViewModel.githubUser.observeAsState().value?.data
        val uriHandler = CustomLocalUriHandler.current

        val userName = user?.name ?: user?.login ?: resources.getString(R.string.no_name_available)
        val bio = user?.bio ?: resources.getString(R.string.no_bio_available)
        val twitter = user?.twitterUsername ?: getString(R.string.no_twitter_user_name_available)
        val company = user?.company ?: getString(R.string.no_company_available)
        val location = user?.location ?: getString(R.string.no_location_available)
        val githubLink = user?.githubUrl ?: ""
        val avatarUrl = user?.avatarUrl ?: ""

        Surface(
            shape = RoundedCornerShape(resources.getDimenDp(R.dimen.corner_radius)),
            color = Color(0xFFDAE1E7),
            modifier = Modifier
                .height(resources.getDimenDp(R.dimen.surface_height))
        ) {
            CardContent(
                userName,
                bio,
                twitter,
                company,
                location,
                githubLink,
                avatarUrl,
                uriHandler
            )
        }
    }

    @Composable
    fun CardContent(
        userName: String,
        bio: String,
        twitter: String,
        company: String,
        location: String,
        githubUrl: String,
        avatarUrl: String,
        uriHandler: CustomLocalUriHandler
    ) {
        Row(
            modifier = Modifier.padding(resources.getDimenDp(R.dimen.row_padding)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                UserName(userName)
                UserInfo(twitter, company, location, bio)
                ReadMoreButton(uriHandler, githubUrl)
            }

            AvatarImage(avatarUrl)
        }
    }

    @Composable
    fun UserName(userName: String) {
        Text(
            text = userName,
            fontSize = resources.getDimenSp(R.dimen.user_name_size),
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.SemiBold
        )
    }

    @Composable
    fun UserInfo(twitter: String, company: String, location: String, bio: String) {
        Spacer(modifier = Modifier.height(resources.getDimenDp(R.dimen.spacer_small_margin)))

        Text(text = "Twitter : $twitter")
        Text(text = "Company : $company")
        Text(text = "Location : $location")
        Text(text = "Bio : $bio")

        Spacer(modifier = Modifier.height(resources.getDimenDp(R.dimen.spacer_big_margin)))
    }

    @Composable
    fun ReadMoreButton(uriHandler: CustomLocalUriHandler, githubUrl: String) {
        OutlinedButton(
            shape = RoundedCornerShape(resources.getDimenDp(R.dimen.corner_half_radius)),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black
            ),
            modifier = Modifier.widthIn(min = resources.getDimenDp(R.dimen.button_width)),
            onClick = {
                githubUrl?.let { uriHandler.openUri(this, it) }
            }
        ) {
            Text(
                text = "Read More",
                fontSize = resources.getDimenSp(R.dimen.button_font_size),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }

    @Composable
    fun AvatarImage(avatarUrl: String) {
        Surface(
            shape = RoundedCornerShape(resources.getDimenDp(R.dimen.corner_radius)),
            modifier = Modifier.size(
                width = resources.getDimenDp(R.dimen.avatar_width),
                height = resources.getDimenDp(R.dimen.avatar_height)
            )
        ) {
            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = avatarUrl)
                    .allowHardware(false)
                    .build()
            )

            Image(
                painter = painter,
                contentDescription = "Avatar",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        CardElevation()
    }
}
