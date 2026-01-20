package com.example.myapplicationexample1.api_consumer.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplicationexample1.api_consumer.presentation.utils.DistributionOrientation

@Composable
fun UniformDistribution(
    distributionOrientation: DistributionOrientation,
    children: List<Pair<Float, @Composable () -> Unit>>,
    spacingBetweenWeight: Float = 0.05f,
    spacingAroundWeight: Float = 0.1f
) {
    when (distributionOrientation) {

        DistributionOrientation.horizontally -> {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(spacingAroundWeight))

                children.forEachIndexed { index, (weight, content) ->
                    Box(
                        modifier = Modifier.weight(weight)
                    ) {
                        content()
                    }

                    if (index < children.lastIndex) {
                        Spacer(modifier = Modifier.weight(spacingBetweenWeight))
                    }
                }

                Spacer(modifier = Modifier.weight(spacingAroundWeight))
            }
        }

        DistributionOrientation.vertically -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(spacingAroundWeight))

                children.forEachIndexed { index, (weight, content) ->
                    Box(
                        modifier = Modifier.weight(weight)
                    ) {
                        content()
                    }

                    if (index < children.lastIndex) {
                        Spacer(modifier = Modifier.weight(spacingBetweenWeight))
                    }
                }

                Spacer(modifier = Modifier.weight(spacingAroundWeight))
            }
        }
    }
}