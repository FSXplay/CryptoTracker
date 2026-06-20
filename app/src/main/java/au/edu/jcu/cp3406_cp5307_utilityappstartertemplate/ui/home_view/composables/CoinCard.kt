package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.ui.home_view.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.text.NumberFormat

@Composable
fun CoinCard(
    name: String,
    price: Double,
    currency: String,
    change24h: Double?,
    change7d: Double?,
    change30d: Double?,
    change1y: Double?
) {
    val formattedPrice = NumberFormat.getNumberInstance().format(price)

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "$formattedPrice ${currency.uppercase()}",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ChangeText("24h", change24h)
                ChangeText("7d", change7d)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ChangeText("30d", change30d)
                ChangeText("1y", change1y)
            }
        }
    }
}

@Composable
private fun ChangeText(
    label: String,
    value: Double?
) {
    val color = when {
        value == null -> Color.Gray
        value >= 0 -> Color(0xFF2E7D32)
        else -> Color(0xFFC62828)
    }

    Text(
        text = "$label: ${value?.let { String.format("%.2f%%", it) } ?: "N/A"}",
        color = color,
        style = MaterialTheme.typography.bodySmall
    )
}