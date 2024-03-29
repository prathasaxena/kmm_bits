package components.common

import Strings
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import dev.icerock.moko.resources.StringResource

@Composable
fun stringResource(id: StringResource, vararg args: Any) : String {
    return  Strings(LocalContext.current).get(id, args.toList())
}