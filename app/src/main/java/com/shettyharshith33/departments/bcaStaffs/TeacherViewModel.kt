package com.shettyharshith33.beforeLoginScreens.departments.bcaStaffs

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TeacherViewModel : ViewModel() {
    var teachers by mutableStateOf<List<Teacher>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun fetchBCATeachers() {
        isLoading = true
        Firebase.firestore.collection("bcaStaffs")
            .get()
            .addOnSuccessListener { result ->
                teachers = result.documents.mapNotNull { it.toObject(Teacher::class.java) }
                isLoading = false
            }
            .addOnFailureListener {
                isLoading = false
            }
    }
}
