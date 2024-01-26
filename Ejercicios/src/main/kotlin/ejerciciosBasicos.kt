import java.nio.DoubleBuffer
import java.util.*
import javax.print.attribute.standard.PagesPerMinute
import kotlin.math.min
import kotlin.reflect.typeOf

/**
 * Ejercicio 4.1¶
 * Crear una clase Persona que tenga nombre, peso (en kg con decimales), altura (en metros con decimales) y su imc.
 *
 * Crear un constructor primario con todos los atributos, excepto nombre e imc. Este último atributo de la clase se calculará en un bloque init que situarás a continuación de la declaración del atributo.
 *
 * Crear un constructor secundario que también incluya el nombre de la persona cómo parámetro.
 *
 * En el main() crear 3 personas diferentes, utilizando el constructor primario y secundario, y realizar lo siguiente:
 *
 * La persona1 debe modificar su nombre y para ello debes solicitarlo al usuario por consola.
 * Mostrar el nombre, peso y altura de la persona 2.
 * Actualizar imc de la persona3 haciendo el cálculo con su peso y altura.
 */

class Persona(val peso: Double, val altura: Double){
    var nombre: String = ""
    var imc: Double = 0.0


    init {
        this.imc = peso / (altura * altura)
    }

    constructor(peso: Double, altura: Double, nombre: String): this(peso, altura){
        this.nombre = nombre
    }

}

fun ejericioBasico1(){
    val persona1 = Persona(55.6, 1.80)
    val persona2 = Persona(70.0, 1.67, "Amancio")
    val persona3 = Persona(98.4, 1.89, "Juan")

    print("Introduce nuevo nombre de la persona1: ")
    persona1.nombre = readln()

    println("Nombre: ${persona2.nombre}\nPeso: ${persona2.peso}\nAltura: ${persona2.altura}\nIMC: ${"%.2f".format(persona2.imc)}")

}


/**
 * Ejercicio 4.2¶
 * Actualizar el ejercicio 1 para añadir a la clase el siguiente comportamiento:
 *
 * Debe saludar con su nombre... saludar()
 * Debe retornar su imc... obtenerImc()
 * Debe implementar también un método que muestre una descripción completa de la persona... mostrarDesc(). Por ejemplo, este método mostrará por pantalla algo así:
 *
 * "Julia con una altura de 1.72m y un peso 64.7kg tiene un IMC de 21,87 (peso saludable)".
 * * Sería conveniente añadir también un método obtenerImcDesc() para usar en mostrarDesc(), que implemente el retorno de la descripción del rango de tipo de imc al que equivale su cálculo.
 * Nota: * Si el IMC es menos de 18.5, se encuentra dentro del rango de "peso insuficiente". * Si el IMC está entre 18.5 y 24.9, se encuentra dentro del rango de "peso saludable". * Si el IMC está entre 25.0 y 29.9, se encuentra dentro del rango de "sobrepeso". * Si el IMC es 30.0 o superior, se encuentra dentro del rango de "obesidad".
 *
 * Crear en el main() una estructura de datos con 4 o 5 personas más, recorrer la estructura y por cada persona debe saludar y mostrar su descripción completa.
 *
 * Finalmente, revisa el IDE e intenta actualizar el modificador de visibilidad de los métodos de tu clase cómo os estará indicando... veréis que los métodos que realmente no van a ser llamados desde fuera de la clase te recomienda que sean privados a la misma. De esta manera estamos encapsulando estos métodos para que se puedan utilizar zolo desde dentro de la clase y no sean públicos.
 */

class Persona2(private val peso: Double, private val altura: Double){
    private var nombre: String = "'Sin nombre'"
    private var imc: Double = 0.0


    init {
        this.imc = peso / (altura * altura)
    }

    // Constructor secundario que le añade el nombre
    constructor(peso: Double, altura: Double, nombre: String): this(peso, altura){
        this.nombre = nombre
    }

    /**
     * Saluda con unnn mensaje mostrando su nombre
     */
    fun saludar(){
        //if (this.nombre.isBlank()) this.nombre = "'Sin nombre'"
        println("Hola soy ${this.nombre}")
    }

    /**
     * Obtiene el valor de la variable imc, que previamente se le ha calculado su valor
     * @return imc - Valor del imc
     */
    private fun calcularImc() = this.imc

    /**
     * Devuelve un string indicando el nivel al que pertence una persona segun peso
     * @return Str - Nombre que corresponde al nivel de peso
     */
    private fun obtenerImcDesc(): String{
        return when {
            imc < 18.5 -> "Peso Insuficiente"
            imc in 18.5..24.9 -> "Peso saludable"
            imc in 25.0..29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }
    }

