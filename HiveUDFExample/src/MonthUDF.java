import java.util.Calendar;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;


public class MonthUDF extends UDF {
public int evaluate(Text value) {
Calendar cal = Calendar.getInstance();
if (value == null) {
return 1;
} else {
cal.setTimeInMillis(Long.valueOf(value.toString()) * 1000);
return cal.get(Calendar.MONTH) + 1;
}
}
}
