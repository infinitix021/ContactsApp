package com.example.contactsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.contactsapp.ui.theme.ContactsAppTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            ContactsAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = stringResource(id = R.string.app_name)) },
                            actions = {

                                IconButton(onClick = {
                                    val phone = "+20"
                                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                                    context.startActivity(intent)
                                } ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.home_icon),
                                        contentDescription = null
                                    )
                                }
                            }
                        )
                    },
                    content = { innerPadding ->
                        Aligner(
                            contact = Contacts().getInfo(),
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                )
            }
        }
    }
}


@Composable
fun ContactsScreen(modifier: Modifier = Modifier, contact: Collect) {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()

    ) {

       Cantos(
           painter = painterResource(id = contact.image),
           name = stringResource(id = contact.name),
           number = stringResource(id = contact.number),
        )
    }
}


@Composable
fun Aligner (modifier: Modifier = Modifier, contact: List<Collect>) {

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(count = 3),
        ) {
        
        items(contact) {
            ContactsScreen(contact = it)

        }
    }
}


@Composable
fun Cantos(painter: Painter, name: String, number: String) {

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = colorResource(id = R.color.light_grey))
            .clickable {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                context.startActivity(intent)
            }

    ){
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(137.dp)
        )

        Text(
            text = name,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )
        SelectionContainer {
            Text(
                text = number,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//     fun ContactView() {
//    com.example.contactsapp.Aligner(contact = Contacts().getInfo())
//}