    /**
     * Crea una pequeña descripcion de cada persona creada con la clase Persona2
     */
    fun mostrarDesc(){
        //if (this.nombre.isBlank()) this.nombre = "'Sin nombre'"
        println("${this.nombre} con una altura de ${this.altura} y un peso de ${this.peso} tiene un IMC de ${"%.2f".format(calcularImc())} (${obtenerImcDesc()})\n")
    }
}

fun ejercicioBasico2(){
    val personas = listOf(
        Persona2(55.6, 1.80),
        Persona2(70.0, 1.67, "Amancio"),
        Persona2(98.4, 1.89, "Juan"),
        Persona2(100.00, 1.50),
        Persona2(58.45, 1.8, "Maria"),
        Persona2(65.0, 1.75, "Laura"),
        Persona2(80.5, 1.72, "Carlos")
    )

    // Recorre la lista de objetos creados para ejecutar sus metodos saludar() y mostrarDesc()
    for (persona in personas){
        persona.saludar()
        persona.mostrarDesc()
    }
}



/**
 * Ejercicio 4.3¶
 * Crear una clase Rectángulo, con atributos base y altura. La clase debe disponer del constructor y los métodos para calcular el área y el perímetro.
 *
 * Opcionalmente se puede crear el método toString() para mostrar información sobre el rectángulo.
 *
 * En el programa principal, crear varios rectángulos y mostrar por pantalla sus áreas y perímetros.
 */


class Rectangulo(private val altura: Double, private val base: Double ){


    init {
        require(this.base > 0 && this.altura > 0) {"La base y altura debe ser mayor a 0"}
    }

    private fun calcularArea(): Double{
        return this.base * this.altura
    }

    private fun calcularPerimetro(): Double{
        return 2 * (this.base + this.altura)
    }

    // Sobreescribimos la funcion toString() usando override. Solo se sobreescribe dentro de esta clase
    override fun toString(): String {
        return "Datos rectangulo de base ${this.base} y altura ${this.altura}:\nArea: ${calcularArea()}\nPerimetro: ${calcularPerimetro()}\n"
    }
}


fun ejercicioBasico3(){

    val rectangulos = listOf(
        Rectangulo(5.0, 3.4),
        Rectangulo(55.0, 6.4),
        Rectangulo(33.0, 45.4)
    )

    for (rectangulo in rectangulos){
        print("${rectangulo.toString()}\n")

    }

}



// ANTIGUO
/**
 * Ejercicio 4.4¶
 * Crear una clase Coche, a través de la cual se pueda conocer el color del coche, la marca, el modelo, el número de caballos, el número de puertas y la matrícula. Crear el constructor del coche, así como los métodos estándar: getters, setters y toString().
 *
 * Para realizar getters y setters, añade el modificador private a los atributos de la clase y genera los métodos getColor(), setColor(), ..., así para todos los atributos.
 *
 * En el programa principal, instancia varios coches, muestra su información, cambia el color a algunos de ellos y vuelve a mostrarlos por pantalla.
 *
 * Realiza también una modificación al método setNumCaballos() para que no permita actualizar el atributo numCaballos con un valor interior a 70, ni superior a 700.
 *
 * Realiza otra modificación al método setNumPuertas() para que no se pueda actualizar con un valor inferior a 3, ni superior a 5... pero esta vez utiliza require.
 *
 * Para probar las modificaciones a los métodos anteriores, solicita al usuario el número de caballos para un coche y haz lo mismo para el número de puertas.



class Coche(
    private var color: String,
    private var marca: String,
    private var modelo: String,
    private var numCaballos: Int,
    private var numPuertas: Int,
    private var matricula: String
)   {

    // GETTERS marca modelo
    fun getMarca(): String = this.marca
    fun setMarca(marca2: String){
        this.marca = marca2
    }


    fun getModelo(): String = this.modelo
    fun setModelo(modelo2: String){
        this.modelo = modelo2
    }


    fun getColor():String = this.color
    fun setColor(color2: String){
        this.color = color2
    }


    fun getNumCaballos():Int = this.numCaballos
    fun setNumCaballos(numCaballos2: Int){
        //require(numCaballos2 in 70..700) {"ERROR: Los caballos deben estar entre 70-700"}
        if (numCaballos2 !in 70..700) throw IllegalArgumentException ("ERROR: Los caballos deben estar entre 70-700")
        this.numCaballos = numCaballos2
    }



    fun getNumPuertas():Int = this.numPuertas
    fun setNumPuertas(numPuertas2: Int) {
        require(numPuertas2 in 3..5) { "El numero de puertas debe ser 3-5" }
        this.numPuertas = numPuertas2
    }


    fun getMatricula():String = this.matricula
    fun setMatricula(matricula2: String){
        this.matricula = matricula2
    }


    // Override toString()
    override fun toString(): String {
        return "Datos coche - Color: ${this.color}, Marca: ${this.marca}, Modelo: ${this.modelo}, Numero de Caballos: ${this.numCaballos}, Numero de Puertas: ${this.numPuertas}, Matricula: ${this.matricula}"
    }

}


fun ejercicioBasico4(){

    // Lista que contiene cada coche creado
    val coches = listOf(
        Coche("Rojo", "Toyota", "Corolla", 120, 4, "ABC123"),
        Coche("Azul", "Honda", "Civic", 90, 5, "XYZ789"),
        Coche("Verde", "Ford", "Focus", 150, 4, "DEF456"),
        Coche("Negro", "Volkswagen", "Golf", 110, 3, "GHI789")
    )

    // Mostrar informacion coches por defecto
    println("DATOS COCHES: ")
    for (coche in coches){
        println(coche.toString())
    }

    // Cambiar color de estos coches accediendo a sus posicione en la lista
    coches[0].setColor("Amarillo") //coche1
    coches[3].setColor("Verde") //coche2

    // Mostrar informacion coches con los cambios
    println("DATOS COCHES ACTUALIZADOS: ")
    for (coche in coches){
        println(coche.toString())
    }

    // Solicitar num de caballos y aplicarlo
    println("Ingresa numero de caballos: ")
    coches[0].setNumCaballos(readln().toIntOrNull() ?:0)

    // Solicitar num de puertas y aplicarlo
    println("Ingresa numero de puertas: ")
    coches[0].setNumPuertas(readln().toIntOrNull() ?:0)

    // Mostrar informacion de coche1 actualizada usando nuestra funcion reemplazada de toString()
    println("Informacion actualizada coche1: ")
    println(coches[0].toString())


    // Se podria hacer sin usar lista, y haciendo coche1.toString(), coche2.toString() etc...

}
**/


