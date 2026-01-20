package com.example.myapplicationexample1.api_consumer.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationexample1.api_consumer.presentation.viewmodel.ApiConsumerViewModel
import androidx.compose.runtime.getValue
import com.example.myapplicationexample1.api_consumer.presentation.ui.CharacterCard
import com.example.myapplicationexample1.api_consumer.presentation.ui.UniformDistribution
import com.example.myapplicationexample1.api_consumer.presentation.utils.DistributionOrientation

@Composable
fun ApiConsumerScreen(viewmodel: ApiConsumerViewModel = viewModel()) {
    val characters by viewmodel.characters.collectAsStateWithLifecycle()
    val chunkedCharacters = characters.chunked(5)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Spacer(modifier = Modifier.weight(0.5f))
        Button(
            onClick = {},
            modifier = Modifier.width(200.dp)
        ) {
            Text("ejecutar request")
        }
        Spacer(modifier = Modifier.weight(0.5f))
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.weight(9f)
        ) {
            items(chunkedCharacters.size) { index ->
                UniformDistribution(
                    distributionOrientation = DistributionOrientation.horizontally,
                    children = chunkedCharacters[index].map { character ->
                        1f to { CharacterCard(character) }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}