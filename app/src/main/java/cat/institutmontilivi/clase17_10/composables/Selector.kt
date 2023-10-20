package cat.institutmontilivi.clase17_10.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PreviewSelector(){
    val dies = listOf("DG", "DL", "DM", "DC", "DJ", "DV", "DS")
    Selector(dies, {String, Int->{}})
}

@Composable
fun Selector(
    opcions: List<String>,
    onSeleccionChanged: ((String, Int)-> Unit),
    modifier: Modifier = Modifier,
    opcioInicial:Int =0,
    colorResaltat: Color = Color.Yellow,
    colorBotons: Color = Color.White,
    colorMarc: Color = MaterialTheme.colorScheme.onErrorContainer,
    gruixmarc: Int = 1
)
{
    var opcioSeleccionada by remember { mutableStateOf(opcioInicial) }
    Row(modifier){
        opcions.mapIndexed {index, valor ->
            Text(valor,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(colorBotons)
                    .weight(1F)
                    .border(
                        border = BorderStroke(
                            width = (gruixmarc.dp),
                            color = colorMarc
                        )
                    )
                    .background(
                        color = if (index==opcioSeleccionada)
                            colorResaltat
                        else
                        colorBotons
                    )
                    .clickable { opcioSeleccionada=index
                    onSeleccionChanged(opcions[opcioSeleccionada], opcioSeleccionada)}
                )
        }
    }
}