// NUEVO 4.4
/**
 * EJ 4 V2
 * Ejercicio 4.4¶
 * Crear una clase Coche, a través de la cual se pueda conocer el color del coche, la marca, el modelo, el número de caballos, el número de puertas y la matrícula. Crear el constructor del coche, así como el método toString().
 *
 * Marca y modelo no podrán ser blancos ni nulos y no podrán modificarse. --
 * Número de caballos, número de puertas y matrícula no podrán modificarse, ni podrán ser nulos.
 * Color podrá modificarse, pero no podrá ser nulo.
 * Recuerda que Kotlin añade los getters y setters con el comportamiento por defecto, por lo que no es necesario que los implementes, a no ser que tengas que añadir alguna funcionalidad extra.
 *
 * Modifica el atributo matricula para que no permita actualizar la matrícula con un valor que no tenga 7 caracteres.
 * Los atributos de modelo la marca siempre se devolverán con la primera letra en mayúscula.
 * Realiza también una modificación del atributo número de caballos, para que no permita actualizar el atributo numCaballos con un valor interior a 70, ni superior a 700.
 * Realiza una modificación del atributo número de puertas, para que no permita actualizar el atributo numPuertas con un valor inferior a 3, ni superior a 5.
 * Ten en cuenta todas estas condiciones a la hora de crear el constructor de la clase.
 * En el programa principal, instancia varios coches y muéstralos por pantalla. Probar las modificaciones anteriores, modifica el número de caballos para un coche y haz lo mismo para el número de puertas, el color, la marca y modelo. Vuelve a mostrarlos por pantalla.
 *
 * Intenta instanciar y modificar con la marca y modelo con valores nulos o blancos y comprueba que no es posible.
 * Intenta instanciar y modificar con el número de caballos con un valor inferior a 70 o superior a 700 y comprueba que no es posible.
 * Intenta instanciar y modificar con el número de puertas con un valor inferior a 3 o superior a 5 y comprueba que no es posible.
 * Intenta instanciar y modificar con la matrícula con un valor que no tenga 7 caracteres y comprueba que no es posible.
 * Intenta instanciar y modificar con el color, el número de caballos, el número de puertas y la matrícula con valores nulos/blancos y comprueba que no es posible.
 **/


