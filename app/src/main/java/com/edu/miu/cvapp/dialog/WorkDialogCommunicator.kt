package com.edu.miu.cvapp.dialog

import com.edu.miu.cvapp.model.Work


interface WorkDialogCommunicator {
    fun onAddWOrk(work: Work)
}