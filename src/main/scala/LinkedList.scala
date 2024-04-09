class LinkedList() {
  var head: Node = null

  def addToStart(s: String): Unit = {
    val node: Node = new Node(s, head)
    head = node
  }

  def getSize(): Int = {
    if(this.head == null){
      return 0
    }
    val lst: LinkedList = new LinkedList
    lst.head = this.head.next

    return 1 + lst.getSize()
  }

  override def toString(): String = {
    return s"List content (size ${getSize()}) : ${toStringRight()}"
  }

  private def toStringRight(): String = {
    if (this.head == null) {
      return null
    }
    val lst: LinkedList = new LinkedList
    lst.head = this.head.next

    return s"${this.head.item} -> ${lst.toStringRight()}"
  }

  def removeFirstElement(): Unit = {
    if(this.head != null){
      this.head = this.head.next
    }
  }

  def getLastElement(): Node = {
    if(this.head == null){
      return null
    }

    if(this.head.next == null){
      return this.head
    }
    val lst: LinkedList = new LinkedList
    lst.head = this.head.next

    return lst.getLastElement()
  }

  def addToEnd(element: String): Unit = {
    if(this.head == null){
      this.head = new Node(element, null)
    }
    else if(this.head.next == null){
      this.head.next = new Node(element, null)
    }
    else{
      val lst: LinkedList = new LinkedList
      lst.head = this.head.next
      lst.addToEnd(element)
    }
  }

  def isPresent(e: String): Boolean = {
    if(this.head == null) {
      return false
    }
    else if(this.head.item == e){
      return true
    }
    else{
      val lst: LinkedList = new LinkedList
      lst.head = this.head.next
      return lst.isPresent(e)
    }
  }

  def findElement(s:String): Node = {
    var current: Node = head

    while (current != null){
      if(current.item == s){
        return current
      }
      current = current.next
    }
    return null
  }

  def swapElements(e1: String, e2: String): Unit = {
    val firstElem: Node = findElement(e1)
    val secondElem: Node = findElement(e2)

    if(firstElem != null && secondElem != null){
      val tmp: String = firstElem.item
      firstElem.item = secondElem.item
      secondElem.item = tmp
    }
  }

  def removeLastElement(): Unit = {
    var previous: Node = head
    if(previous == null){
      return
    }

    var current: Node = head.next
    if(current == null){
      head = null
      return
    }

    while(current.next != null){
      current = current.next
      previous = previous.next
    }
    previous.next = null
  }

  def removeElement(e: String): Unit = {
    var elem: Node = findElement(e)

    if(elem == null){
      return
    }

    if (elem eq head){
      head = head.next
      return
    }

    var current = head
    while (current.next != elem){
      current = current.next
    }
    current.next = elem.next
  }

  def insertAfter(before: String, after: String): Unit = {
    var elem: Node = findElement(before)
    if(elem == null){
      return
    }

    var nextNode: Node = new Node(after, elem.next)
    elem.next = nextNode
  }
}

object LinkedList extends App {
  var flightList:LinkedList = new LinkedList()
  println(flightList)
  flightList.addToStart("Rome")
  println(flightList)
  flightList.addToStart("Paris")
  println(flightList)
  flightList.addToStart("Tokyo")
  println(flightList)
  println(flightList.insertAfter("Paris", "Londres"))
  println(flightList)
  println(flightList.isPresent("Londres"))
}