class Coche(
    var color: String,
    marca: String,
    modelo: String,
    numCaballos: Int,
    numPuertas: Int,
    matricula: String
){
    init {

        require(marca.isNotBlank()){"Error - La marca no puede estar vacia"}
        require(modelo.isNotBlank()){"Error - El modelo no puede estar vacio"}
        require(matricula.length == 7) { "ERROR - La longitud de la matricula debe ser 7" }
        //requireNumCaballos(numCaballos)
        require(numCaballos in 70..700) { "ERROR - Los cv deben estar en el rango de 70..700" }
        require(numPuertas in 3..5) { "ERROR - El num de puertas debe estar entre 3..5" }
    }


    var matricula: String = ""
        set(value) {
            //require(value.length == 7) { "Error - La longitud de la matriicula debe ser 7" }
            //field = value
            if (value.length != 7) println( "ERROR - La longitud de la matriicula debe ser 7" ) else field = value
        }

    var marca: String = marca
        get() = field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        set(value){
            if (value.isEmpty()) println("ERROR - La marca no puede estar vacia") else field = value
        }


    var modelo: String = modelo.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        set(value){
            if (value.isEmpty()) println("ERROR - El modelo no puede estar vacio") else field = value
        }
    var numCaballos: Int = numCaballos
        set(value) {
            //requireNumCaballos(value)
            //require(value in 70..700) { "Los cv deben estar en un rango 70-700. No se ha modificado" }
            //field = value
            if (value !in 70..700) println("ERROR - Los cv deben estar en un rango 70-700. No se ha modificado") else field = value


        }

    var numPuertas: Int = numPuertas
        set(value){
            //require(value in 3..5) { "Numero de puertas debe estar entre 3-5. No se ha modificado" }
            //field = value
            if (value !in 3..5) println("ERROR - Numero de puertas debe estar entre 3-5. No se ha modificado") else field = value

        }

    private fun requireNumCaballos(numCaballos: Int){
        require(numCaballos in 70..700) { "Los cv deben estar en un rango 70-700. No se ha modificado" }
    }


    // Override toString()
    override fun toString(): String {
        return "Datos coche - Color: ${this.color}, Marca: ${this.marca}, Modelo: ${this.modelo}, Numero de Caballos: ${this.numCaballos}, Numero de Puertas: ${this.numPuertas}, Matricula: ${this.matricula}"
    }
}



fun ejercicioBasico4(){

    // Creamos coches
    val coche1 = Coche("rojo", "audi", "rs6", 560, 5,"123d567")
    val coche2 = Coche("azul", "bmw", "m3", 450, 4, "XYZ5678")
    val coche3 = Coche("negro", "mercedes", "amg c63", 510, 4, "DEF9012")


    // Mostramos los coches
    println(coche1.toString())
    println(coche2.toString())
    println(coche3.toString())

    // Modificamos valores
    coche1.matricula = "abcdefg"
    coche1.numPuertas = 3
    coche1.color = "platino"
    coche1.numCaballos = 367



    // Mostramos los coches
    println("***************************************************************************")
    println("***************************************************************************")
    println(coche1.toString())
    println(coche2.toString())
    println(coche3.toString())

    // Intentamos modificar
    coche2.modelo = ""
    coche2.marca = ""
    coche2.numCaballos = 785
    coche2.numPuertas = 6
    coche3.matricula = "456123"

    // Mostramos los coches
    println("***************************************************************************")
    println("***************************************************************************")
    println(coche1.toString())
    println(coche2.toString())
    println(coche3.toString())

    // Intentamos instanciar
    try {
        val coche4 = Coche("", "", "", 0, 0, "")
    }catch (e: IllegalArgumentException){
        println("ERROR AL INSTANCIAR EL COCHE- $e")
    }
}





/**
 * Ejercicio 4.5¶
 * Crear una clase Tiempo, con atributos hora, minuto y segundo, que pueda ser construida indicando los tres atributos, sólo hora y minuto o sólo la hora (si no se indica, el valor de minuto o segundo será 0).
 *
 * Crear el método toString() para mostrar el tiempo en formato: XXh XXm XXs.
 *
 * En el programa principal, debe solicitar por teclado hora, minuto y segundo de forma que se puedan omitir los segundos o los minutos (y segundos, claro) e instancie la clase Tiempo mostrando su valor.
 */

/*
class Tiempo(private var hora: Int){
    private var minuto: Int = 0
    private var segundo: Int = 0


    // Constructor para crear con hora y minuto
    constructor(hora: Int, minuto: Int  ): this(hora) {
        this.minuto = minuto
    }

    // Contructor para crear con hora minuto y segundo
    constructor(hora: Int, minuto: Int, segundo: Int): this(hora, minuto){
        this.segundo = segundo
    }

    override fun toString(): String {
        return "Tiempo - ${this.hora}h ${this.minuto}m ${this.segundo}s"
    }
}


fun pedirIntValido(): Int{
    var num: Int?

    do {
        val valor = readln()
        if (valor == "") return 0
        num = valor.toIntOrNull()

        if (num == null || num !in 0..24) println("Debes introducir un numero valido (0-24s): ")

    }while (num == null || num !in 0..24)
    return num
}

fun ejercicioBasico5(){
    println("Introduce hora: ")
    val hora = pedirIntValido()

    println("Introduce minuto (ENTER para omitir): ")
    val minuto = pedirIntValido()

    println("Introduce segundo (ENTER para omitir): ")
    val segundo = pedirIntValido()

    val tiempo = Tiempo(hora, minuto, segundo)

    print(tiempo.toString())

}
*/



