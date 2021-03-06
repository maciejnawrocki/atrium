//TODO remove file with 0.17.0
@file:Suppress("DEPRECATION")

package ch.tutteli.atrium.core.robstoll.lib.reporting

import ch.tutteli.atrium.reporting.MethodCallFormatter
import ch.tutteli.atrium.reporting.Text

/**
 * Responsible to format a method call for text output (e.g. to the console) where it represents arguments of a
 * method call by using their [Any.toString] representation with a few exceptions.
 *
 * The exceptions are:
 * - [CharSequence], is wrapped in quotes (`"`) and \r as well as \n are escaped.
 * - [Char] is wrapped in apostrophes (`'`)
 */
@Deprecated("Use the implementation of atrium-core; will be removed with 0.17.0")
object TextMethodCallFormatter : MethodCallFormatter {
    override fun formatCall(methodName: String, arguments: Array<out Any?>): String =
        arguments.joinToString(", ", prefix = "$methodName(", postfix = ")") { formatArgument(it) }

    override fun format(methodName: String, arguments: Array<out Any?>): () -> String = {
        formatCall(methodName, arguments)
    }

    override fun formatArgument(argument: Any?): String = when (argument) {
        null -> Text.NULL.string
        is CharSequence -> "\"$argument\"".replace("\r", "\\r").replace("\n", "\\n")
        is Char -> "'$argument'"
        else -> argument.toString()
    }
}
