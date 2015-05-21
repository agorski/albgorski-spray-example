package albgorski.spray

import akka.actor.{Props, ActorSystem}
import akka.io.IO
import com.typesafe.config.{Config, ConfigFactory}
import spray.can.Http

object Main extends App {
  implicit val system = ActorSystem("albgorski-spray")

  private val config: Config = ConfigFactory.load("application.conf")


  val myListener = system.actorOf(Props[RestService], "rest-service")

  IO(Http) ! Http.Bind(myListener, interface = "localhost", port = config.getInt("host.port"))
}