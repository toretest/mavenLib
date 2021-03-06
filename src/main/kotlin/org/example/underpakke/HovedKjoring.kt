@file:DependsOn("com.squareup:kotlinpoet:1.10.2")

package org.example.underpakke

import com.squareup.kotlinpoet.*
import kotlin.script.experimental.dependencies.DependsOn

class HovedKjoring {

    fun kjorHoved(){
       val greeterClass = ClassName("", "Greeter")
val file = FileSpec.builder("", "HelloWorld")
  .addType(
    TypeSpec.classBuilder("Greeter")
      .primaryConstructor(
        FunSpec.constructorBuilder()
          .addParameter("name", String::class)
          .build()
      )
      .addProperty(
        PropertySpec.builder("name", String::class)
          .initializer("name")
          .build()
      )
      .addFunction(
        FunSpec.builder("greet")
          .addStatement("println(%P)", "Hello, \$name")
          .build()
      )
      .build()
  )
  .addFunction(
    FunSpec.builder("main")
      .addParameter("args", String::class, KModifier.VARARG)
      .addStatement("%T(args[0]).greet()", greeterClass)
      .build()
  )
  .build()

file.writeTo(System.out)
    }
}
