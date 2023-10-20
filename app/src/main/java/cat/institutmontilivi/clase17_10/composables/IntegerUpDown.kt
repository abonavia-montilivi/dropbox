package cat.institutmontilivi.clase17_10.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview (widthDp = 200, heightDp = 200)
@Composable
fun IntegerUpdown(
    modifier: Modifier = Modifier,
    colorText: Color = MaterialTheme.colorScheme.onTertiary,
    colorFons: Color = MaterialTheme.colorScheme.tertiary,
    colorBotons: Color = MaterialTheme.colorScheme.errorContainer,
    colorMarc: Color = MaterialTheme.colorScheme.onErrorContainer,
    gruixmarc: Int = 1,
    estilText: TextStyle = MaterialTheme.typography.displayLarge

)
{
    var valor by remember{ mutableIntStateOf(0) }
    Column(modifier//pillar variable del principio
        .clip(RoundedCornerShape(percent = 5))
        .background(color = colorFons)
        .border(
            BorderStroke(
                width = gruixmarc.dp,
                color = colorMarc
            ),
            shape = RoundedCornerShape(percent = 5)
        )
    ) {
        Box(modifier = Modifier.fillMaxWidth()
            .background(colorFons)
            .weight(2F),){
        Text(text = valor.toString(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center),
            style = estilText,
            color = colorText
        )
        }
        Row()
        {
            IconButton(
                onClick = { if (valor>0)valor-- },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(percent = 25))
                    .background(colorBotons)

                    .border(
                        border = BorderStroke(
                            width = gruixmarc.dp,
                            color = colorMarc
                        ),
                        shape = RoundedCornerShape(percent=25)
                    )
            )
            {
                Icon(Icons.Filled.Remove,
                    "Decrementa el comptador")

            }
            IconButton(
                onClick = { valor++ },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(percent = 25))
                    .background(colorBotons)

                    .border(
                        border = BorderStroke(
                            width = gruixmarc.dp,
                            color = colorMarc
                        ),
                        shape = RoundedCornerShape(percent=25)
                    )
            )
            {
                Icon(Icons.Filled.Add,
                    "Decrementa el comptador")

            }
        }
    }
}