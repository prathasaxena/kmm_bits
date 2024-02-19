package components.navigation.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.common.stringResource
import components.navigation.NavigationViewModel
import org.pratha.bits.MR


val textStyle = TextStyle(
    fontSize = 15.sp,
)
@Preview
@Composable
fun TopAppBarTitle(
    modifier: Modifier = Modifier,
    currentContext : Context = LocalContext.current,
    navigationViewModel: NavigationViewModel = NavigationViewModel(),
    leftContent : @Composable () -> Unit = { Spacer(modifier = Modifier.width(20.dp)) },
    rightContent : @Composable () -> Unit = { Spacer(modifier = Modifier.width(20.dp)) },
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

    ) {
//        Text(
//            style = textStyle,
//            color = Color(MR.colors.primaryBlue.getColor(currentContext)),
//            text = "Login")
        leftContent()
        Text(text = stringResource(id = navigationViewModel.navigationState.topBarTitle),
            style = textStyle,
            color = Color(MR.colors.textColor.getColor(currentContext)),
            fontWeight = FontWeight.Bold
            )

        rightContent()
//        Button(onClick = { /*TODO*/ },
//            modifier = modifier
//                .width(100.dp)
//                .height(50.dp)
//        ) {
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(text = "Attend",
//                    style = textStyle,)
//                Text(text = "4535 Rs",
//                    style = textStyle,)
//            }
//
//        }

    }

}