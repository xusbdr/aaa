package com.jes.wikiworld


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class Nombre {
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    fun setUserName(username: String) {
        _userName.value = username
    }

    companion object {
        private val instance = Nombre()

        fun getInstance(): Nombre {
            return instance
        }
    }
}
