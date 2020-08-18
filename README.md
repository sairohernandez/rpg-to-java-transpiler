# RPG a Java transpiler reproduccion en Eclipse 

Este proyecto fue reproducido sobre Windows. Lista de pasos a seguir para la configuración

1. Instalar el IDE eclipse Eclipse IDE for Enterprise Java Developers. Version: 2019-09 R (4.13.0)

2. Instalar complemento para la interpretación de Kotlin. https://kotlinlang.org/docs/tutorials/getting-started-eclipse.html

3. Despues de descargar el proyecto, agregar gradle la proyecto, Para agregar Gradle a nuestro proyecto debemos dar clic derecho sobre el proyecto "rpg-to-java-transpiler", seleccionar la opción configure y posteriormente "add Gradle Nature",Esto hace que a nuestro proyecto se agreguen las referencias automáticamente 

4. Importar el código de la solución desde el repositorio Github https://github.com/sairohernandez/rpg-to-java-transpiler, Guía con los pasos par importar un respositorio de GitHub desde Eclipse http://javaen.blogspot.com/2015/09/como-importar-un-proyecto-de-github-al-eclipse.html

<p>
<img title="Estructura archivos proyecto Eclipse" alt="" src="https://github.com/sairohernandez/rpg-to-java-transpiler/blob/master/img/Estructura_Archivos_Proyecto_Eclipse.png" />
</p>

5. para poder ejecutar nuestra aplicación  transpiler.kt debemos configurar una tarea de Gradle con la instrucción Run y referenciando nuestra área de trabajo "Working Directory", para ello vamos al menú Run y clic en "Run configurations" ahi creamos una tarea Gradle dando clic en "New Configurations" sobre "Gradle Taks". 

<p>
<img title="Estructura archivos proyecto Eclipse" alt="" src="https://github.com/sairohernandez/rpg-to-java-transpiler/blob/master/img/Configuracion_Run_Eclipse.PNG" />
</p>
