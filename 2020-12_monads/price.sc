import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

def findProduct(search: String): Future[String] = Future.successful("product-key")
def getPrice(productId: String): Future[String] = Future.failed(new Exception("blöb"))
def addTaxes(country: String)(productId: String): Future[String] = Future.successful("1.33€")
def convertPrice(currency: String)(productId: String): Future[String] = Future.successful("1.44" + currency)

val country = "US"
val currency = "$"

val futureResult =
  findProduct("IPhone 12")
    .flatMap(getPrice)
    .flatMap(addTaxes(country))
    .flatMap(convertPrice(currency))

val result = Await.ready(futureResult , Duration.Inf)