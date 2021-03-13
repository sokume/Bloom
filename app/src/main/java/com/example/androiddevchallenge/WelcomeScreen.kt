package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.theme.MyTheme

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenLightPreview() {
    MyTheme {
        WelcomeScreenMake(onClick = {})
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreenMake(onClick = {})
    }
}

@Composable
fun WelcomeScreen(navController: NavHostController) {
    // Edit Color Status Bar
    val context = LocalContext.current
    val activity = (context as MainActivity)
    activity.window.statusBarColor = context.resources.getColor(R.color.primary, context.theme)

    WelcomeScreenMake(onClick = {
        navController.navigate("log_in")
    })
}

@Composable
fun WelcomeScreenMake(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
    ) {
        BottomBackground()
        WelcomeItems(onClick = onClick)
    }
}

@Composable
fun WelcomeItems(onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        LeafImage(
            Modifier
                .padding(top = 72.dp, start = 88.dp)
        )
        LogoImage(
            Modifier
                .padding(top = 48.dp)
                .fillMaxWidth()
        )
        LogoText(
            Modifier
                .height(32.dp)
                .fillMaxWidth()
        )
        CreateAccountButton(
            Modifier
                .padding(top = 40.dp)
                .height(48.dp)
                .fillMaxWidth(),
            onClick = onClick
        )
        LoginButton(
            Modifier
                .padding(top = 8.dp)
                .height(48.dp)
                .fillMaxWidth(),
            onClick = {}
        )
    }
}

@Composable
fun LoginButton(
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        TextButton(
            onClick = onClick,
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .padding(
                    start = 16.dp, end = 16.dp
                ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent
            )
        ) {
            Text(
                text = "Log in",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.secondary,
            )
        }
    }
}

@Composable
fun CreateAccountButton(
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
                .padding(
                    start = 16.dp, end = 16.dp
                ),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary
            )

        ) {
            Text(
                text = "Create account",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onSecondary,
            )
        }
    }
}

@Composable
fun LogoText(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = "Beautiful home garden solutions",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onPrimary,
        )
    }
}

@Composable
fun LogoImage(modifier: Modifier) {
    val image: Painter = painterResource(id = R.drawable.ic_logo)
    Image(
        image,
        "logo_image",
        modifier = modifier
    )
}

@Composable
fun LeafImage(modifier: Modifier) {
    val image: Painter = painterResource(id = R.drawable.ic_welcome_illos)
    Image(
        painter = image,
        contentDescription = "background_image",
        modifier = modifier
            .height(280.dp)
            .width(310.dp),
        alignment = Alignment.TopStart,
        contentScale = ContentScale.None,
    )
}

@Composable
fun BottomBackground() {
    val image: Painter = painterResource(id = R.drawable.ic_welcome_bg)
    Image(
        image,
        "background_image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth
    )
}
