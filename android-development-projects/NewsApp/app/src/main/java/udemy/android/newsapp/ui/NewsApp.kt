package udemy.android.newsapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import udemy.android.newsapp.MockData
import udemy.android.newsapp.ui.screen.DetailScreen
import udemy.android.newsapp.ui.screen.TopNews

@Composable
fun NewsApp() {
    Navigation()
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "TopNews") {
        composable("TopNews"){
            TopNews(navController)
        }
        composable("Detail/{newsId}",
            arguments = listOf(navArgument("newsId"){type = NavType.IntType})){
            navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("newsId")
            val newsData = MockData.getNews(id)
            DetailScreen(navController, newsData)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsAppPreview() {
    NewsApp()
}