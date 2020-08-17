

package com.strumenta.rpgtojava

import com.github.javaparser.printer.PrettyPrinterConfiguration


// rpgJavaInterpreter-core-v0.1.5.jar
import com.smeup.rpgparser.interpreter.*
import com.smeup.rpgparser.parsing.ast.*
import com.smeup.rpgparser.parsing.facade.RpgParserFacade
import com.smeup.rpgparser.parsing.parsetreetoast.resolveAndValidate

//transpiler /src/main/kotlin
import com.strumenta.rpgtojava.intermediateast.*
//import com.strumenta.rpgtojava.intermediateast.GProgram
import com.strumenta.rpgtojava.transformations.transformFromIntermediateToJava
import com.strumenta.rpgtojava.transformations.transformFromRPGtoIntermediate


import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import kotlin.system.exitProcess

/*
 Note that every class of our intermediate AST will extend, directly or indirectly,
 Node. Node is a class from the Kolasu library. It is a dependency of Jariko,
 so by adding Jariko as a dependency we indirectly include it. Kolasu is a library that simplifies writing ASTs in Kotlin
 */

//kolasu-a0e7970eae.jar
import com.strumenta.kolasu.parsing.toStream


import java.nio.file.Paths

/*
fun transpileRpgToJava(source: InputStream, name: String) : String {
    val rpgAst = parseRpgCode(source)
    val javaAst = transform(rpgAst, name)
    return generate(javaAst)
}
*/
// Pasar codigo de  RPG a AST
fun parseRpgCode(source: InputStream) : CompilationUnit {
    val facade = RpgParserFacade()
    facade.muteSupport = false
    val rpgAst = facade.parseAndProduceAst(source)
    rpgAst.resolveAndValidate(DummyDBInterface)
    return rpgAst
}

// pasar de codigo RPG AST a modelo intermedio
fun transformRpgToIntermediate(source: InputStream, name: String) : GProgram {
    val rpgAst = parseRpgCode(source)
    return transformFromRPGtoIntermediate(rpgAst, name)
}

//Modelo intermedio Ast a Java
fun transform(rpgAst: CompilationUnit, name: String) : com.github.javaparser.ast.CompilationUnit {
    val intermediateAst = transformFromRPGtoIntermediate(rpgAst, name)
    val javaAst = transformFromIntermediateToJava(intermediateAst)
    return javaAst
}

//javaparser-core ---> com.github.javaparser.ast.CompilationUnit
fun generate(javaAst: com.github.javaparser.ast.CompilationUnit) : String {
    return javaAst.toString(PrettyPrinterConfiguration())
}






fun main(args: Array<String>) {
			
							
		val path = Paths.get("").toAbsolutePath().toString()
		//println("Working Directory = $path")
		
		val codigoPrueba = File(path +"/src/test/resources/CicloFor.rpgle")
		
        val nombre = codigoPrueba.nameWithoutExtension
	

		println("RPG a AST")
		println("")
		val rpgAst = parseRpgCode(FileInputStream(codigoPrueba))
		
		println(rpgAst)
		
		println("")
		println("RPG AST a modelo intermedio")
		println("")
		val intermediateAst = transformFromRPGtoIntermediate(rpgAst, nombre)
		println(intermediateAst)
		
		
	    //generar codigoJava
		println("")
		println("Modelo intermedio Ast a Java")
		println("")
		val javaAst = transformFromIntermediateToJava(intermediateAst)
		println(generate(javaAst))


}