package com.uttt.gogirls.presentation.screens.auth.register.components

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
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
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
import com.uttt.gogirls.presentation.components.DefaultOutlinedTextField
import com.uttt.gogirls.presentation.screens.auth.register.RegisterViewModel


@Composable
fun RegisterContent(navHostController: NavHostController, paddingValues: PaddingValues, vm: RegisterViewModel = hiltViewModel()) {

    val context= LocalContext.current
    val state=vm.state

    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage.isNotEmpty()){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(listOf(Color(0xFFDE36C9), Color(0xFFA80278)))
            )
            .padding(paddingValues)
    ){
        Column (
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ){
            Text(text = "Login",
                color = Color.Black,
                fontSize = 27.sp,
                modifier = Modifier
                    .rotate(90f)
                    .padding(top = 10.dp)
                    .clickable { navHostController.popBackStack() }

            )
            Spacer(modifier =  Modifier.height(250.dp))
            Text(text = "Registro",
                color = Color.Black,
                fontSize = 35.sp,
                modifier = Modifier
                    .rotate(90f)
                    .padding(top = 70.dp),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier =  Modifier.height(250.dp))

        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(start = 50.dp, bottom = 35.dp)
            .background(
                brush = Brush.linearGradient(listOf(Color(0xFFF88DFF), Color(0xFFED9BF3))),
                shape = RoundedCornerShape(
                    topStart = 35.dp,
                    bottomStart = 35.dp
                )
            )
        ){
            Column (
                modifier = Modifier
                    .statusBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                ){
                    Image(
                        modifier = Modifier
                            .size(170.dp)
                            .align(Alignment.Center), painter = painterResource(id= R.drawable.car_white),
                        contentDescription = null)
                }

                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.name,
                    label = "Nombre",
                    icon = Icons.Outlined.Person,
                    onValueChange ={vm.onNameInput(it)}
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.lastName,
                    label = "Apellido",
                    icon = Icons.Outlined.Person,
                    onValueChange ={vm.onLastNameInput(it)}
                )
                Spacer(modifier = Modifier.height(10.dp))

                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.email,
                    label = "Email",
                    icon = Icons.Outlined.Email,
                    keyboardType = KeyboardType.Email,
                    onValueChange ={vm.onEmailInput(it)}
                )
                Spacer(modifier = Modifier.height(10.dp))

                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.phone,
                    label = "Telefon",
                    icon = Icons.Outlined.Phone,
                    keyboardType = KeyboardType.Number,
                    onValueChange ={vm.onPhoneInput(it)}
                )
                Spacer(modifier = Modifier.height(10.dp))


                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.password,
                    label = "Contraseña",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange ={vm.onPasswordInput(it)}
                )
                Spacer(modifier = Modifier.height(10.dp))

                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.confirmPassword,
                    label = "Confirmar contraseña",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange ={vm.onConfirmPasswordInput(it)}
                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(
                    modifier = Modifier,
                    text = "Crear Usario",
                    onClick = {
                        vm.register()
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier
                        .width(30.dp)
                        .height(1.dp)
                        .background(Color.Black))
                    Text(
                        modifier = Modifier
                            .padding(7.dp), text = "O",
                        fontSize = 20.sp,
                        color = Color.Black)
                    Spacer(modifier = Modifier
                        .width(30.dp)
                        .height(1.dp)
                        .background(Color.Black))
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Ya tienes cuenta?",
                        color = Color.Black,
                        fontSize = 17.sp,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        modifier = Modifier
                            .clickable { navHostController.popBackStack() },
                        text = "Inicar sesion",
                        color = Color.Black,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }

}