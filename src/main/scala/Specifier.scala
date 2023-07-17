object Specifier {

    def convertToString()= {

    }
    def offsetSpecifier(gay: Any): Int = {
      gay match {
        case "Byte" => 1
        case "Short" => 2
        case "Int" => 4
        case "Long" => 8
      }
    }
}
