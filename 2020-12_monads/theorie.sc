val o = Option("Hälo")
o.map(identity) == identity(o)
o.map(_.toUpperCase().toLowerCase()) ==
  o.map(_.toUpperCase).map(_.toLowerCase)