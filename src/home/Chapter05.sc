class Person {
  private var privateAge = 0

  def age = privateAge

  def age_=(newvalue: Int) = {
    privateAge = newvalue
  }

}

var fred = new Person
fred.age = 30
fred.age = 21