// ejercici5 v2
/*
Ejercicio 4.5¶
Crear una clase Tiempo, que refleja las horas de un día, es decír, desde 00:00:00 hasta 23:59:59, con atributos hora, minuto y segundo, que pueda ser construida indicando los tres atributos, sólo hora y minuto o sólo la hora (si no se indica, el valor de minuto o segundo será 0).

Crear el método toString() para mostrar el tiempo en formato: XXh XXm XXs.

En el programa principal, debe solicitar por teclado hora, minuto y segundo de forma que se puedan omitir los segundos o los minutos (y segundos, claro) e instancie la clase Tiempo mostrando su valor.

A tener en cuenta:

Si segundos o minutos es mayor que 60, se tendrá que hacer las operaciones necesarios para incrementar la magnitud superior por el resultado del modulo de 60, quedándose en segundos o minutos con el resto. Es decir 65 segundos equivale a : 1 minuto y 5 segundos.
Hora siempre tendrá que ser menor que 24, si no, lanzará una excepción.
Añadir un nuevo método incrementar(t:Tiempo):Boolean, que incrementa en t, el total del tiempo que almacena el objeto que recibe el mensaje, devolviendo false si al incrementar se superan las 23:59:59, en cuyo caso no cambiaría nada del objeto que recibe el mensaje. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al incrementar en t el tiempo, mostrando un mensaje de error si devuelve false.

Añadir un nuevo método decrementar(t:Tiempo):Boolean, que decrementa en t, el total del tiempo que almacena el objeto que recibe el mensaje, devolviendo false si al decrementar se superan las 00:00:00, en cuyo caso no cambiaría nada del objeto que recibe el mensaje. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al decrementar en t el tiempo, mostrando un mensaje de error si devuelve false.

Añadir un nuevo método comparar(t:Tiempo):Int, que compara el tiempo que almacena el objeto que recibe el mensaje con el tiempo que almacena t, devolviendo -1 si el tiempo del objeto que recibe el mensaje es menor que t, 0 si son iguales y 1 si es mayor. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al comparar el tiempo del objeto que recibe el mensaje con el tiempo de t.

Añadir un nuevo método copiar():Tiempo, que devuelve un objeto Tiempo con el mismo tiempo que almacena el objeto que recibe el mensaje. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al copiar el tiempo del objeto que recibe el mensaje en un nuevo objeto Tiempo.

Añadir un nuevo método copiar(t:Tiempo):Tiempo, que copia el tiempo que almacena t en el objeto que recibe el mensaje. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al copiar el tiempo de t en el objeto que recibe el mensaje.

Añadir un nuevo método sumar(t:Tiempo):Tiempo?, que suma el tiempo que almacena el objeto que recibe el mensaje con el tiempo que almacena t, devolviendo un nuevo objeto Tiempo con el resultado o null si el resultado es mayor que 23:59:59. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al sumar el tiempo del objeto que recibe el mensaje con el tiempo de t.

Añadir un nuevo método restar(t:Tiempo):Tiempo?, que resta el tiempo que almacena el objeto que recibe el mensaje con el tiempo que almacena t, devolviendo un nuevo objeto Tiempo con el resultado o null si el resultado es menor que 00:00:00. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al restar el tiempo del objeto que recibe el mensaje con el tiempo de t.

Añadir un nuevo método esMayorQue(t:Tiempo):Boolean, que devuelve true si el tiempo que almacena el objeto que recibe el mensaje es mayor que el tiempo que almacena t. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al comparar si el tiempo del objeto que recibe el mensaje es mayor que el tiempo de t.

Añadir un nuevo método esMenorQue(t:Tiempo):Boolean, que devuelve true si el tiempo que almacena el objeto que recibe el mensaje es menor que el tiempo que almacena t. En el programa principal, debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al comparar si el tiempo del objeto que recibe el mensaje es menor que el tiempo de t.
*/


class Tiempo(var hora: Int, var minuto: Int = 0, var segundo: Int = 0){


    init {
        require(hora in 0..23) { "ERROR - La hora debe estar entre 0..23" }

        if (segundo > 60){
            minuto += segundo / 60
            segundo %= 60
        }

        if (minuto > 60){
            hora += minuto / 60
            minuto %= 60
        }
    }

    fun incrementar(t: Tiempo): Boolean{

        this.segundo += t.segundo
        this.minuto += t.minuto
        this.hora += t.hora
        formatearTiempo(this)

        return this.hora <= 23
    }

    //TODO CORREGIR CUANDO SON NEGATIVOS
    fun decrementar(t: Tiempo): Boolean{
        this.segundo -= t.segundo
        this.minuto -= t.minuto
        this.hora -= t.hora
        formatearTiempo(this)
        return (this.segundo >= 0 && this.minuto >= 0 && this.hora >= 0)
    }

