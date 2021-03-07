/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.viewModel.TimerViewModel

@Composable
fun TimerFinished(
    timerViewModel: TimerViewModel,
    buttonDrawable: Int,
    setTimer: () -> Unit
) {
    timerViewModel.onMediaStateChange(true)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = buttonDrawable),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit,
        )
        Text(
            text = "Timer's Up",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(30.dp)
        )
        Button(
            onClick = {
                timerViewModel.onMediaStateChange(false)
                setTimer()
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp)
        ) {
            Text(
                text = "OK",
                style = MaterialTheme.typography.h5
            )
        }
    }
}