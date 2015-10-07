import scala.collection.mutable.ArrayBuffer

var lst = scala.collection.mutable.LinkedList(1, -2 , 7 ,0, -9);
var cur = lst;
while(cur != Nil){
  if (cur.elem < 0){
    cur.elem = 0;
  }
  cur = cur.next;
}

cur = lst;
while ( cur != Nil && cur.next != Nil){
  cur.next = cur.next.next
  cur = cur.next
}

Vector(1, 2, 3) :+ 5
val numbers = Set(1, 2, 3)


var numberVector = Vector(1,2,3)