    fun formatearTiempo(t: Tiempo){
        if (t.segundo > 60){
            t.minuto += t.segundo / 60
            t.segundo %= 60
        }

        if (t.minuto > 60){
            t.hora += t.minuto / 60
            t.minuto %= 60
        }
    }

    fun comparar(t: Tiempo): Int{
        val segundos1 = (this.hora * 3600) + (this.minuto * 60) +  (this.segundo)
        val segundos2 = (t.hora * 3600) + (t.minuto * 60) +  (t.segundo)
        return when{
            segundos1 < segundos2 -> -1
            segundos1 > segundos2 -> 1
            else -> 0
        }
    }


    fun copiar():Tiempo{
        return Tiempo(this.hora, this.minuto, this.segundo)
    }


    fun copiar(t:Tiempo):Tiempo{
        return Tiempo(t.hora, t.minuto, t.segundo)
    }

    fun sumar(t: Tiempo):Tiempo?{
        this.segundo += t.segundo
        this.minuto += t.minuto
        this.hora += t.hora

        val segundos = (this.hora * 3600) + (this.minuto * 60) +  (this.segundo)
        if (segundos > 86400){
            return null
        }

        formatearTiempo(this)
        return this
    }

    /**
    fun restar(t: Tiempo): Tiempo?{
        //TODO

    }*/

    fun esMayorQue(t: Tiempo): Boolean{
        val segundos = (this.hora * 3600) + (this.minuto * 60) +  (this.segundo)
        val segundos2 = (t.hora * 3600) + (t.minuto * 60) +  (t.segundo)
        if (segundos > segundos2){
            println("El tiempo actual es mayor.")
            return true
        }
        return false
    }

    fun esMenorQue(t: Tiempo): Boolean{
        val segundos = (this.hora * 3600) + (this.minuto * 60) +  (this.segundo)
        val segundos2 = (t.hora * 3600) + (t.minuto * 60) +  (t.segundo)
        if (segundos2 > segundos){
            println("El tiempo actual es menor.")
            return true
        }
        return false
    }

    //TODO ACABAR ESTA FUNCION Y REEMPLAZARLA EN TODO EL CODIGO REPETIDO QUE HAY
    fun calcularSegundos(tiempo: Tiempo): Int{
        val segundos = (tiempo.hora * 3600) + (tiempo.minuto * 60) +  (tiempo.segundo)
        return segundos
    }

    /**
     * Reemplazamos la funcion toString() para mostrar la hora formateada correctamente
     */
    override fun toString():String{
        var horaF = ""
        if (this.hora < 10) horaF = "0${this.hora}" else horaF = this.hora.toString()

        var minF = ""
        if (this.minuto < 10) minF = "0${this.minuto}" else minF = this.minuto.toString()

        var segF = ""
        if (this.segundo < 10) segF = "0${this.segundo}" else segF = this.segundo.toString()

        return "$horaF:$minF:$segF"
    }
}


fun pedirTiempo(msg: String, obligatorio: Boolean = true): Int{
    var num: Int?
    println(msg)
    do {
        val valor = readln()
        num = if (valor.isBlank()) {
                if (obligatorio) {
                    println("Este valor es obligatorio: ")
                    null
                } else 0

        }else valor.toIntOrNull()

        if (num == null || num < 0) println("Debes introducir un numero valido")

    }while (num == null || num < 0)
    return num
}





