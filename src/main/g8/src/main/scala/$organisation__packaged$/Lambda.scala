package $organisation$

$if(use_input_stream.truthy)$
import com.amazonaws.services.lambda.runtime.{Context, RequestStreamHandler}
import java.io.{InputStream, OutputStream}

class Lambda extends RequestStreamHandler {
  override def handleRequest(input: InputStream, output: OutputStream, context: Context): Unit = {
$elseif(use_event.truthy)$
import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.amazonaws.services.lambda.runtime.events.SQSEvent

class Lambda extends RequestHandler[SQSEvent, Unit] {
  override def handleRequest(event: SQSEvent, context: Context): Unit = {
$endif$
  }
}
