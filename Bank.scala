object Bank extends App {

  var bank : List[AccountClass] = List( new AccountClass("981351123v" , 2 , -2000) , new AccountClass("985678123v" , 3 , 3000) )

  val find = ( n : Int , b : List[AccountClass]) => b.filter( x => x.accountNumber.equals( n ))

  val overdraft = ( b : List[AccountClass] ) => b.filter( x => x.balance < 0)

  val balance = ( b: List[AccountClass] ) => b.map( x => (x,x.balance) ).reduce( (a , c) => ( c._1 , a._2 + c._2) )

  val interest = ( b : List[AccountClass] ) => b.map( x => {
    x.balance match {
      case a if a >= 0 => x.deposite (x.balance*0.05)
      case _ => x withdraw Math.abs(x.balance) * 0.01

    }
    x
  })


  println("Bank " + bank )
  println()
  println("Find " + find( 2 , bank) )
  println()
  println("Overdraft " + overdraft( bank ) )
  println()
  println("Balance " + balance( bank )._2 )
  println()

  bank = interest( bank )

  println("Bank " + bank )
  println()
  println("Balance " + balance( bank )._2 )
  println()

}
