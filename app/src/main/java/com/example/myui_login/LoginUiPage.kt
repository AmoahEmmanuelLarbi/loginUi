package com.example.myui_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myui_login.ui.theme.MyUi_LoginTheme

class LoginUiPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyUi_LoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    //Main Application
                    LoginUi()
                }
            }
        }
    }
}


//Composable Functions for LoginUi

// Composable For Back Button
@Composable
fun Back_Button() {
    // this is a simple Icon Button,that help user navigate to previous page
    Box(modifier = Modifier.padding(vertical = 20.dp)) {
        IconButton(
            onClick = { /*TODO*/ }, modifier = Modifier.padding(start = 8.dp)
        ) {
            //content of IconButton
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back to previous page",
                tint = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(32.dp)
            )
        }
    }
}

// Composable for Welcome Message
@Composable
fun WelcomeMessage() {
    Column(
        modifier = Modifier.padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        // content of Column widget

        // sigIn text
        Text(
            text = "Let's Sign you in.", fontSize = 20.sp, fontWeight = FontWeight.Bold
        )

        // welcome back
        Text(
            text = "Welcome Back",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )

        // you've been missed
        Text(
            text = "You've been missed!",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
    }

}

// Composable for LoginForm (Form for user to enter email and password)
@Composable
fun UserFormLogin() {
    // variable to accept user input,those to validate form
    // email variable
    var userEmail by remember {
        mutableStateOf("")
    }

    // password variable
    var userPassword by remember {
        mutableStateOf("")
    }

    // variable to check if password if visible or not(by default password is not visible)
    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    // variable to determine which to be displayed as trailing icon based on visibility
    val passwordVisibilityIcon = if (passwordVisibility) painterResource(id = R.drawable.visibility)
    else painterResource(id = R.drawable.visibility_off)


    Column(
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // content of Column
        // username field
        OutlinedTextField(
            value = userEmail,
            onValueChange = { userEmail = it },
            label = { Text(text = "Username or Email") },
            placeholder = { Text(text = "Enter Username or Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person, contentDescription = "Username"
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)

        )

        // password field
        OutlinedTextField(
            value = userPassword,
            onValueChange = { userPassword = it },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter your password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock, contentDescription = "Password"
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = passwordVisibilityIcon, contentDescription = "Password Visibility"
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()

        )
    }

}


// Composable for Different Option Sign in
@Composable
fun DifferentSignInOption() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        // different sign in option text
        Row(//modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // this row will container two Dividers,
            // and a text in the middle of the Dividers
            Divider(
                thickness = 1.5.dp, color = Color.LightGray, modifier = Modifier.width(142.dp)
                //.weight(1F)
            )

            // text
            Text(
                text = "or",
                modifier = Modifier.padding(horizontal = 10.dp),
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Divider(
                thickness = 1.5.dp, color = Color.LightGray, modifier = Modifier.width(142.dp)
                //.weight(1F)
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        // different sign in icons

        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // Google Button
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(10.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google",
                    modifier = Modifier.size(32.dp),
                    alignment = Alignment.Center,
                    alpha = 0.9F

                )

            }
            // add Spacer
            Spacer(modifier = Modifier.size(20.dp))

            // Linkedin Button
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(10.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.linkedin),
                    contentDescription = "Google",
                    modifier = Modifier.size(32.dp),
                    alignment = Alignment.Center,
                    alpha = 0.9F

                )

            }
            // add Spacer
            Spacer(modifier = Modifier.size(20.dp))


            // Facebook Button
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(10.dp)
                    ), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Google",
                    modifier = Modifier.size(32.dp),
                    alignment = Alignment.Center,
                    alpha = 0.9F

                )

            }
        }

    }

}

// Composable for Login Button and registration text
@Composable
fun LoginButton() {
    // this composable contains "Don't Have an account text"
    // (an option for new users to register an account)
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp)
    ) {
        // content of Column widget
        // Don't Have Account text,Register
        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Gray, fontSize = 14.sp, fontWeight = FontWeight.Normal
                )
            ) {
                append("Don't have an account ?")
            }

            append(" ")

            withStyle(
                style = SpanStyle(
                    color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.SemiBold
                )
            ) {
                append("Register")
            }

        })

        // button to login
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            //.align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(14.dp), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black, contentColor = Color.White
            ), elevation = ButtonDefaults.buttonElevation(
                pressedElevation = 8.dp
            )
        ) {
            //button to login
            // content of Button
            Text(
                text = "Login",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(8.dp),
                letterSpacing = 1.sp
            )

        }


    }
}


// Composable to merge all components into  one ui
@Composable
fun LoginUi() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // content of Surface widget
            Back_Button()

            Spacer(modifier = Modifier.size(42.dp))
            WelcomeMessage()

            Spacer(modifier = Modifier.size(70.dp))
            UserFormLogin()

            Spacer(modifier = Modifier.size(30.dp))
            DifferentSignInOption()

            Spacer(modifier = Modifier.size(40.dp))
            LoginButton()

        }
    }
}


// Preview of LoginUi
@Preview(showBackground = true)
@Composable
fun LoginUiPreview() {
    LoginUi()
}


/*
@Composable
fun Greeting() {
    Text(text = "This File is live")
}

@Preview(showBackground = true)
@Composable
fun GreetingsPreview() {
    Greeting()
}*/