fun ejercicioBasico5(){


    //TODO TRY CATCH EXPECIONES AL INTRODCUIR DATOS DE HORA MIN SEG

    // obejto tiempo fijo test
    val testTiempo = Tiempo(6,20,10)
    val testTiempo2 = Tiempo(10,50,6)

/*
    // Instanciamos la clase tiempo con los valores pedidos
    println("TIEMPO 1:")
    val tiempo1 = Tiempo(pedirTiempo("Introduce hora: "),pedirTiempo("Introduce minutos (enter para omitir): ", false),pedirTiempo("Introduce segundos (enter para omitir): ", false))
    println(tiempo1.toString())

    // Metodo incrementar tiempo
    println("TIEMPO 2:")
    val tiempo2 = Tiempo(pedirTiempo("Introduce hora: "),pedirTiempo("Introduce minutos (enter para omitir): ", false),pedirTiempo("Introduce segundos (enter para omitir): ", false))
    if (!(tiempo1.incrementar(tiempo2))) println("Error, la hora resultante no es valida!: $tiempo1")

    println("*********************************")
    println("Tiempo actual $tiempo1")
    println("*********************************")

    //Metodo decrementar tiempo
    println("TIEMPO 3:")
    val tiempo3 = Tiempo(pedirTiempo("Introduce hora: "),pedirTiempo("Introduce minutos (enter para omitir): ", false),pedirTiempo("Introduce segundos (enter para omitir): ", false))
    //val sumaTiempo = tiempo1.decrementar(tiempo3)
    if (!(tiempo1.decrementar(tiempo3))) println("Error, la hora resultante no es valida!: $tiempo1")

    println("*********************************")
    println("Tiempo actual $tiempo1")
    println("*********************************")


    if (testTiempo.comparar(tiempo2) == 0) {
        println("Tiempo iguales")
    } else if (testTiempo.comparar(tiempo2) == 1) {
        println("Tiempo1 es mayor que Tiempo2")
    } else if (testTiempo.comparar(tiempo2) == -1) {
        println("Tiempo1 es menor que Tiempo2")
    } else {
        println("Comparación no valida")
    }
*/
    // Prueba del metodo .copiar() con el testTiempo
    println("Print testTiempo: $testTiempo")
    println("Print testTiempo.copia(): ${testTiempo.copiar()}")

    println("************************************")

    // Prueba del metodo .copiar(t:Tiempo) con el testTiempo2
    val copiaTestTiempo2 = testTiempo2.copiar(testTiempo2)
    println("Print testTiempo2: $testTiempo2")
    println("Print copiaTestTiempo: $copiaTestTiempo2")

    println("************************************")

    // Pueba metodo sumar(t:Tiempo)
    println("testTiempo : $testTiempo")
    println("testTiempo2: $testTiempo2")
    println("Suma de testTiempo y testTiempo2: ${testTiempo.sumar(testTiempo2)}")
}










/**
 * Ejercicio 4.6¶
 * Realizar el ejercicio 1 de Conjuntos de los "Ejercicios básicos con Kotlin" (Ejercicio 3.3.1) orientado a objetos.
 *
 * Te proporciono algunas pistas de una posible solución:
 *
 * /**
 * * Clase Compra
 * * @param cliente cliente que realizo la compra
 * * @param dia dia de la compra
 * * @param monto monto de la compra
 * * @constructor Crea una compra con cliente, dia y monto
 * */
 * /**
 *  * Clase Cliente
 *  * @param nombre nombre del cliente
 *  * @param domicilio domicilio del cliente
 *  * @constructor Crea un cliente con nombre y domicilio
 *  */
 *  ```
 * /** * Clase Domicilio
 * * @param calle calle del domicilio
 * * @param numero numero del domicilio
 * * @constructor Crea un domicilio con calle y numero
 * */ ```
 *
 * La clase Domicilio tendrá un método llamado dirCompleta()que retornará el domicilio completo con la calle y el número.
 *
 * Las clases Compra, Cliente y Domicilio se establecerán como data class, es decir, delante de class incluirán el modificador data en la declaración de dichas clases.
 *
 * Para entender mejor que es una data class, visualizar el siguiente enlace: Data classes
 *
 * /**
 *  * Clase RepositorioCompras
 *  * @constructor Crea un repositorio de compras
 *  */
 * La clase RepositorioCompras tendrá un método para agregar una compra al repositorio y un método domicilios para retornar los domicilios de cada cliente al cual se le debe enviar una factura de compra. Esta función retorna una estructura que contenga cada domicilio una sola vez.
 */


data class Compra(val cliente: Cliente, val dia: Int, val monto: Double){
}

data class Cliente(val nombre: String, val domicilio: String){
}

data class Domicilio(val calle: String, val numero: Int, ) {
    fun dirCompleta(): String{
        return ("Domicilio - Calle: ${this.calle} numero: ${this.numero}")
    }
}

class RepositorioCompras(){
    val listaCompras = mutableListOf<Compra>()
    fun agregarCompra(cliente: Cliente, dia: Int, monto: Double){
        listaCompras.add( Compra(cliente, dia, monto) )
    }

    fun domicilios(){
        val domiciliosUnicos = mutableSetOf<String>()
        for (compra in listaCompras){
            domiciliosUnicos.add(compra.cliente.domicilio)
            //println("Cliente: ${compra.cliente.nombre}, domicilio: ${compra.cliente.domicilio}, dia: ${compra.dia} monto: ${compra.monto}")

        }
        println(domiciliosUnicos)
    }
}


fun ejercicioBascio6(){

    val cliente1 = Cliente("Antonio", "Calle juan juanito 3")
    val cliente2 = Cliente("Pedrto", "Calle perinavo 38")
    val cliente3 = Cliente("Alberto", "Calle areola 1")


    val compra1 = Compra(cliente1, 3, 34.4)
    val compra2 = Compra(cliente1, 55, 566.7)
    val compra3 = Compra(cliente2, 2, 18.7)
    val compra4 = Compra(cliente2, 15, 69.7)
    val compra5 = Compra(cliente3, 6, 8.7)


    val repositorio = RepositorioCompras()
    repositorio.agregarCompra(compra1.cliente, compra1.dia, compra1.monto)
    repositorio.agregarCompra(compra2.cliente, compra2.dia, compra2.monto)
    repositorio.agregarCompra(compra3.cliente, compra3.dia, compra3.monto)
    repositorio.agregarCompra(compra4.cliente, compra4.dia, compra4.monto)
    repositorio.agregarCompra(compra5.cliente, compra5.dia, compra5.monto)
    repositorio.domicilios()

}


