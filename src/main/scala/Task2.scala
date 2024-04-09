object Task2 extends App {
  val lst: List[String] = List[String]("Robin", "Paul", "Pierre", "Jean")

  println(lst.mkString(","))

  if(lst.contains("Paul")){
    println("Paul is in the sequence")
  }

  var newLst: List[String] = lst.diff(List("Paul"))
  println(newLst.mkString(","))
}
