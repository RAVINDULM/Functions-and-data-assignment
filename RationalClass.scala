class RationalClass ( x:Int , y:Int ) {

    require(y>0 , "Denominator Must be positive")

    private def gcd( a:Int , b:Int ):Int = {
      if ( b == 0 ) a
      else if ( b > a ) gcd( b , a )
      else gcd( b, a%b )
    }


    private val g = gcd( Math.abs(x) , y )

    val numer = x/g

    val deno = y/g

    def this( x : Int ) = this( x , 1 )

    def +( that : RationalClass ) :RationalClass = new RationalClass( this.numer * that.deno + that.numer * this.deno  , this.deno * that.deno )

    def neg : RationalClass = new RationalClass( -this.numer , this.deno )

    def -( that : RationalClass ) : RationalClass = this + that.neg

    def *( that : RationalClass ) : RationalClass = new RationalClass( this.numer * that.numer , this.deno * that.deno )

    def /( that : RationalClass ) : RationalClass = new RationalClass( this.numer * that.deno , this.deno * that.numer )

    @Override
    override def toString() : String = {

      deno match {

        case x if x==1 => numer.toString

        case _ => numer + "/" + deno

      }

    }

}
