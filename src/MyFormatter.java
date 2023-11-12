
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter{

    @Override
    public String format(LogRecord record) {
        return "{\n\"ThreadID\": \""+record.getLongThreadID()+"\","
            + "\n\"ClassName\": \""+record.getSourceClassName()+"\","
            + "\n\"MethodName\": \""+record.getSourceMethodName()+"\","
            + "\n\"Date\": \""+new Date(record.getMillis())+"\","
            + "\n\"Message\": \""+record.getMessage()+"\"\n}\n";
    }
}
