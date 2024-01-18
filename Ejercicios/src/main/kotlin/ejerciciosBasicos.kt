import java.nio.DoubleBuffer
import javax.print.attribute.standard.PagesPerMinute
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


class Rectangulo(val altura: Double, val base: Double ){

    fun calcularArea(): Double{
        return this.base * this.altura
    }

    fun calcularPerimetro(): Double{
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
 */

// PREGUNTAR POR QUE SI NO SE HACEN PRIVATE LOS ATROBUTOS, DA ERROR EN EL GET Y SET
class Coche(
    private var color: String,
    private var marca: String,
    private var modelo: String,
    private var numCaballos: Int,
    private var numPuertas: Int,
    private var matricula: String
)   {

    // GETTERS / SETTERS


    fun getColor():String = this.color
    fun setColor(color2: String){
        this.color = color2
    }


    fun getMarca(): String = this.marca
    fun setMarca(marca2: String){
        this.marca = marca2
    }


    fun getModelo(): String = this.modelo
    fun setModelo(modelo2: String){
        this.modelo = modelo2
    }

    fun getNumCaballos():Int = this.numCaballos
    fun setNumCaballos(numCaballos2: Int){
        //require(numCaballos2 in 70..700) {"ERROR: Los caballos deben estar entre 70-700"}
        if (numCaballos2 !in 70..700) throw IllegalArgumentException ("ERROR: Los caballos deben estar entre 70-700")
        this.numCaballos = numCaballos2
    }


    // TODO: Hacer try catch, mostrar el error, y devolver un valor por defecto cuando el introducido no sea correcto
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



/**
 * Ejercicio 4.5¶
 * Crear una clase Tiempo, con atributos hora, minuto y segundo, que pueda ser construida indicando los tres atributos, sólo hora y minuto o sólo la hora (si no se indica, el valor de minuto o segundo será 0).
 *
 * Crear el método toString() para mostrar el tiempo en formato: XXh XXm XXs.
 *
 * En el programa principal, debe solicitar por teclado hora, minuto y segundo de forma que se puedan omitir los segundos o los minutos (y segundos, claro) e instancie la clase Tiempo mostrando su valor.
 */

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


data class Compra(val cliente: String, val dia: Int, val monto: Double){
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
    fun agregarCompra(){
        listaCompras.add(Compra)
    }

    fun domicilios(){

    }
}


fun ejercicioBascio6(){
    val compra1 = Compra("Antonio", 40, 23.45)
    val cliente1 = Cliente("Antonio", "Calle juan juanito 3")
    val domicilio = Domicilio("C/ Tomasito tomatero", 4)




}



// EJERCICIO DIEGO

