package albgorski.spray

import akka.actor.Actor
import spray.http.MediaTypes
import spray.httpx.marshalling._
import spray.routing._

class RestService extends Actor with ApiService {
  def actorRefFactory = context

  def receive = runRoute(routes)
}

trait GreetingHanlder extends HttpService {

  import GreetingProtocol._
  import spray.httpx.SprayJsonSupport._

  val orderGetOrPutMethod =
    path("greeting" / IntNumber) & (get | put) & extract(_.request.method) & extract(_.request.uri)

  val greetingRoute =
    orderGetOrPutMethod { (id, m, u) =>
      respondWithMediaType(MediaTypes.`application/json`) {
        complete(marshal(Greeting(id, "text")))
      }
    }

}

trait ApiService extends HttpService with GreetingHanlder {
  val routes =
    greetingRoute

}