package br.com.fiap.myaiteacher.ui.screen.bookmarks

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.myaiteacher.model.bookmark.Bookmark
import br.com.fiap.myaiteacher.repository.bookmark.BookmarkRepository
import br.com.fiap.myaiteacher.ui.screen.bookmarks.components.BodyBookmarks
import br.com.fiap.myaiteacher.ui.screen.bookmarks.components.HeaderBookmarks
import br.com.fiap.myaiteacher.ui.screen.chat.components.NavigationItem
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BookmarksScreen(navController: NavController, bookmarksScreenViewModel: BookmarksScreenViewModel) {
    val context = LocalContext.current
    val bookmarkRepository = BookmarkRepository(context)
    val configuration = LocalConfiguration.current
    val selected by bookmarksScreenViewModel.selected.observeAsState(initial = 0)
    val bookmarks by bookmarksScreenViewModel.bookmarksList.observeAsState(initial = bookmarkRepository.exibirBoomarks())
    val scrollState = rememberLazyListState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val drawerItems = listOf(
        NavigationItem(
            title = "Chat",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            colors = Color.White,
            click = {
                navController.navigate("chat")
            }
        ),
        NavigationItem(
            title = "Logout",
            selectedIcon = Icons.Filled.ArrowBack,
            unselectedIcon = Icons.Outlined.ArrowBack,
            colors = Color.Red,
            click = {
                navController.navigate("login")
            }
        ),
    )

    //Screen content
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color(0xFF2C2F34)
            ) {
                Box(modifier = Modifier.height(20.dp))
                drawerItems.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedBadgeColor = item.colors,
                            unselectedBadgeColor = item.colors,
                            selectedIconColor = item.colors,
                            unselectedIconColor = item.colors,
                            selectedTextColor = item.colors,
                            unselectedTextColor = item.colors,
                            selectedContainerColor = Color(0xFF2C2F34),
                            unselectedContainerColor = Color(0xFF2C2F34)
                        ),
                        label = {
                            Text(text = item.title)
                        },
                        selected = index == selected,
                        onClick = {
                            bookmarksScreenViewModel.onChangeSelected(newSelected = index)
                            item.click()
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selected) {
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        badge = {
                            item.badgeCount?.let {
                                Text(text = item.badgeCount.toString())
                            }
                        },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)

                    )
                }
            }
        },
        drawerState = drawerState
    ) {
        Column {
            HeaderBookmarks(configuration = configuration, drawerState = drawerState, scope = scope)
            Spacer(modifier = Modifier.height((configuration.screenHeightDp * 0.002).dp))
            BodyBookmarks(
                configuration = configuration,
                items = bookmarks,
                scrollState = scrollState,
                bookmarksScreenViewModel = bookmarksScreenViewModel
            )
        }
    }
}