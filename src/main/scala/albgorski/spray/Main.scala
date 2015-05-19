package albgorski.spray

import akka.actor.{Props, ActorSystem}
import akka.io.IO
import spray.can.Http

object Main extends App {
  implicit val system = ActorSystem("albgorski-spray")

  val myListener = system.actorOf(Props[RestService], "rest-service")

  IO(Http) ! Http.Bind(myListener, interface = "localhost", port = 8080)
}