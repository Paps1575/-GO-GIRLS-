package com.uttt.gogirls.presentation.screens.auth.register

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set
    var errorMessage by mutableStateOf("")

    fun onNameInput(name:String){
        state=state.copy(name = name)
    }
    fun onLastNameInput(lastName:String){
        state=state.copy(lastName=lastName)
    }

    fun onEmailInput(email:String){
        state=state.copy(email =email )
    }

    fun onPhoneInput(phone:String){
        state=state.copy(phone=phone)
    }

    fun onPasswordInput(password:String){
        state=state.copy(password=password)
    }

    fun onConfirmPasswordInput(confirmPassword:String){
        state=state.copy(confirmPassword=confirmPassword)
    }

    fun register(){
        if (isValidForm()){
            Log.d("RegisterViewModel","Name:${state.name}")
            Log.d("RegisterViewModel","LastName:${state.lastName}")
            Log.d("RegisterViewModel","Phone:${state.phone}")
            Log.d("RegisterViewModel","Email:${state.email}")
            Log.d("RegisterViewModel","Password:${state.password}")
            Log.d("RegisterViewModel","ConfirmPassword:${state.confirmPassword}")
        }
    }

    fun isValidForm():Boolean{
        errorMessage=""
        if (state.name.isEmpty()){
            errorMessage="Ingresa el nombre"
            return false
        }
        else if (state.lastName.isEmpty()){
            errorMessage="Ingresa el apellido"
            return false
        }
        else if (state.email.isEmpty()){
            errorMessage="Ingresa el email"
            return false
        }
        else if (state.phone.isEmpty()){
            errorMessage="Ingresa el telefono"
            return false
        }
        else if (state.password.isEmpty()){
            errorMessage="Ingresa la contraseña"
            return false
        }
        else if (state.confirmPassword.isEmpty()){
            errorMessage="Confirma tu contraseña"
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage="El email no es valido"
            return false
        }
        else if (state.password.length<6){
            errorMessage="La contraseña debe tener al menos 6 caracteres"
            return false
        }
        else if (state.password!=state.confirmPassword){
            errorMessage="La contraseña no coincide"
            return false
        }
        return true
    }

}