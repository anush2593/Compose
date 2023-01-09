package com.example.feature_bottom_nav.bottomNav

import com.example.ui.R

sealed class BottomNavItem(var route: String, var icon: Int, var title: Int) {
    object Projects :
        BottomNavItem(
            "Projects",
            R.drawable.ic_baseline_library_books_24,
            com.example.ui.R.string.projects
        )

    object Following :
        BottomNavItem("Following", R.drawable.ic_baseline_people_24, R.string.following)

    object Stars : BottomNavItem("Stars", R.drawable.ic_baseline_star_24, R.string.stars)
    object Profile : BottomNavItem("Profile", R.drawable.ic_baseline_home_24, R.string.profile)
}
