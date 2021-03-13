package com.example.androiddevchallenge

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androiddevchallenge.ui.theme.MyTheme

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenLightPreview() {
    MyTheme {
        LoginScreenMake()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        LoginScreenMake()
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    Text(text = "LoginScreen")

    // Edit Color Status Bar
    val context = LocalContext.current
    val activity = (context as MainActivity)
    activity.window.statusBarColor = context.resources.getColor(R.color.background, context.theme)

    LoginScreenMake()
}

@Composable
fun LoginScreenMake() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    ) {
        LoginItems()
    }
}

@Composable
fun LoginItems() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        LoginTitle(
            Modifier
                .fillMaxWidth()
                .height(184.dp)
        )

        EmailAddressInputText(
            Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )

        PasswordInputText(
            Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(top = 8.dp, start = 16.dp, end = 16.dp)
        )

        LoginText(
            Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
        )

        LoginAccountButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            onClick = { /*TODO*/ })
    }
}

@Composable
fun LoginAccountButton(
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
fun LoginText(modifier: Modifier) {

    val annotatedLinkString: AnnotatedString = buildAnnotatedString {

        val str =
            "Be clicking below,you agree to our Terms of Use and consent to our Privacy Policy."
        val startIndex1 = str.indexOf("Terms of Use")
        val endIndex1 = startIndex1 + 12
        val startIndex2 = str.indexOf("Privacy Policy")
        val endIndex2 = startIndex2 + 14

        append(str)
        addStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onPrimary,
                fontSize = 12.sp
            ), start = 0, end = str.length
        )
        addStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onPrimary,
                fontSize = 12.sp,
                textDecoration = TextDecoration.Underline
            ), start = startIndex1, end = endIndex1
        )
        addStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.onPrimary,
                fontSize = 12.sp,
                textDecoration = TextDecoration.Underline
            ), start = startIndex2, end = endIndex2
        )
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {

        ClickableText(
            text = annotatedLinkString,
            style = MaterialTheme.typography.body2,
            onClick = {}
        )
    }
}

@Composable
fun PasswordInputText(modifier: Modifier) {
    val passwordValue = remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = modifier,
        // border = Border(2.dp, Color.Black)
    )
    {

        TextField(
            value = passwordValue.value,
            onValueChange = {
                passwordValue.value = it
            },
            placeholder = {
                Text(
                    text = "Password (8+ characters)",
                )
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.onBackground,
                    shape = MaterialTheme.shapes.small
                ),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Password,
            ),
            textStyle = MaterialTheme.typography.body1,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                textColor = MaterialTheme.colors.onBackground,
            )
        )
    }
}

@Composable
fun EmailAddressInputText(modifier: Modifier) {
    val emailValue = remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = modifier,
        // border = Border(2.dp, Color.Black)
    )
    {

        TextField(
            value = emailValue.value,
            onValueChange = {
                emailValue.value = it
            },
            placeholder = {
                Text(
                    text = "Email address",
                )
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.onBackground,
                    shape = MaterialTheme.shapes.small
                ),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Email,
            ),
            textStyle = MaterialTheme.typography.body1,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                textColor = MaterialTheme.colors.onBackground,
            )
        )
    }
}

@Composable
fun LoginTitle(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = "Log in with email",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onPrimary,
        )
    }
}
