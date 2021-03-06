/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.countriesphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.countriesphotos.network.CountriesApi
import com.example.android.countriesphotos.network.CountriesImage
import com.example.android.countriesphotos.network.ImageResponseModel
import kotlinx.coroutines.launch
import java.lang.Exception


class OverviewViewModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<List<CountriesImage>>()
    val photo: LiveData<List<CountriesImage>> = _photos

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    init {
        getContryPhotos()
    }


    private fun getContryPhotos() {
        viewModelScope.launch {
            try{
                _photos.value =CountriesApi.retrofitService.getImages().data
                _status.value = "Success: Mars properties retrieved"
            }catch (e:Exception){
                _status.value = "Failure: ${e.message}" }

        }
    }

}
