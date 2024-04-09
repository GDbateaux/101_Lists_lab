class Node(var item: String, var next: Node) {

}

object Node extends App{
  var node: Node = new Node("Tokyo", new Node("Paris", new Node("Milan", null)))
}
