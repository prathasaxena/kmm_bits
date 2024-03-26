package components.navigation.ui

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.common.stringResource
import components.navigation.NavigationViewModel
import org.pratha.bits.MR
import viewModels.login.LoginViewModel


val textStyle = TextStyle(
    fontSize = 20.sp,
)
@Preview
@Composable
fun TopAppBarTitle(
    modifier: Modifier = Modifier,
    currentContext : Context = LocalContext.current,
    // implement KOIN
    navigationViewModel: NavigationViewModel = NavigationViewModel(),
    loginViewModel: LoginViewModel = LoginViewModel(),
    //
    leftContent : @Composable () -> Unit = { Spacer(modifier = Modifier.width(20.dp)) },
) {
    val loginState by loginViewModel.loginState.collectAsState()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        leftContent()
        Text(text = stringResource(id = navigationViewModel.navigationState.topBarTitle),
            style = textStyle,
            color = Color(MR.colors.textColor.getColor(currentContext)),
            fontWeight = FontWeight.Bold
            )
        if (!loginState.isLoggedIn) {
            ClickableText(
                text = AnnotatedString(stringResource(id = MR.strings.login)),
                modifier = Modifier.padding(horizontal = 10.dp),
                style = TextStyle(textDecoration = TextDecoration.Underline)
            ) {
                
            }
        }
       
    }

}