package com.github.melin.superior.sql.parser.arithmetic

import com.github.melin.superior.sql.parser.model.StatementData
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.atn.PredictionMode
import org.antlr.v4.runtime.misc.ParseCancellationException
import org.apache.commons.lang3.StringUtils
import com.github.melin.superior.sql.parser.antlr4.ParseException
import com.github.melin.superior.sql.parser.antlr4.arithmetic.ArithmeticLexer
import com.github.melin.superior.sql.parser.antlr4.arithmetic.ArithmeticParser

/**
 *
 * Created by libinsong on 2018/1/10.
 */
object ArithmeticHelper {

    @JvmStatic fun getStatementData(command: String) : StatementData? {
        return ArithmeticHelper.getStatementData(command, true)
    }

    @JvmStatic fun getStatementData(command: String, bracketEnbled: Boolean) : StatementData? {
        val trimCmd = StringUtils.trim(command)

        val charStream = CharStreams.fromString(trimCmd);
        val lexer = ArithmeticLexer(charStream)

        val tokenStream = CommonTokenStream(lexer)
        val parser = ArithmeticParser(tokenStream)
        parser.bracket_enbled = bracketEnbled
        parser.interpreter.predictionMode = PredictionMode.SLL

        val sqlVisitor = ArithmeticAntlr4Visitor(bracketEnbled)

        try {
            try {
                // first, try parsing with potentially faster SLL mode
                return sqlVisitor.visit(parser.expression())
            } catch (e: ParseCancellationException) {
                tokenStream.seek(0) // rewind input stream
                parser.reset()

                // Try Again.
                parser.interpreter.predictionMode = PredictionMode.LL
                return sqlVisitor.visit(parser.expression())
            }
        } catch (e: ParseException) {
            if(StringUtils.isNotBlank(e.command)) {
                throw e;
            } else {
                throw e.withCommand(trimCmd)
            }
        }
    }
}
