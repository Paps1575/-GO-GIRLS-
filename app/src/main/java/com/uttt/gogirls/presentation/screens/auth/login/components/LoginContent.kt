package com.uttt.gogirls.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.uttt.gogirls.R
import com.uttt.gogirls.presentation.components.DefaultButton
import com.uttt.gogirls.presentation.components.DefaultTextField
import com.uttt.gogirls.presentation.navigation.screen.auth.AuthScreen
import com.uttt.gogirls.presentation.screens.auth.login.LoginViewModel

@Composable
fun LoginContent (navController: NavHostController, paddingValues: PaddingValues, vm: LoginViewModel = hiltViewModel()){
    val state=vm.state
    val context= LocalContext.current
    LaunchedEffect (key1 = vm.errorMessage){
        if (vm.errorMessage.isNotEmpty()){
            Toast.makeText(context,vm.errorMessage, Toast.LENGTH_LONG).show()
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFDE36C9), Color(0xFFA80278))
                )
            )
            .padding(paddingValues)
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Login",
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .rotate(90f).padding(top = 15.dp)
            )
            Spacer(modifier = Modifier
                .height(100.dp))
            Text(text = "Registro",
                color = Color.White,
                fontSize = 27.sp,
                modifier = Modifier
                    .clickable { navController.navigate(route = AuthScreen.Register.route) }
                    .rotate(90f).padding(top = 30.dp)
            )
            Spacer(modifier = Modifier
                .height(250.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 60.dp, bottom = 35.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFE51AF5), Color(0xFFDE70EC))
                    ),
                    shape = RoundedCornerShape(
                        topStart = 35.dp,
                        bottomStart = 35.dp
                    )
                )
        ){
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(start = 25.dp)
            ) {
                Text(text = "Bienvenida",
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Go Girls...",
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
                Box(modifier = Modifier
                    .fillMaxWidth()){
                    Image(
                        modifier = Modifier
                            .size(180.dp)
                            .align(Alignment.CenterEnd)
                            .padding(end=35.dp)
                        , painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "",
                    )
                }


                Text(text = "Login",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier
                        .height(50.dp)
                )

                DefaultTextField(
                    modifier = Modifier,
                    value = state.email,
                    onValueChange = {vm.onEmailInput(it)},
                    label = "Ingresa tu correo",
                    icon = Icons.Outlined.Email,
                    keyboardType = KeyboardType.Email

                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )

                DefaultTextField(
                    modifier = Modifier,
                    value = state.password,
                    onValueChange = {vm.onPasswordInput(it)},
                    label = "Ingresa tu comtraseña",
                    icon = Icons.Outlined.Lock,
                    hideText = true

                )
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
                Box(modifier = Modifier
                    .fillMaxWidth()){
                    DefaultButton(
                        modifier = Modifier,
                        text = "LOGIN",
                        onClick = {
                            vm.loginS()
                        }
                    )

                }
                Spacer(modifier = Modifier
                    .height(25.dp)
                )

                ///////
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Spacer(
                        modifier = Modifier
                            .width(30.dp)
                            .height(1.dp)
                            .background(Color.White)
                    )
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 7.dp),
                        text = "O",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Spacer(
                        modifier = Modifier
                            .width(30.dp)
                            .height(1.dp)
                            .background(Color.White)
                    )
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){

                    Text(text = "No tienes cuenta?",
                        color = Color.White,
                        fontSize = 17.sp
                    )
                    Spacer(
                        modifier = Modifier
                            .width(5.dp)
                    )

                    Text(
                        modifier = Modifier
                            .clickable { navController.navigate(route = AuthScreen.Register.route) }, text = "Registrate",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(60.dp)
                )
            }
        }

    }
}