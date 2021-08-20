object RationalObj extends App{
    val w = new RationalClass(5)
    val x = new RationalClass(5,6)
    val y = new RationalClass(7,9)
    val z = new RationalClass(4,7)
    val t = x - y - z
    println(t)
}
