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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        val uriHandler = LocalUriHandler.current

        val userName = user?.name ?: user?.login ?: resources.getString(R.string.no_name_available)
        val bio = user?.bio ?: resources.getString(R.string.no_bio_available)
        val twitter = user?.twitterUsername ?: getString(R.string.no_twitter_user_name_available)
        val company = user?.company ?: getString(R.string.no_company_available)
        val location = user?.location ?: getString(R.string.no_location_available)

        Surface(
            shape = RoundedCornerShape(resources.getDimenDp(R.dimen.corner_radius)),
            color = Color(0xFFDAE1E7),
            modifier = Modifier
                .height(resources.getDimenDp(R.dimen.surface_height))
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
                    Text(
                        text = userName,
                        fontSize = resources.getDimenSp(R.dimen.user_name_size),
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(resources.getDimenDp(R.dimen.spacer_small_margin)))

                    Text(text = "Twitter : $twitter")
                    Text(text = "Company : $company")
                    Text(text = "Location : $location")
                    Text(text = "Bio : $bio")

                    Spacer(modifier = Modifier.height(resources.getDimenDp(R.dimen.spacer_big_margin)))

                    OutlinedButton(
                        shape = RoundedCornerShape(resources.getDimenDp(R.dimen.corner_half_radius)),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black
                        ),
                        modifier = Modifier.widthIn(min = resources.getDimenDp(R.dimen.button_width)),
                        onClick = {
                            user?.githubUrl?.let { uriHandler.openUri(it) }
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

                Surface(
                    shape = RoundedCornerShape(resources.getDimenDp(R.dimen.corner_radius)),
                    modifier = Modifier.size(
                        width = resources.getDimenDp(R.dimen.avatar_width),
                        height = resources.getDimenDp(R.dimen.avatar_height)
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bg_placeholder),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Avatar"
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        CardElevation()
    }
}
