package com.example.feature_github.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_github.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardElevation()
        }
    }

    @Preview
    @Composable
    fun CardElevation(
        githubViewModel: GithubViewModel = hiltViewModel()

    ) {
        val user = githubViewModel.githubUser.observeAsState().value?.data
        val uriHandler = LocalUriHandler.current

        val userName = user?.name ?: user?.login ?: "No name available"
        val bio = user?.bio ?: "No bio available"
        val twitter = user?.twitter_username ?: "No twitter username available"
        val company = user?.company ?: "No company available"
        val location = user?.location ?: "No location available"

        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFFDAE1E7),
            modifier = Modifier
                .height(300.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
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
                        fontSize = 24.sp,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = "Twitter : $twitter")
                    Text(text = "Company : $company")
                    Text(text = "Location : $location")
                    Text(text = "Bio : $bio")

                    Spacer(modifier = Modifier.height(40.dp))

                    OutlinedButton(
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black
                        ),
                        modifier = Modifier.widthIn(min = 250.dp),
                        onClick = {
                            user?.githubUrl?.let { uriHandler.openUri(it) }
                        }
                    ) {
                        Text(
                            text = "Read More",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.size(width = 100.dp, height = 140.dp)
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