/**
 * Ejercicio 4.7¶
 * Se quiere crear una clase Cuenta la cual se caracteriza por tener asociado un número de cuenta y un saldo disponible.
 *
 * Además, se puede consultar el saldo disponible, recibir abonos y realizar pagos.
 *
 * Crear también una clase Persona, que se caracteriza por un DNI y una lista de cuentas bancarias.
 *
 * La Persona puede tener asociada hasta 3 cuentas bancarias, y debe tener un método que permita añadir cuentas (hasta 3 el máximo permitido).
 *
 * También debe contener un método que devuelva si la persona es morosa (si tienen alguna cuenta con saldo negativo).
 *
 * En el programa principal, instanciar un objeto Persona con un DNI cualquiera, así como dos objetos cuenta, una sin saldo inicial y otra con 700 euros. La persona recibe la nómina mensual, por lo que ingresa 1100 euros en la primera cuenta, pero tiene que pagar el alquiler de 750 euros con la segunda. Imprimir por pantalla si la persona es morosa.
 *
 * Posteriormente hacer una transferencia de una cuenta a otra (de forma que todos los saldos sean positivos) y mostrar por pantalla el estado de la persona.
 */



class Cuenta(val numCuenta: Int, var saldoDispo: Double){


    fun consultarSaldo(): Double{
        return this.saldoDispo
    }

    fun recibirAbono(cantidad: Double){
        println("Has recibido billetes: ${cantidad}€")
        this.saldoDispo += cantidad
    }

    fun realizarPago(cantidad: Double){
        this.saldoDispo -= cantidad
        println("Has pagado: ${cantidad}€")
    }
}

class PersonaEj7(val dni: Int, var listaCuentas: MutableList<Cuenta>){
    fun aniadirCuenta(cuenta: Cuenta){
        if (this.listaCuentas.size < 3){
            this.listaCuentas.add(cuenta)
        }
        else{
            print("Error - Limite de cuentas alcanzado (3)")
        }
    }

    fun comprobarMorosidad(): Boolean{
        for (cuenta in this.listaCuentas){
            if (cuenta.saldoDispo < 0 ){
                return true
            }
        }
        return false
    }
}

fun ejercicioBascio7(){
    val cuenta1 = Cuenta(1, 0.0)
    val cuenta2 = Cuenta(2, 700.0)

    val persona1 = PersonaEj7(1234567, mutableListOf())

    // Añadirle a la persona las cuentas
    persona1.aniadirCuenta(cuenta1)
    persona1.aniadirCuenta(cuenta2)

    // Recibe la nomina en la primera cuenta
    cuenta1.recibirAbono(1100.0)

    // Paga alquiler con la segunda
    cuenta2.realizarPago(750.0)

    /// Comprobar morosidad
    if (persona1.comprobarMorosidad()) println("Morosa ") else println("No morosa")

    //Transferencia de una cuenta a otra para saldar morosidad
    cuenta2.recibirAbono((cuenta1.consultarSaldo()) / 2)

    // Mostrar estado de la persona

    for (cuenta in persona1.listaCuentas){
        println("Cuenta ${cuenta.numCuenta} Saldo: ${cuenta.saldoDispo}")
    }
}



/**
 * Ejercicio 4.8¶
 * Queremos mantener una colección de los libros que hemos ido leyendo, poniéndoles una calificación según nos haya gustado más o menos al leerlo.
 *
 * Para ello, crear la clase Libro, cuyos atributos son el título, el autor, el número de páginas y la calificación que le damos entre 0 y 10.
 *
 * Posteriormente, crear una clase ConjuntoLibros, que almacena un conjunto de libros (con un vector de un tamaño fijo). Se pueden añadir libros que no existan (siempre que haya espacio), eliminar libros por título o autor, mostrar por pantalla los libros con la mayor y menor calificación y, por último, mostrar un contenido de todo el conjunto.
 *
 * En el programa principal realizar las siguientes operaciones: crear dos libros, añadirlos al conjunto, eliminarlos por los dos criterios (título y autor) hasta que el conjunto esté vacío, volver a añadir un libro y mostrar el contenido final.
 */



class Libro(val titulo: String, val autor: String, val numPags: Int, val calificacion: Double){


}


class ConjuntoLibros(val setLibros: MutableSet<Libro>){

}


fun ejercicioBascio8(){

}