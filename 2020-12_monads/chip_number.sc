// Liste aller Haustiernamen

case class Pet(name: Option[String])
case class Child(name: String, pets: List[Pet])
case class Parent(name: String, children: List[Child])

def getChipNumber(petName: String): Option[String] = {
  petName match {
    case "charly" => Some("12345")
    case "betty" => Some("23456")
    case "bobby" => Some("34567")
    case _ => None
  }
}

val parents = List(
  Parent("Judith", List(Child("Toby", List(Pet(None), Pet(None))))),
  Parent("Nicco", List(Child("James", List(Pet(Some("charly")), Pet(Some("betty")))))),
  Parent("Marie", List(Child("Mira", List(Pet(Some("bobby")), Pet(Some("deafy")))))),
)

val allChipNumbers = parents
  .flatMap(_.children)
  .flatMap(_.pets)
  .flatMap(_.name)
  .map(_.toUpperCase())
  .flatMap(getChipNumber)