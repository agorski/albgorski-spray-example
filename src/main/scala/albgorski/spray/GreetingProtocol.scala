package albgorski.spray

import spray.json._

case class Greeting(id: Int, name: String)

object GreetingProtocol extends DefaultJsonProtocol {
  implicit val greetingFormat = jsonFormat2(Greeting)
}
