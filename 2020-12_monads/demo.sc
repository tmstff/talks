def mkAddress(i: Int): String = {
  s"Addr: Street Number $i, 23456 Town"
}

def cleanAddress(address: String): Option[String] = {
  if (address.contains("1")) {
    Some(address.stripPrefix("Addr: "))
  } else {
    None
  }
}

Option("a")

val addr = (1 to 10)
  .map(mkAddress)
  .map(identity)
  .flatMap(cleanAddress)
  .map(_.toUpperCase())
