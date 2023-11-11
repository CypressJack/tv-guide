package com.example.tvguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.ModalNavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.rememberDrawerState
import com.example.tvguide.ui.theme.TVGuideTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TVGuideTheme {
                Surface {
                    Column {
                        Row {
                            Text(text = "ESPN 4k")
                        }
                        Row {
                            Text(text = "Sportscenter")
                        }
                        Row {
                            Text(text = "Today, 1:30 - 2:30 PM")
                        }
                        Row {
                            Text(text = "The title provides a clear and concise headline, while the subtitle offers additional context or a supporting statement.")
                        }
                        LazyColumn{
                            items(10) {
                                LazyRow {
                                    items(10) {
                                        Program(
                                            onClick = {}
                                        )
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GuideGrid() {

    val stateRowX = rememberLazyListState() // State for the first Row, X
    val stateRowY = rememberLazyListState() // State for the second Row, Y

    Column { // Placing two Lazy Rows one above the other for the example

        LazyRow(state = stateRowY) {
            items(10) {
                Program(
                    onClick = {}
                )
            }
        }

        LazyRow(state = stateRowX) {
            items(10) {
                Program(
                    onClick = {}
                )
            }
        }

    }

    //This might seem crazy

    LaunchedEffect(stateRowX.firstVisibleItemScrollOffset) {
        if (!stateRowY.isScrollInProgress) {
            stateRowY.scrollToItem(
                stateRowX.firstVisibleItemIndex,
                stateRowX.firstVisibleItemScrollOffset
            )
        }
    }

    LaunchedEffect(stateRowY.firstVisibleItemScrollOffset) {
        if (!stateRowX.isScrollInProgress) {
            stateRowX.scrollToItem(
                stateRowY.firstVisibleItemIndex,
                stateRowY.firstVisibleItemScrollOffset
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TVGuideTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun Program(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = {},
        text = { Text(text = "Extended FAB") },
    )
}