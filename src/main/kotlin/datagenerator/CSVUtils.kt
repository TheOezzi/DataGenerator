package main.kotlin.datagenerator

import java.io.Writer


class CSVUtils {
    private val DEFAULT_SEPARATOR = ';'
    private fun followCVSformat(value: String): String {
        var result = value
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"")
        }
        return result
    }

    fun writeLine(
        w: Writer,
        values: List<String>,
        separators: Char = DEFAULT_SEPARATOR,
        customQuote: Char = ' '
    ) {
        var separators = separators
        var first = true
        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR
        }
        val sb = StringBuilder()
        for (value in values) {
            if (!first) {
                sb.append(separators)
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value))
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote)
            }
            first = false
        }
        sb.append("\n")
        w.append(sb.toString())
    }
}
