class Node(var item : String,var  next : Node){

}

class LinkedList(){
  var head : Node = null
  def addToStart(s : String) : Unit = {
    head = new Node(s, head)
  }

  def getSize() : Int = {
    var current: Node = head
    var count: Int = 0
    while (current != null) {
      count += 1
      current = current.next
    }
    count
  }

  def removeFirstElement() : Unit = {
    if (head != null) {
      head = head.next
    }
  }

  def getLastElement(): Node = {
    var current: Node = head
    var last: Node = head

    while (current != null) {
      last = current
      current = current.next
    }

    last
  }


  def addToEnd(e: String): Unit = {
    if (head != null) {
      getLastElement().next = new Node(e, null)
    } else {
      addToStart(e)
    }
  }

  def isPresent(e: String): Boolean = {
    var current: Node = head

    while (current != null) {
      if (current.item.equals(e)) {
        return true
      }
      current = current.next
    }

    false
  }

  def findElement(e: String): Node = {
    var current: Node = head

    while (current != null) {
      if (current.item == e) {
        return current
      }
      current = current.next
    }

    null
  }

  def swapElements(e1: String, e2: String): Unit = {
    val n1: Node = findElement(e1)
    val n2: Node = findElement(e2)

    if (n1 != null && n2 != null) {
      val tmp: String = n1.item
      n1.item = n2.item
      n2.item = tmp
    }
  }

  def removeLastElement(): Unit = {
    var current: Node = head
    var previous: Node = null
    while (current != null) {
      if (current.next == null) { // Normal case
        if (previous != null) {
          previous.next = null
        }
        else { // Special case if the list contains a single element
          head = null
        }
        return
      }
      previous = current
      current = current.next
    }
  }

  def removeElement(s: String): Unit = {
    val i = findElement(s)
    if (i == null) return
    if (i eq head) {
      head = head.next
      return
    }
    var j = head
    while (j.next != i) {
      j = j.next
    }
    j.next = i.next
  }

  def insertAfter(a: String, b: String): Unit = {
    val tmp = findElement(a)
    if (tmp == null) {
      return
    }
    val newNode = new Node(b, tmp.next)
    tmp.next = newNode
  }

override def toString(): String = {
    var s: String = s"List content (size ${getSize()})"

    var current: Node = head
    while (current != null) {
      s += " -> " + current.item
      current = current.next
    }

    s + " -> null"
  }

}

object LinkedList extends App {
  val head : Node = new Node("Tokyo",new Node("Paris", new Node("Milan", null)))
  var flightList : LinkedList = new LinkedList()
  println(flightList)
  flightList.addToStart("Rome")
  println(flightList)
  flightList.addToStart("Paris")
  println(flightList)
  flightList.addToStart("Tokyo")
  println(flightList)

}